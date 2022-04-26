package com.paf.rangeapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paf.rangeapi.models.range;
import com.paf.rangeapi.models.rangeDAO;

@Path("ranges")
public class rangeResource {

	rangeDAO rangeDAO = new rangeDAO();
	
	
	// Retrieve
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getRanges() {
		return rangeDAO.getRange();
	}
	
	// Insert
	@POST
	@Path("range")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertRange(@FormParam("rangeID") String rangeID, 
	 @FormParam("upperLimit") String upperLimit, 
	 @FormParam("lowerLimit") String lowerLimit, 
	 @FormParam("unitPrice") String unitPrice) {
		String output = rangeDAO.insertRange(rangeID, upperLimit, lowerLimit, unitPrice); 
		return output; 
	}
}
