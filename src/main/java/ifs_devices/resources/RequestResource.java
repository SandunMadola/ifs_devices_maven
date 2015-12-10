/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.resources;

import ifs_devices.model.Request;
import ifs_devices.service.RequestService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    public Request getRequest() {
        System.out.println("/request call");
        return requestService.getRequest();
    }

    @POST
    public Request addRequest(Request request) {
        System.out.println("/request call");
        return requestService.addRequest(request);
    }
}
