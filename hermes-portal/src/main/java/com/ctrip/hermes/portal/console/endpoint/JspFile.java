package com.ctrip.hermes.portal.console.endpoint;

public enum JspFile {
	VIEW("/jsp/console/endpoint.jsp"),

	;

	private String m_path;

	private JspFile(String path) {
		m_path = path;
	}

	public String getPath() {
		return m_path;
	}
}
