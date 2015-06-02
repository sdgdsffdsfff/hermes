package com.ctrip.hermes.metaserver.build;

import java.util.ArrayList;
import java.util.List;

import org.unidal.dal.jdbc.configuration.AbstractJdbcResourceConfigurator;
import org.unidal.lookup.configuration.Component;

import com.ctrip.hermes.metaserver.config.MetaServerConfig;
import com.ctrip.hermes.metaserver.consumer.ActiveConsumerListHolder;
import com.ctrip.hermes.metaserver.consumer.ConsumerAssignmentHolder;
import com.ctrip.hermes.metaserver.consumer.ConsumerLeaseHolder;
import com.ctrip.hermes.metaserver.consumer.DefaultConsumerLeaseAllocationStrategyLocator;
import com.ctrip.hermes.metaserver.consumer.DefaultOrderedConsumeConsumerPartitionAssigningStrategy;
import com.ctrip.hermes.metaserver.consumer.OrderedConsumeConsumerLeaseAllocationStrategy;
import com.ctrip.hermes.metaserver.meta.MetaHolder;

public class ComponentsConfigurator extends AbstractJdbcResourceConfigurator {

	@Override
	public List<Component> defineComponents() {
		List<Component> all = new ArrayList<Component>();

		all.add(A(MetaHolder.class));

		all.add(A(MetaServerConfig.class));

		all.add(A(ActiveConsumerListHolder.class));
		all.add(A(DefaultOrderedConsumeConsumerPartitionAssigningStrategy.class));

		all.add(A(ConsumerLeaseHolder.class));

		all.add(A(OrderedConsumeConsumerLeaseAllocationStrategy.class));

		all.add(A(DefaultConsumerLeaseAllocationStrategyLocator.class));

		all.add(A(ConsumerAssignmentHolder.class));

		return all;
	}

	public static void main(String[] args) {
		generatePlexusComponentsXmlFile(new ComponentsConfigurator());
	}
}
