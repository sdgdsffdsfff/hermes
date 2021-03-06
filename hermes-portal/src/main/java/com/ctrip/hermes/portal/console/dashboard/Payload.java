package com.ctrip.hermes.portal.console.dashboard;

import com.ctrip.hermes.portal.console.ConsolePage;
import org.unidal.web.mvc.ActionContext;
import org.unidal.web.mvc.ActionPayload;
import org.unidal.web.mvc.payload.annotation.FieldMeta;

public class Payload implements ActionPayload<ConsolePage, Action> {
	private ConsolePage m_page;

	@FieldMeta("op")
	private Action m_action;

	@FieldMeta("topic")
	private String m_topic;

	@FieldMeta("broker")
	private String m_broker;

	@FieldMeta("client")
	private String m_client;

	public String getBroker() {
		return m_broker;
	}

	public void setBroker(String broker) {
		m_broker = broker;
	}

	public String getClient() {
		return m_client;
	}

	public void setClient(String client) {
		m_client = client;
	}

	public String getTopic() {
		return m_topic;
	}

	public void setTopic(String topic) {
		m_topic = topic;
	}

	public void setAction(String action) {
		m_action = Action.getByName(action, Action.TOPIC);
	}

	@Override
	public Action getAction() {
		return m_action;
	}

	@Override
	public ConsolePage getPage() {
		return m_page;
	}

	@Override
	public void setPage(String page) {
		m_page = ConsolePage.getByName(page, ConsolePage.DASHBOARD);
	}

	@Override
	public void validate(ActionContext<?> ctx) {
		if (m_action == null) {
			m_action = Action.TOPIC;
		}
	}
}
