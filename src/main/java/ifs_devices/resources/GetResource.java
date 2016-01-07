/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.resources;

import ifs_devices.model.BorrowDevice;
import ifs_devices.service.GetDeviceService;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nedilk
 */
@Path("/get")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GetResource {
    
    GetDeviceService getDeviceService = new GetDeviceService();
    
    @PUT
    @Path("/{transaction_ID}")
    public BorrowDevice updateDevice(@PathParam("transaction_ID") int id, BorrowDevice updatedevice) {
        updatedevice.setTransaction_ID(id);
        return getDeviceService.updateDevice(updatedevice);
    }
    
}
