package com.theice.rest.ws.beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.theice.rest.ws.dto.SweepStatus;
import com.theice.rest.ws.dto.SweepStatusData;
import com.theice.rest.ws.services.SweepStatusService;

@ManagedBean(name = "viewBean")
@RequestScoped
public class SweepViewBean {
	
	private static final long serialVersionUID = 1L;

	public SweepStatusService service = new SweepStatusService();
	public SweepStatusData data = new SweepStatusData();
	private ArrayList<SweepStatus> sweepStatusByServerAndRegion = this.getSweepStatusByServerAndRegion();
	private String environment;
	private String area;
	private String status;
	private String viewStatus;
	private String errorMessage;
	
	public SweepViewBean() {
		//default constructor
	}
	
	public void setSweepStatusByServerAndRegion(ArrayList<SweepStatus> sweepStatusByServerAndRegion) {
		this.sweepStatusByServerAndRegion = sweepStatusByServerAndRegion;
	}

	public ArrayList<SweepStatus> getSweepStatusByServerAndRegion() {	
		System.out.println("Entering SweepStatusBean.getSweepStatusByServerAndRegion");
		
		ArrayList<SweepStatus> sweepStatusList = new ArrayList<SweepStatus>();
		String[] directoryList = data.getDirectoryList();
		ArrayList<String> resultDirList = new ArrayList<String>();
		ArrayList<String> altResultDirList = new ArrayList<String>();
		
		String pathPrefix = data.getRootPath();
		
		//determine which directories have been selected
		String searchString = pathPrefix + this.getEnvironment();
		for(String dir : directoryList) {
			if (dir.contains(searchString)) {
				System.out.println("dir is " + dir);
				resultDirList.add(dir);
			}
		}
		//convert arraylist to array
		String[] tempArray = new String[resultDirList.size()];
		tempArray = resultDirList.toArray(tempArray);
		
		if (!(this.getArea() == null)) {
			//just the area of interest
			for(String dir : tempArray) {
				if (dir.contains(this.getArea())) {
					altResultDirList.add(dir);
				}
			}
			//convert arraylist to array
			String[] tempArray2 = new String[altResultDirList.size()];
			tempArray2 = altResultDirList.toArray(tempArray2);
			sweepStatusList = service.readTextFiles(tempArray2, this.getStatus());
		} else {
			sweepStatusList = service.readTextFiles(tempArray, this.getStatus());
		}
			
		return sweepStatusList;
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

	public String getViewStatus() {
		return viewStatus;
	}

	public void setViewStatus(String viewStatus) {
		this.viewStatus = viewStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
