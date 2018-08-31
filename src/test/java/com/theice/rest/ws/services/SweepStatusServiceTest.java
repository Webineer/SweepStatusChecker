package com.theice.rest.ws.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.theice.rest.ws.dto.SweepStatus;
import com.theice.rest.ws.services.SweepStatusService;

@Ignore
public class SweepStatusServiceTest {
	
	SweepStatusService cut = new SweepStatusService();
	
	File testFileNot = new File("myText.txt");
	File testFileEmpty = new File("C:\\Users\\gscarfo\\Desktop\\myNoText.txt");
	File testFile = new File("C:\\Users\\gscarfo\\Desktop\\myText.txt");
	File realFile = new File("C:\\Users\\gscarfo\\Desktop\\Baltic.Close.txt");
	File realFile2 = new File("C:\\Users\\gscarfo\\Desktop\\Austria_Vienna.Close.txt");
	String statusBad = "bad";
	String statusGood = "good";
	String statusAll = "all";
	
	String[] directoryList = new String[] { "C:\\Users\\gscarfo\\Desktop\\" };
	String[] subDirectoryList = new String[] {"", "OnboardingDocs"};
	String[] directoryListEmpty = new String[] { };
	String[] directoryListNull = null;
	
	String server = "Desktop";
	String region = "OnboardingDocs";
	
	SweepStatus ss1 = new SweepStatus("SweepName", "http://www.cnn.com", server, region, true);
	SweepStatus ss2 = new SweepStatus("SweepName2", "http://www.usatoday.com",server, region, true);
	SweepStatus ss3 = new SweepStatus("SweepName3", "http://www.wsj.com",server, region, true);
	SweepStatus ss4 = new SweepStatus("SweepName4", "http://www.wapost.com",server, region, false);
	
	ArrayList<SweepStatus> testResults = new ArrayList<SweepStatus>();
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadTextFile() {
		//readTextFile(File file, String server, String region, String status, String directory)
		SweepStatus ss = cut.readTextFile(testFile, server, region, directoryList[0]);
		assertNotNull(ss.getSweepName());
		assertTrue(ss.isErrorStatus());
	}
	
	@Ignore
	@Test(expected = FileNotFoundException.class)
	public void testReadTextFileFileNotFound() {
		SweepStatus ss = cut.readTextFile(testFile, server, region, directoryList[0]);;
	}
	
	@Test
	public void testReadTextFileEmpty() {
		SweepStatus ss = cut.readTextFile(testFile, server, region, directoryList[0]);;
		assertNotNull(ss.getSweepName());
		assertTrue(ss.isErrorStatus());
	}
	
	@Test
	public void testReadTextFileRealFileBad() {
		SweepStatus ss = cut.readTextFile(realFile, server, region, directoryList[0]);;
		assertNotNull(ss.getSweepName());
		assertFalse(ss.isErrorStatus());
	}
	
	@Test
	public void testReadTextFileRealFileGood() {
		SweepStatus ss = cut.readTextFile(realFile2, server, region, directoryList[0]);;
		assertNotNull(ss.getSweepName());
		assertTrue(ss.isErrorStatus());
	}
	
	@Test
	public void testGetListOfAllTxtFiles() {
		String directoryName = "C:\\Users\\gscarfo\\Desktop";
		File[] fileList = cut.getListOfAllTxtFiles(directoryName);
		System.out.println("the first value is " + fileList[0].getName());
		assertNotNull(fileList.toString());
		assertNotNull("first listing is null", fileList[0]);
		assertTrue(fileList.length > 0);
	}
	
	@Ignore
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetListOfAllTxtFilesNoFiles() {
		String directoryName = "C:\\Users\\gscarfo\\Desktop\\OnboardingDocs";
		File[] fileList = cut.getListOfAllTxtFiles(directoryName);
	}
	
	@Test
	public void testReadTextFiles() {
		ArrayList<SweepStatus> results = cut.readTextFiles(directoryList, statusAll);
		assertTrue(results.size() > 0);
		assertNotNull(results.get(0));
	}
	
	@Ignore
	@Test(expected = IndexOutOfBoundsException.class)
	public void testReadTextFilesEmptyDirList() {
		ArrayList<SweepStatus> results = cut.readTextFiles(directoryListEmpty, statusAll);
	}
	
	@Test(expected = NullPointerException.class)
	public void testReadTextFilesNullDirList() {
		ArrayList<SweepStatus> results = cut.readTextFiles(directoryListNull, statusAll);
	}
	
	@Test
	public void testFilterSweepStatusByIsErrorTrue() {
		testResults.add(ss1);
		testResults.add(ss2);
		testResults.add(ss3);
		testResults.add(ss4);
		ArrayList<SweepStatus> myResults = cut.filterSweepStatusByIsError(testResults, true);
		assertNotNull(myResults);
		assertTrue(myResults.size() == 3);
		
	}
	
	@Test
	public void testFilterSweepStatusByIsErrorFalse() {
		testResults.add(ss1);
		testResults.add(ss2);
		testResults.add(ss3);
		testResults.add(ss4);
		ArrayList<SweepStatus> myResults = cut.filterSweepStatusByIsError(testResults, false);
		assertNotNull(myResults);
		assertTrue(myResults.size() == 1);
		
	}
}
