package com.ctrip.hermes.core.message.retry;

/**
 * @author Leo Liang(jhliang@ctrip.com)
 *
 */
public class NoRetryPolicy implements RetryPolicy {

	@Override
	public int getRetryTimes() {
		return 0;
	}

	@Override
	public long nextScheduleTimeMillis(int retryTimes, long currentTimeMillis) {
		throw new UnsupportedOperationException();
	}

}
