package com.ctrip.hermes.consumer.integration;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import io.netty.channel.Channel;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import org.unidal.lookup.ComponentTestCase;

import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricFilter;
import com.ctrip.hermes.consumer.ConsumerType;
import com.ctrip.hermes.consumer.build.BuildConstants;
import com.ctrip.hermes.consumer.engine.bootstrap.strategy.BrokerConsumptionStrategy;
import com.ctrip.hermes.consumer.engine.config.ConsumerConfig;
import com.ctrip.hermes.consumer.engine.monitor.PullMessageResultMonitor;
import com.ctrip.hermes.consumer.engine.notifier.ConsumerNotifier;
import com.ctrip.hermes.consumer.integration.assist.LeaseAnswer;
import com.ctrip.hermes.consumer.integration.assist.PullMessageAnswer;
import com.ctrip.hermes.consumer.integration.assist.TestBrokerLongPollingConsumptionStrategy;
import com.ctrip.hermes.consumer.integration.assist.TestConsumerConfig;
import com.ctrip.hermes.consumer.integration.assist.TestMetaHolder;
import com.ctrip.hermes.consumer.integration.assist.TestMetaService;
import com.ctrip.hermes.core.bo.Tpg;
import com.ctrip.hermes.core.env.ClientEnvironment;
import com.ctrip.hermes.core.lease.Lease;
import com.ctrip.hermes.core.lease.LeaseManager;
import com.ctrip.hermes.core.message.codec.MessageCodec;
import com.ctrip.hermes.core.meta.MetaService;
import com.ctrip.hermes.core.meta.internal.MetaProxy;
import com.ctrip.hermes.core.service.SystemClockService;
import com.ctrip.hermes.core.transport.command.PullMessageCommand;
import com.ctrip.hermes.core.transport.endpoint.EndpointClient;
import com.ctrip.hermes.core.transport.endpoint.EndpointManager;
import com.ctrip.hermes.meta.entity.Endpoint;
import com.ctrip.hermes.meta.entity.Meta;
import com.ctrip.hermes.meta.transform.DefaultSaxParser;
import com.ctrip.hermes.metrics.HermesMetricsRegistry;

public class BaseConsumerIntegrationTest extends ComponentTestCase {

	public static final String TEST_TOPIC = "test_topic";

	public static final String TEST_GROUP = "group1";

	@Mock
	protected EndpointClient m_endpointClient;

	@Mock
	protected TestMetaHolder m_metaHolder;

	@Mock
	protected MetaProxy m_metaProxy;

	@Mock
	protected Channel m_channel;

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		configureStubComponents();
	}

	@After
	@Override
	public void tearDown() throws Exception {
		HermesMetricsRegistry.getMetricRegistry().removeMatching(new MetricFilter() {
			@Override
			public boolean matches(String name, Metric metric) {
				return true;
			}
		});
		resetAnswers();
		super.tearDown();
	}

	private void resetAnswers() {
		LeaseAnswer.reset();
		PullMessageAnswer.reset();
	}

	private void configureStubComponents() throws Exception {
		defineComponent(ConsumerConfig.class, TestConsumerConfig.class);
		defineComponent(MetaService.class, TestMetaService.class);

		defineComponent(BrokerConsumptionStrategy.class, ConsumerType.LONG_POLLING.toString(),
		      TestBrokerLongPollingConsumptionStrategy.class)//
		      .req(ConsumerNotifier.class)//
		      .req(EndpointManager.class)//
		      .req(MetaService.class)//
		      .req(LeaseManager.class, BuildConstants.CONSUMER)//
		      .req(ConsumerConfig.class)//
		      .req(SystemClockService.class)//
		      .req(MessageCodec.class)//
		      .req(ClientEnvironment.class)//
		      .req(PullMessageResultMonitor.class);

		((TestMetaService) lookup(MetaService.class)).setMetaProxy(m_metaProxy).setMetaHolder(m_metaHolder);
		((TestBrokerLongPollingConsumptionStrategy) lookup(BrokerConsumptionStrategy.class,
		      ConsumerType.LONG_POLLING.toString())).setEndpointClient(m_endpointClient);

		when(m_metaHolder.getMeta()).thenReturn(loadLocalMeta());
		when(m_channel.writeAndFlush(any(Object.class))).thenReturn(null);
	}

	protected Meta loadLocalMeta() throws Exception {
		String fileName = getClass().getSimpleName() + "-meta.xml";
		InputStream in = getClass().getResourceAsStream(fileName);

		if (in == null) {
			throw new RuntimeException(String.format("File %s not found in classpath.", fileName));
		} else {
			try {
				return DefaultSaxParser.parse(in);
			} catch (Exception e) {
				throw new RuntimeException(String.format("Error parse meta file %s", fileName), e);
			}
		}
	}

	protected void brokerActions4PollMessageCmd(Answer<?> answer) {
		doAnswer(answer)//
		      .when(m_endpointClient)//
		      .writeCommand(any(Endpoint.class), //
		            any(PullMessageCommand.class), //
		            anyLong(), //
		            any(TimeUnit.class));
	}

	protected void metaProxyActions4LeaseOperation(Answer<?> acquireAnswer, Answer<?> renewAnswer) {
		doAnswer(acquireAnswer)//
		      .when(m_metaProxy)//
		      .tryAcquireConsumerLease(any(Tpg.class), any(String.class));

		doAnswer(renewAnswer)//
		      .when(m_metaProxy)//
		      .tryRenewConsumerLease(any(Tpg.class), any(Lease.class), any(String.class));
	}
}