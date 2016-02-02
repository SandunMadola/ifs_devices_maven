/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.resources;

import ifs_devices.model.Edit_Mode;
import ifs_devices.model.Request;
import ifs_devices.service.RequestService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sanmlk
 */
@Path("/request")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RequestResource {

    RequestService requestService = new RequestService();

    @GET
    public List<Request> getRequest() {
        System.out.println("/request call");
        return requestService.getRequest();
    }

    @POST
    public Request addRequest(Request request) {
        System.out.println("/request call");
        return requestService.addRequest(request);
    }

    @PUT
    @Path("/{reqID}")
    public Request updateEmployee(@PathParam("reqID") int id, Request request) {
        request.setId(id);
        return requestService.updateRequest(request);
    }
    
    @PUT
    @Path("/edit/{reqID}")
    public Edit_Mode editDetails(@PathParam("reqID") int id, Edit_Mode edit_Mode) {
        edit_Mode.setRequest_ID(id);
        return requestService.editDetails(edit_Mode);
    }
}
