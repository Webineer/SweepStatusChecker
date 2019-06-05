package com.theice.rest.ws.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SweepStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	private String sweepName;
	private String linkUrl;
	private String region;
	private String server;
	private boolean errorStatus;
	
	//default constructor
	public SweepStatus() {		
	}
	
	public SweepStatus(String sweepName, String linkUrl, String server, String region, boolean errorStatus) {
		this.setSweepName(sweepName);
		this.setLinkUrl(linkUrl);
		this.setServer(server);
		this.setRegion(region);
		this.setErrorStatus(errorStatus);
	}
	
	
	public String getSweepName() {
		return sweepName;
	}
	
	public void setSweepName(String sweepName) {
		this.sweepName = sweepName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
	
	public boolean isErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(boolean errorStatus) {
		this.errorStatus = errorStatus;
	}

}
