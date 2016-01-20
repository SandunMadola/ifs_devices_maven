/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.resources;

import ifs_devices.model.BorrowDevice;

import ifs_devices.service.BorrowDeviceService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nedilk
 */

@Path("/borrowNow")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class BorrowDeviceResource {
    

    BorrowDeviceService borrowDeviceService = new BorrowDeviceService();

    @GET
    public BorrowDevice GetBorrowRequest() {
        System.out.println("/borrowNow GET call");
        return borrowDeviceService.getBorrowRequest();
    }

    @POST
    public BorrowDevice addBorrowRequest(BorrowDevice borrowRequest) {
        System.out.println("/borrowNow POST call");
        return borrowDeviceService.addBorrowRequest(borrowRequest);
    }
}
