package com.theice.rest.ws.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import com.theice.rest.ws.dto.SweepStatus;
import com.theice.rest.ws.dto.SweepStatusData;

public class SweepStatusService implements Serializable {

	private static final long serialVersionUID = 1L;
	private Logger log;
	//ResourceBundle rb = ResourceBundle.getBundle("restdemo");

/**
 * This method reads a sweep file and determines if there are any comparisons that have differences
 * param file - sweep text file
 * param status - type of result; either all, good, or bad
 * return - the sweep status object; a summary of the sweep name, sweep file url, and the status of the file
 */

	public SweepStatus readTextFile(File file, String server, String region, String directory) {
		System.out.println("Entering SweepStatusService.readTextFile");
		
		SweepStatusData data = new SweepStatusData();
		String link = "http://capgui1-devvm:8080" + data.getUrlPath();
		
		System.out.println("the name is " + file.getName());
		String fileName = this.stripExtension(file.getName());
		System.out.println("the stripped name is " +fileName);
		
		//capgui1-devvm link
		if(region.isEmpty()) {
			link += server + "/" + file.getName();
		} else {
			link += server + "/" + region + "/" + file.getName();
		}

		String currentDayRecordsProd = "";
		String currentDayRecordsTest = "";
		String primaryKeysProd = "";
		String primaryKeysTest = "";
		String missingFileTest = "";
		
		//ResourceBundle rb = ResourceBundle.getBundle("restdemo");
		//System.out.println("the directory is " + rb.getString("digestDirectory"));
		
		SweepStatus theStatus = new SweepStatus(fileName, link, server, region, true);
		
        // Prepare a Scanner that will "scan" the document
        Scanner opnScanner;
		try {
			opnScanner = new Scanner(file);
			
			// Read each line in the file
	        while( opnScanner.hasNext() ) {
	            // Read each line and display its value
	        	String myString = opnScanner.nextLine();
	        	
	        	//current day records prod
	        	if (myString.contains("Total number of current day records in the production file")) {
	        		String[] tempRecordsArray = myString.split(" ");
	        		currentDayRecordsProd = tempRecordsArray[10];
	        		//System.out.println("records prod is " + tempRecordsArray[10]);
	        	}
	        	//current day records test
	        	if (myString.contains("Total number of current day records in the test file")) {
	        		String[] tempRecordsArray2 = myString.split(" ");
	        		currentDayRecordsTest = tempRecordsArray2[10];
	        		//System.out.println("records test is " + tempRecordsArray2[10]);
	        	}
	        	
	        	//primary keys prod
	        	if (myString.contains("Total number of PrimaryKeys in the production file not in the test file")) {
	        		String[] tempRecordsArray3 = myString.split(" ");
	        		primaryKeysProd = tempRecordsArray3[13];
	        		//System.out.println("primary keys prod is " + tempRecordsArray3[13]);
	        	}
	        	//primary keys test
	        	if (myString.contains("Total number of PrimaryKeys in the test file not in the production file")) {
	        		String[] tempRecordsArray4 = myString.split(" ");
	        		primaryKeysTest = tempRecordsArray4[13];
	        		//System.out.println("primary keys test is " + tempRecordsArray4[13]);
	        	}
	        	
	        	//do not match 0 test
	        	if (myString.contains("Total number of") && myString.contains("do not match")) {
	        		
	        		String[] tempMatchArray = myString.split(" ");
	        		if (!tempMatchArray[tempMatchArray.length-1].equals("0")) {
	        			System.out.println("match result: " + myString);
	        			theStatus.setErrorStatus(false);
		        		break;
	        		}
	        	} 
	        	
	        	//missing file test
	        	if (myString.contains("ERROR Production File") || myString.contains("ERROR Test File")) {
        			System.out.println("missing file result: " + myString);
        			theStatus.setErrorStatus(false);
	        		break;
	        	} 
	        	
	        	//timestamp mismatch test
	        	if (myString.contains("umber of Other timestamps that fail 2 second tolerance ")) {
	        		
	        		String[] tempMatchArray = myString.split(" ");
	        		if (!tempMatchArray[tempMatchArray.length-1].equals("0")) {
	        			System.out.println("timestamp mismatch result: " + myString);
	        			theStatus.setErrorStatus(false);
		        		break;
	        		}
	        	} 
	        }
	            
	        //do checks
	        if (!currentDayRecordsProd.equals(currentDayRecordsTest)) {
	        	System.out.println("current day records mismatch: " + currentDayRecordsProd + " != " + currentDayRecordsTest);
	        	theStatus.setErrorStatus(false);
	        }
	        
	        if (!primaryKeysProd.equals(primaryKeysTest)) {
	        	System.out.println("primary keys mismatch: " + primaryKeysProd + " != " + primaryKeysTest);
	        	theStatus.setErrorStatus(false);
	        }
	        
	    	// De-allocate the memory that was used by the scanner
	        opnScanner.close();
		} catch (FileNotFoundException fne) {
			// TODO Auto-generated catch block
			fne.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("the sweep file name is " + theStatus.getSweepName() + " and the link is " + theStatus.getLinkUrl());
		if (theStatus.isErrorStatus()) {
			System.out.println("sweep compare good");
		} else {
			System.out.println("sweep compare bad");
		}

		return theStatus;
		
	}
	
	public ArrayList<SweepStatus> readTextFiles(String[] directoryList, String status) {
		System.out.println("Entering SweepStatusService.readTextFiles");
		
		SweepStatusData data = new SweepStatusData();
		ArrayList<SweepStatus> sweepStatusResults = new ArrayList<SweepStatus>();
		ArrayList<SweepStatus> filteredSweepStatusResults = new ArrayList<SweepStatus>();
		String server = "";
		String region = "";
		
		try {
		//String directoryName = "C:\\Users\\gscarfo\\Desktop";		
			//for(String directoryName : directoryList) {
			for(int i = 0; i < directoryList.length; i++) {
				
				//determin server and region
				if(directoryList[i].contains("/")) {
					String[] tempString = directoryList[i].split("/");
					server = tempString[0];
					region = tempString[1];
					
				} else {
					server = directoryList[i];
				}
				System.out.println("server is " + server + " and region is " + region);
				String fullPathName = data.getRootPath() + directoryList[i] + "/";
				File[] fileList = this.getListOfAllTxtFiles(fullPathName);
				System.out.println("the path is " + fullPathName);
				for(File myFile : fileList) {
					//readTextFile(File file, String server, String region, String status, String directory)
					sweepStatusResults.add(this.readTextFile(myFile, server, region, directoryList[i]));
				}
				
				System.out.println("the size of the result set is " + Integer.toString(sweepStatusResults.size()));	
				this.printSweepStatus(sweepStatusResults);
			}
		} catch(NullPointerException npe) {
			System.out.println("directory list empty: " + npe.getMessage());
		} catch(Exception e) {
			System.out.println("an exception was thrown: " + e.getMessage());
		}
		
		//filter results on status setting = all is all; good is true; bad is false
		//if (status == null || status.equals("all")) {
			if (status.equals("pass") || status.equals("fail")) {
				if(status.equals("pass")) {
					filteredSweepStatusResults = this.filterSweepStatusByIsError(sweepStatusResults, true);
				} else {
					filteredSweepStatusResults = this.filterSweepStatusByIsError(sweepStatusResults, false);
				}		
			//} 
			} else {
				//present all
				filteredSweepStatusResults = sweepStatusResults;
			}
		
		return filteredSweepStatusResults;
	}
	
	/**
	 * This method used to strip the file extension off of the file name
	 * @param str
	 * @return
	 */
	public String stripExtension(String str) {
		System.out.println("Entering SweepStatusService.stripExtension");

	   if (str == null) return null;
	   
	   // Get position of last '.'.
	   int pos = str.lastIndexOf(".");

	   // If there wasn't any '.' just return the string as is.
	   if (pos == -1) return str;

	   // Otherwise return the string, up to the dot.
       return str.substring(0, pos);
   }
	
	public File[] getListOfAllTxtFiles(String directoryName) {
		System.out.println("Entering SweepStatusService.getListOfAllTxtFiles");
		
		File dir = new File(directoryName);
		File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
		return files;
	}
	
	public void printSweepStatus(ArrayList<SweepStatus> results) {
		System.out.println("Entering SweepStatusService.printSweepStatus");
		
		for (SweepStatus ss : results) {
			System.out.println(ss.getSweepName() + " " + ss.getLinkUrl());
			if (ss.isErrorStatus()) {
				System.out.print("good\n\n");
			} else {
				System.out.println("bad\n\n");
			}
		}
	}
	
	public ArrayList<SweepStatus> filterSweepStatusByIsError(ArrayList<SweepStatus> results, boolean errorStatus) {
		System.out.println("Entering SweepStatusService.filterSweepStatusByIsError");
		
		ArrayList<SweepStatus> theResults = new ArrayList<>();
		for (SweepStatus ss : results) {
			if (ss.isErrorStatus() == errorStatus) {
				theResults.add(ss);
			} 
		}
		
		return theResults;
	}
}
