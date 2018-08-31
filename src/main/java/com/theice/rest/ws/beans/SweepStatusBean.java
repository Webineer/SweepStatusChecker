package com.theice.rest.ws.beans;

import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import com.theice.rest.ws.dto.SweepStatus;
import com.theice.rest.ws.dto.SweepStatusData;
import com.theice.rest.ws.services.SweepStatusService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "compareBean", eager=true)
@RequestScoped
public class SweepStatusBean {
	private static final long serialVersionUID = 1L;

	public SweepStatusService service = new SweepStatusService();
	public SweepStatusData data = new SweepStatusData();
	private ArrayList<SweepStatus> sweepStatus;
	//private ArrayList<SweepStatus> sweepStatusServer = this.getSweepStatusByServerAndRegion();
	private String environment;
	private String area;
	private String status;
	private String viewStatus;
	private String errorMessage;

	public ArrayList<SweepStatus> getSweepStatus() {
		return sweepStatus;
		//return this.getAllSweepStatus();
	}

	public void setSweepStatus(ArrayList<SweepStatus> sweepStatus) {
		this.sweepStatus = sweepStatus;
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

	public ArrayList<SweepStatus> getAllSweepStatus() {
		
		ArrayList<SweepStatus> sweepStatusList = new ArrayList<SweepStatus>();
		String[] directoryList = data.getDirectoryList();
		//String[] subDirectoryList = data.getSubDirectoryList();
		
		sweepStatusList = service.readTextFiles(directoryList, "all");
		
		return sweepStatusList;
	}
	
	public ArrayList<SweepStatus> getGoodSweepStatus() {
		
		ArrayList<SweepStatus> sweepStatusList = new ArrayList<SweepStatus>();
		String[] directoryList = data.getDirectoryList();
		
		sweepStatusList = service.readTextFiles(directoryList,"good");
		
		return sweepStatusList;
	}
	
	public ArrayList<SweepStatus> getBadSweepStatus() {
		
		ArrayList<SweepStatus> sweepStatusList = new ArrayList<SweepStatus>();
		String[] directoryList = data.getDirectoryList();
		
		sweepStatusList = service.readTextFiles(directoryList, "bad");
		
		return sweepStatusList;
	}
	
	public String theTest() {
		return "viewTest";
	}
	
	public String getSweepStatusByServerAndRegion() {	
		System.out.println("Entering SweepStatusBean.getSweepStatusByServerAndRegion");
		
		ArrayList<SweepStatus> sweepStatusList = new ArrayList<SweepStatus>();
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
		System.out.println("path prefix is " + searchString);
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
			sweepStatusList = service.readTextFiles(tempArray2, this.getStatus());
		} else {
			sweepStatusList = service.readTextFiles(tempArray, this.getStatus());
		}
		
		this.setSweepStatus(sweepStatusList);
			
		return "index.xhtml";
	}

/*	public ArrayList<SweepStatus> getSweepStatusServer() {
		return sweepStatusServer;
	}

	public void setSweepStatusServer(ArrayList<SweepStatus> sweepStatusServer) {
		this.sweepStatusServer = sweepStatusServer;
	}*/


}
