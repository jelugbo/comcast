package com.stockapp.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/stockapp")
public class JSONService {

	@GET
	@Path("/get")
	@Produces("application/json")
	public Stocks getStockInJSON() {

		Stocks stock = new Stocks();
		stock.setName("NASDAQ");
		stock.setQty(999);
		stock.setOpt("BUY");
		return stock; 

	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response stockAppAction(Stocks stock) {

		String result = "Transaction created : " + stock;
		return Response.status(201).entity(result).build();
		
	}
	
}