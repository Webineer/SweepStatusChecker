package com.theice.rest.ws.dto;

import java.io.Serializable;

public class SweepStatusData  implements Serializable {
	
	private String rootPath = "/var/opt/data/capcmpr/apache/";
	private String urlPath = "/";
	private String[] compareList = new String[] {
			"adhoc",
			"ALLPR_C4Z01_M2ZA1",
			"Asia_Specials",
			"DV_PR",
			"EOD",			
			"m2za1_pta",
			"pta_pr1",
			"pta_ptb",
			"PT_PR",		
			"QA_PR",
			"unload_compares"
	};
	
	private String[] directoryList = new String[] {
			"adhoc",
			"ALLPR_C4Z01_M2ZA1/Africa",
			"ALLPR_C4Z01_M2ZA1/Asia",
			"ALLPR_C4Z01_M2ZA1/Canada",
			"ALLPR_C4Z01_M2ZA1/Dataline",
			"ALLPR_C4Z01_M2ZA1/Europe",
			"ALLPR_C4Z01_M2ZA1/Middle_East",
			"ALLPR_C4Z01_M2ZA1/Nasdaq_BB_OOTC_MF",
			"ALLPR_C4Z01_M2ZA1/Native_NUTP_NYAM",
			"ALLPR_C4Z01_M2ZA1/Oceania",
			"ALLPR_C4Z01_M2ZA1/sigma",
			"ALLPR_C4Z01_M2ZA1/South_America",
			"ALLPR_C4Z01_M2ZA1/US_Indicies",
			"ALLPR_C4Z01_M2ZA1/US_NYSE_Bonds",
			"ALLPR_C4Z01_M2ZB1/Asia",
			"ALLPR_C4Z01_M2ZB1/Canada",
			"ALLPR_C4Z01_M2ZB1/Dataline",
			"ALLPR_C4Z01_M2ZB1/Europe",
			"ALLPR_C4Z01_M2ZB1/Middle_East",
			"ALLPR_C4Z01_M2ZB1/Nasdaq_BB-OOTC_MF",
			"ALLPR_C4Z01_M2ZB1/Native_NUTP_NYAM",
			"ALLPR_C4Z01_M2ZB1/Oceania",
			"ALLPR_C4Z01_M2ZB1/sigma",
			"ALLPR_C4Z01_M2ZB1/South_America",
			"ALLPR_C4Z01_M2ZB1/US_Indicies",
			"ALLPR_C4Z01_M2ZB1/US_NYSE_Bonds",
			"Asia_Specials",
			"DV_PR/Africa",
			"DV_PR/Asia",
			"DV_PR/Canada",
			"DV_PR/Dataline",
			"DV_PR/Europe",
			"DV_PR/Middle_East",
			"DV_PR/Nasdaq_BB_OOTC_MF",
			"DV_PR/Native_NUTP_NYAM",
			"DV_PR/Oceania",
			"DV_PR/OPRA",
			"DV_PR/sigma",
			"DV_PR/South_America",
			"DV_PR/US_Indicies",
			"DV_PR/US_NYSE_Bonds",
			"EOD/Africa",
			"EOD/Asia",
			"EOD/Canada",
			"EOD/Europe",
			"EOD/Mideast",
			"EOD/Oceania",
			"EOD/SouthAmerica",
			"m2za1_pta",
			"pta_pr1",
			"pta_ptb",
			"PT_PR",
			"PT_PR/Africa",
			"PT_PR/Asia",
			"PT_PR/Canada",
			"PT_PR/Dataline",
			"PT_PR/Europe",
			"PT_PR/Middle_East",
			"PT_PR/Nasdaq_BB_OOTC_MF",
			"PT_PR/Native_NUTP_NYAM",
			"PT_PR/Oceania",
			"PT_PR/OPRA",
			"PT_PR/sigma",
			"PT_PR/South_America",
			"PT_PR/US_Indicies",
			"PT_PR/US_NYSE_Bonds",
			"QA_PR/",
			"QA_PR/Africa",
			"QA_PR/Asia",
			"QA_PR/Canada",
			"QA_PR/Dataline",
			"QA_PR/Europe",
			"QA_PR/Middle_East",
			"QA_PR/Nasdaq_BB_OOTC_MF",
			"QA_PR/Native_NUTP_NYAM",
			"QA_PR/Oceania",
			"QA_PR/OPRA",
			"QA_PR/sigma",
			"QA_PR/South_America",
			"QA_PR/US_Indicies",
			"QA_PR/US_NYSE_Bonds",
			"unload_compares/M2ZA_C4Z01",
			"unload_compares/M2ZA_M2ZB",
			"unload_compares/PR_DV",
			"unload_compares/PR_PT",
			"unload_compares/PR_QA"
		};
	
