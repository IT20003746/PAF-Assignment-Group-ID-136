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

import model.Unit;

@Path("/Unit")
public class UnitService {
	Unit UnitObj = new Unit();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readUnit() {
		return UnitObj.readUnit();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUnit(@FormParam("uAccNo") String uAccNo,			
	 @FormParam("uDate") String uDate,
	 @FormParam("UnitAmount") String UnitAmount,
	 @FormParam("PriceForPerUnit") String PriceForPerUnit,
	 @FormParam("Total") String Total)
	{
	 String output = UnitObj.insertUnit (uAccNo, uDate, UnitAmount, PriceForPerUnit, Total);
	return output;
	}
}
