package com.theice.rest.ws.resources;

import java.io.File;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.theice.rest.ws.dto.SweepStatus;
import com.theice.rest.ws.dto.SweepStatusData;
import com.theice.rest.ws.services.SweepStatusService;

@Path("/status")
public class SweepStatusResource {
	
	private SweepStatusService service = new SweepStatusService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSweepStatus(@PathParam("fileName") File fileName, @PathParam("server") String server, @PathParam("region") String region, @PathParam("directory") String directory) {
		
		//readTextFile(File file, String server, String region, String status, String directory)
		
		SweepStatus sweepStatus = new SweepStatus();
		
		if (fileName.isFile() && fileName.canRead()) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		sweepStatus = service.readTextFile(fileName, server, region, directory);
		
		return Response.ok().entity(sweepStatus).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all")
	public Response getAllSweepStatus() {
		
		ArrayList<SweepStatus> sweepStatusList = new ArrayList<SweepStatus>();
		SweepStatusData data = new SweepStatusData();
		String[] directoryList = data.getDirectoryList();
		
		if (directoryList.length == 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		sweepStatusList = service.readTextFiles(directoryList, "all");
		return Response.ok().entity(sweepStatusList).build();
	}

}