	private String[] directoryListALLPR_C4Z01_M2ZA1 = new String[] {
			"ALLPR_C4Z01_M2ZA1/Africa",
			"ALLPR_C4Z01_M2ZA1/Asia",
			"ALLPR_C4Z01_M2ZA1/Canada",
			"ALLPR_C4Z01_M2ZA1/Dataline",
			"ALLPR_C4Z01_M2ZA1/Europe",
			"ALLPR_C4Z01_M2ZA1/Middle_East",
			"ALLPR_C4Z01_M2ZA1/Nasdaq_BB_OOTC_MF",
			"ALLPR_C4Z01_M2ZA1/Native_NUTP_NYAM",
			"ALLPR_C4Z01_M2ZA1/Oceania",
			"ALLPR_C4Z01_M2ZA1/sigma",
			"ALLPR_C4Z01_M2ZA1/South_America",
			"ALLPR_C4Z01_M2ZA1/US_Indicies",
			"ALLPR_C4Z01_M2ZA1/US_NYSE_Bonds",
			"ALLPR_C4Z01_M2ZB1/Asia",
			"ALLPR_C4Z01_M2ZB1/Canada",
			"ALLPR_C4Z01_M2ZB1/Dataline",
			"ALLPR_C4Z01_M2ZB1/Europe",
			"ALLPR_C4Z01_M2ZB1/Middle_East",
			"ALLPR_C4Z01_M2ZB1/Nasdaq_BB-OOTC_MF",
			"ALLPR_C4Z01_M2ZB1/Native_NUTP_NYAM",
			"ALLPR_C4Z01_M2ZB1/Oceania",
			"ALLPR_C4Z01_M2ZB1/sigma",
			"ALLPR_C4Z01_M2ZB1/South_America",
			"ALLPR_C4Z01_M2ZB1/US_Indicies",
			"ALLPR_C4Z01_M2ZB1/US_NYSE_Bonds"
		};
	
	private String[] directoryListDV_PR = new String[] {
			"DV_PR/Africa",
			"DV_PR/Asia",
			"DV_PR/Canada",
			"DV_PR/Dataline",
			"DV_PR/Europe",
			"DV_PR/Middle_East",
			"DV_PR/Nasdaq_BB_OOTC_MF",
			"DV_PR/Native_NUTP_NYAM",
			"DV_PR/Oceania",
			"DV_PR/OPRA",
			"DV_PR/sigma",
			"DV_PR/South_America",
			"DV_PR/US_Indicies",
			"DV_PR/US_NYSE_Bonds"
		};
	
	private String[] directoryListEOD = new String[] {
			"EOD/Africa",
			"EOD/Asia",
			"EOD/Canada",
			"EOD/Europe",
			"EOD/Mideast",
			"EOD/Oceania",
			"EOD/SouthAmerica"
		};
	
	private String[] directoryListPT_PR = new String[] {
			"PT_PR",
			"PT_PR/Africa",
			"PT_PR/Asia",
			"PT_PR/Canada",
			"PT_PR/Dataline",
			"PT_PR/Europe",
			"PT_PR/Middle_East",
			"PT_PR/Nasdaq_BB_OOTC_MF",
			"PT_PR/Native_NUTP_NYAM",
			"PT_PR/Oceania",
			"PT_PR/OPRA",
			"PT_PR/sigma",
			"PT_PR/South_America",
			"PT_PR/US_Indicies",
			"PT_PR/US_NYSE_Bonds"
		};
	
	private String[] directoryListQA_PR = new String[] {
			"QA_PR",
			"QA_PR/Africa",
			"QA_PR/Asia",
			"QA_PR/Canada",
			"QA_PR/Dataline",
			"QA_PR/Europe",
			"QA_PR/Middle_East",
			"QA_PR/Nasdaq_BB_OOTC_MF",
			"QA_PR/Native_NUTP_NYAM",
			"QA_PR/Oceania",
			"QA_PR/OPRA",
			"QA_PR/sigma",
			"QA_PR/South_America",
			"QA_PR/US_Indicies",
			"QA_PR/US_NYSE_Bonds"
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

	public String[] getCompareList() {
		return compareList;
	}

	public void setCompareList(String[] compareList) {
		this.compareList = compareList;
	}

	public String[] getDirectoryListALLPR_C4Z01_M2ZA1() {
		return directoryListALLPR_C4Z01_M2ZA1;
	}

	public void setDirectoryListALLPR_C4Z01_M2ZA1(String[] directoryListALLPR_C4Z01_M2ZA1) {
		this.directoryListALLPR_C4Z01_M2ZA1 = directoryListALLPR_C4Z01_M2ZA1;
	}

	public String[] getDirectoryListDV_PR() {
		return directoryListDV_PR;
	}

	public void setDirectoryListDV_PR(String[] directoryListDV_PR) {
		this.directoryListDV_PR = directoryListDV_PR;
	}

	public String[] getDirectoryListEOD() {
		return directoryListEOD;
	}

	public void setDirectoryListEOD(String[] directoryListEOD) {
		this.directoryListEOD = directoryListEOD;
	}

	public String[] getDirectoryListPT_PR() {
		return directoryListPT_PR;
	}

	public void setDirectoryListPT_PR(String[] directoryListPT_PR) {
		this.directoryListPT_PR = directoryListPT_PR;
	}

	public String[] getDirectoryListQA_PR() {
		return directoryListQA_PR;
	}

	public void setDirectoryListQA_PR(String[] directoryListQA_PR) {
		this.directoryListQA_PR = directoryListQA_PR;
	}

/*	public String[] getSubDirectoryList() {
		return subDirectoryList;
	}

	public void setSubDirectoryList(String[] subDirectoryList) {
		this.subDirectoryList = subDirectoryList;
	}*/

}
