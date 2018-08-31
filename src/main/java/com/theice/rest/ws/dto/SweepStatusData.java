package com.theice.rest.ws.dto;

import java.io.Serializable;

public class SweepStatusData  implements Serializable {
	
	private String rootPath = "/home/prod/apache-tomcat-6.0.29/webapps/icedc/";
	private String urlPath = "/icedc/";
	private String[] directoryList = new String[] {
			"prod_pta",
			"prod_pta/Asia",
			"prod_pta/Canada",
			"prod_pta/Dataline",
			"prod_pta/Europe",
			"prod_pta/Middle_East",
			"prod_pta/Nasdaq_BB_And_OOTC_And_Mutual_Funds",
			"prod_pta/Native_NASDAQ",
			"prod_pta/Native_NYAM",
			"prod_pta/Oceania",
			"prod_pta/sigma",
			"prod_pta/South_America",
			"prod_pta/US_Indexes",
			"prod_pta/US_Mutual_Funds",
			"prod_pta/US_NYSE_Bonds",
			"prod_ptb",
			"prod_c4z-pr-capnp-01",
			"prod_c4z-pr-capnp-01/Asia",
			"prod_c4z-pr-capnp-01/Canada",
			"prod_c4z-pr-capnp-01/Dataline",
			"prod_c4z-pr-capnp-01/Europe",
			"prod_c4z-pr-capnp-01/Middle_East",
			"prod_c4z-pr-capnp-01/Nasdaq_BB_And_OOTC_And_Mutual_Funds",
			"prod_c4z-pr-capnp-01/Native_NASDAQ",
			"prod_c4z-pr-capnp-01/Native_NYAM",
			"prod_c4z-pr-capnp-01/Oceania",
			"prod_c4z-pr-capnp-01/sigma",
			"prod_c4z-pr-capnp-01/South_America",
			"prod_c4z-pr-capnp-01/US_Indexes",
			"prod_c4z-pr-capnp-01/US_Mutual_Funds",
			"prod_c4z-pr-capnp-01/US_NYSE_Bonds",
			"prod_m2z-pr-capnp-a1",
			"prod_m2z-pr-capnp-a1/Asia",
			"prod_m2z-pr-capnp-a1/Canada",
			"prod_m2z-pr-capnp-a1/Dataline",
			"prod_m2z-pr-capnp-a1/Europe",
			"prod_m2z-pr-capnp-a1/Middle_East",
			"prod_m2z-pr-capnp-a1/Nasdaq_BB_And_OOTC_And_Mutual_Funds",
			"prod_m2z-pr-capnp-a1/Native_NASDAQ",
			"prod_m2z-pr-capnp-a1/Native_NYAM",
			"prod_m2z-pr-capnp-a1/Oceania",
			"prod_m2z-pr-capnp-a1/sigma",
			"prod_m2z-pr-capnp-a1/South_America",
			"prod_m2z-pr-capnp-a1/US_Indexes",
			"prod_m2z-pr-capnp-a1/US_Mutual_Funds",
			"prod_m2z-pr-capnp-a1/US_NYSE_Bonds",
			"prod_m2z-pr-capnp-b1",
			"prod_m2z-pr-capnp-b1/Asia",
			"prod_m2z-pr-capnp-b1/Canada",
			"prod_m2z-pr-capnp-b1/Dataline",
			"prod_m2z-pr-capnp-b1/Europe",
			"prod_m2z-pr-capnp-b1/Middle_East",
			"prod_m2z-pr-capnp-b1/Nasdaq_BB_And_OOTC_And_Mutual_Funds",
			"prod_m2z-pr-capnp-b1/Native_NASDAQ",
			"prod_m2z-pr-capnp-b1/Native_NYAM",
			"prod_m2z-pr-capnp-b1/Oceania",
			"prod_m2z-pr-capnp-b1/sigma",
			"prod_m2z-pr-capnp-b1/South_America",
			"prod_m2z-pr-capnp-b1/US_Indexes",
			"prod_m2z-pr-capnp-b1/US_Mutual_Funds",
			"prod_m2z-pr-capnp-b1/US_NYSE_Bonds"
		};

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public SweepStatusData() {
		//default constructor
	}
	
	public String[] getDirectoryList() {
		return directoryList;
	}

	public void setDirectoryList(String[] directoryList) {
		this.directoryList = directoryList;
	}

/*	public String[] getSubDirectoryList() {
		return subDirectoryList;
	}

	public void setSubDirectoryList(String[] subDirectoryList) {
		this.subDirectoryList = subDirectoryList;
	}*/

}
