package ifs_devices.resources;

import ifs_devices.model.Edit_Mode;
import ifs_devices.model.Request;
import ifs_devices.service.RequestService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
    public List<Request> getRequest() {/*Get all requested devices from the device table*/
        System.out.println("/request call");
        return requestService.getRequest();
    }

    @POST
    public Request addRequest(Request request) {/*Add new request to the device table*/
        System.out.println("/request call");
        return requestService.addRequest(request);
    }

    @PUT
    @Path("/{reqID}") /*Update changes done to the requested device and save in device table*/
    public Request updateEmployee(@PathParam("reqID") int id, Request request) {
        request.setId(id);
        return requestService.updateRequest(request);
    }

    @PUT
    @Path("/edit/{reqID}") /*Update for available device and save in device table*/
    public Edit_Mode editDetails(@PathParam("reqID") int id, Edit_Mode edit_Mode) {
        edit_Mode.setRequest_ID(id);
        return requestService.editDetails(edit_Mode);
    }

    @DELETE
    @Path("/{reqID}")
    public String deleteRequest(@PathParam("reqID") int id) {/*Add new request to the device table*/
        System.out.println("/request delete call");
        return requestService.deleteRequest(id);
    }
}
