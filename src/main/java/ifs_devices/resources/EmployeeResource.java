/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.resources;

import ifs_devices.service.EmployeeService;
import ifs_devices.model.Employee;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sanmlk
 */
@Path("/employee")
public class EmployeeResource {
    
    EmployeeService employeeService = new EmployeeService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployee() {  
        System.out.println("Inside the resource");
        return employeeService.getAll();
    }

}
