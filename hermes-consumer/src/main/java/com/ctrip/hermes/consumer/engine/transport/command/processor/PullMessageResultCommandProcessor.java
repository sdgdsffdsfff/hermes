package com.ctrip.hermes.consumer.engine.transport.command.processor;

import java.util.Arrays;
import java.util.List;

import org.unidal.lookup.annotation.Inject;

import com.ctrip.hermes.consumer.engine.monitor.PullMessageResultMonitor;
import com.ctrip.hermes.core.transport.command.CommandType;
import com.ctrip.hermes.core.transport.command.processor.CommandProcessor;
import com.ctrip.hermes.core.transport.command.processor.CommandProcessorContext;
import com.ctrip.hermes.core.transport.command.v2.PullMessageResultCommandV2;

/**
 * @author Leo Liang(jhliang@ctrip.com)
 *
 */
public class PullMessageResultCommandProcessor implements CommandProcessor {

	@Inject
	private PullMessageResultMonitor m_messageResultMonitor;

	@Override
	public List<CommandType> commandTypes() {
		return Arrays.asList(CommandType.RESULT_MESSAGE_PULL_V2);
	}

	@Override
	public void process(CommandProcessorContext ctx) {
		PullMessageResultCommandV2 cmd = (PullMessageResultCommandV2) ctx.getCommand();
		cmd.setChannel(ctx.getChannel());
		m_messageResultMonitor.resultReceived(cmd);
	}

}
