package com.theice.rest.ws.beans;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.validation.constraints.NotNull;

import com.theice.rest.ws.dto.SweepStatus;
import com.theice.rest.ws.dto.SweepStatusData;
import com.theice.rest.ws.services.SweepStatusService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "compareBean")
@SessionScoped
public class SweepStatusBean {
	private static final long serialVersionUID = 1L;
	private Logger log;

	public SweepStatusService service = new SweepStatusService();
	public SweepStatusData data = new SweepStatusData();
	private ArrayList<SweepStatus> sweepStatusArrayList;
	//private ArrayList<SweepStatus> sweepStatusServer = this.getSweepStatusByServerAndRegion();
	@NotNull (message = "Please select an enviroment")
	private String environment;
	private String[] environments;
	@NotNull (message = "Please select an area")
	private String area;
	private String[] areas;
	private String status;
	private String viewStatus;
	private String errorMessage;

	public ArrayList<SweepStatus> getSweepStatusArrayList() {
		return sweepStatusArrayList;
		//return this.getAllSweepStatus();
	}

	public void setSweepStatusArrayList(ArrayList<SweepStatus> sweepStatusArrayList) {
		this.sweepStatusArrayList = sweepStatusArrayList;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getViewStatus() {
		return viewStatus;
	}

	public void setViewStatus(String viewStatus) {
		this.viewStatus = viewStatus;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String[] getEnvironments() {
		return environments;
	}

	public String[] getAreas() {
		return areas;
	}

	public void setAreas(String[] areas) {
		this.areas = areas;
	}

	public void setEnvironments(String[] environments) {
		this.environments = environments;
	}
	
	@PostConstruct
	public void init() {
		this.setEnvironments(this.getEnvironmentsList());
	}

	public ArrayList<SweepStatus> getAllSweepStatus() {
		
		ArrayList<SweepStatus> ssList = new ArrayList<SweepStatus>();
		String[] directoryList = data.getDirectoryList();
		//String[] subDirectoryList = data.getSubDirectoryList();
		
		ssList = service.readTextFiles(directoryList, "all");
		
		return ssList;
	}
	
	public ArrayList<SweepStatus> getGoodSweepStatus() {
		
		ArrayList<SweepStatus> ssList = new ArrayList<SweepStatus>();
		String[] directoryList = data.getDirectoryList();
		
		ssList = service.readTextFiles(directoryList,"good");
		
		return ssList;
	}
	
	public ArrayList<SweepStatus> getBadSweepStatus() {
		
		ArrayList<SweepStatus> ssList = new ArrayList<SweepStatus>();
		String[] directoryList = data.getDirectoryList();
		
		ssList = service.readTextFiles(directoryList, "bad");
		
		return ssList;
	}
	
	public String theTest() {
		return "viewTest";
	}
	
	public String getSweepStatusByServerAndRegion() {	
		System.out.println("Entering SweepStatusBean.getSweepStatusByServerAndRegion");
		
		ArrayList<SweepStatus> ssList = new ArrayList<SweepStatus>();
/*		SweepStatus ss = new SweepStatus("sweepName", "http://www.cnn.com", "capgui1-devvm", "region", true);
		sweepStatusList.add(ss);
		
		System.out.println("environment is " + this.getEnvironment());
		System.out.println("area is " + this.getArea());
		System.out.println("status is " + this.getStatus());*/
		
		
		String[] directoryList = data.getDirectoryList();
		System.out.println("the orig directory list size is " + Integer.toString(directoryList.length));
		ArrayList<String> resultDirList = new ArrayList<String>();
		ArrayList<String> altResultDirList = new ArrayList<String>();
		
		String pathPrefix = data.getRootPath();
		System.out.println("path prefix is " + pathPrefix);
		
		//determine which directories have been selected
		String searchString = pathPrefix + this.getEnvironment();
		System.out.println("search string is " + searchString);
		for(String dir : directoryList) {
			if (dir.contains(this.getEnvironment())) {
				System.out.println("dir is " + dir);
				resultDirList.add(dir);
			}
		}
		
		System.out.println("the directory list size is " + Integer.toString(resultDirList.size()));
		
		//convert arraylist to array
		String[] tempArray = new String[resultDirList.size()];
		tempArray = resultDirList.toArray(tempArray);
		
		System.out.println("the area is set to " + this.getArea());
		
		if (!(this.getArea().equals("all"))) {
			//just the area of interest
			for(String dir : tempArray) {
				if (dir.contains(this.getArea())) {
					altResultDirList.add(dir);
					System.out.println("the dir is " + dir);
				}
			}
			System.out.println("the alt directory list size is " + Integer.toString(altResultDirList.size()));
			
			//convert arraylist to array
			String[] tempArray2 = new String[altResultDirList.size()];
			tempArray2 = altResultDirList.toArray(tempArray2);
			ssList = service.readTextFiles(tempArray2, this.getStatus());
		} else {
			ssList = service.readTextFiles(tempArray, this.getStatus());
		}
		System.out.println("the sweep status list size is " + Integer.toString(ssList.size()));
		if (ssList.size() > 0) {
			System.out.println("the first sweep status is " + ssList.get(0).getSweepName());
		}
		
		this.setSweepStatusArrayList(ssList);
			
		return "index.xhtml";
	}
	
	public String[] getEnvironmentsList() {
		System.out.println("Entering SweepStatusBean.getEnvironmentsList");
		
		String[] result;
		SweepStatusData data = new SweepStatusData();
		result = data.getCompareList();
		return result;
	}
	
	public void getAreasList(ValueChangeEvent e) {
		System.out.println("Entering SweepStatusBean.getAreasList");
		
		String[] result = data.getDirectoryList();
		SweepStatusData data = new SweepStatusData();
		
		//assign new value to localeCode
		String newValue = e.getNewValue().toString();
		
		System.out.println("the environment selection is " + newValue);
		this.setEnvironment(newValue);
		
		if(getEnvironment().equals("ALLPR_C4Z01_M2ZA1")) {
			result = data.getDirectoryListALLPR_C4Z01_M2ZA1();
		} else if(getEnvironment().equals("DV_PR")) {
			result = data.getDirectoryListDV_PR();
		} else if(getEnvironment().equals("EOD")) {
			result = data.getDirectoryListEOD();
		} else if(getEnvironment().equals("PT_PR")) {
			result = data.getDirectoryListPT_PR();
		} else if(getEnvironment().equals("QA_PR")) {
			result = data.getDirectoryListALLPR_C4Z01_M2ZA1();
		} else {
			result = null;
		}

		
		this.setAreas(result);
	}

}
