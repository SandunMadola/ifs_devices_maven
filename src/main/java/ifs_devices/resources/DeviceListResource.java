/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.resources;

import ifs_devices.model.DeviceList;
import ifs_devices.service.DeviceListService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nedilk
 */
@Path("/devices")
public class DeviceListResource {
 
    DeviceListService deviceListService = new DeviceListService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DeviceList> getDevices() {  
        return deviceListService.getAll();
    }
}
