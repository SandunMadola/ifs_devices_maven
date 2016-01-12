/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.resources;

import ifs_devices.model.BorrowDevice;
import ifs_devices.service.BookedDatesService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nedilk
 */
@Path("/bookedDates")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class BookedDeviceResource {
    
    BookedDatesService bookedDatesService = new BookedDatesService();

    /**
     *
     * @return
     */
    @GET
    @Path("/{device_ID}")
    public List<BorrowDevice> GetbookedDates(@PathParam("device_ID") String id) {
        System.out.println("GetbookedDates() GET call");
        return bookedDatesService.getbookedDates(id);
    }
    
}
