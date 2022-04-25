package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Schedule;

@Path("/Schedules")

public class ScheduleService {

	Schedule scheduleObj = new Schedule();
	

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return scheduleObj.readSchedule();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertSchedule(

			
			@FormParam("sPeriod") String sPeriod, @FormParam("sTotHrs") String sTotHrs,
			@FormParam("sFromTime") String sFromTime, @FormParam("sToTime") String sToTime,
			@FormParam("sArea") String sArea, @FormParam("sSub") String sSub,
			@FormParam("sProvince") String sProvince) {
		String output = scheduleObj.insertSchedule(sPeriod, sTotHrs, sFromTime, sToTime, sArea, sSub, sProvince);
		return output;
	}

	
	
}