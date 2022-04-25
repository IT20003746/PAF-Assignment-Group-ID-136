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

	
	
	
}