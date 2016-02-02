/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.resources;

import ifs_devices.model.DeviceList;
import ifs_devices.service.SearchService;
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
@Path("/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class SearchResource {
    
    SearchService searchService = new SearchService();
    
    @GET
    @Path("/{value}")
    public List<DeviceList> getSearchDevices(@PathParam("value") String val) {
        System.out.println("/ getSearchResource call");
        return searchService.getAll(val);
    }
    
}
