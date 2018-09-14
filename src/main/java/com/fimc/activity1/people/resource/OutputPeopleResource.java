package com.fimc.activity1.people.resource;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/people")
public class OutputPeopleResource implements Serializable {	
	
	ArrayList<InputPeopleResponse> list = new ArrayList();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response people(PeopleResultRequest request) {
		
		if(StringUtils.isEmpty(request.getFirstName())||StringUtils.isEmpty(request.getLastName())||StringUtils.isEmpty(request.getBirthDate())) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST)
			 .entity("All fields are required.").type( MediaType.TEXT_PLAIN).build();

		}else {
			
			InputPeopleResponse inputPeopleResponse = new InputPeopleResponse();
			
			SimpleDateFormat Date = new SimpleDateFormat("MM-dd-yyyy");
			
			inputPeopleResponse.setFirstName(String.format(" %s",request.getFirstName()));
			inputPeopleResponse.setLastName(String.format(" %s",request.getLastName()));
			inputPeopleResponse.setBirthDate(Date.format(request.getBirthDate()));
			list.add(inputPeopleResponse);
			return Response.status(HttpServletResponse.SC_CREATED).entity(HttpServletResponse.SC_CREATED).build();

		}
	}	
	
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response peopleAll(PeopleResultRequest request) {
			return Response.ok().entity(list).build();
		}
}


