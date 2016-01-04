/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.resources;

import ifs_devices.service.CancelService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nedilk
 */
@Path("/cancel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CancelResource {
    
   CancelService cancelService = new CancelService();
  
    @DELETE
    @Path("/{transaction_ID}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteTransaction(@PathParam("transaction_ID") int id) {
        return cancelService.deleteTransaction(id);
    }
    
}
