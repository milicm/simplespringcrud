package com.mm.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mm.domain.User;
import com.mm.exception.UserException;
import com.mm.service.UserService;
import com.mm.util.SimpleMessage;

@Component
@Path("user")
public class UserRest {

	@Autowired
	private UserService userService;

	@Path("register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(User user) {
		try {
			userService.save(user);
			return Response.status(Response.Status.OK).entity(new SimpleMessage("Saved")).build();
		} catch (UserException ex) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new SimpleMessage(ex.getMessage())).build();
		}
	}

	@Path("login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(User u) {
		try {
			User user = userService.login(u.getUsername(), u.getPassword());
			return Response.status(Response.Status.OK).entity(new SimpleMessage(user.getFirstName())).build();
		} catch (UserException ex) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new SimpleMessage(ex.getMessage())).build();
		}
	}

}
