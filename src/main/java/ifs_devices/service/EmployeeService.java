/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.service;

import ifs_devices.model.Employee;
import ifs_devices.model.Model;
import java.util.List;

/**
 *
 * @author sanmlk
 */
public class EmployeeService {

    public List<Employee> getAll() {
        System.out.println("came service");
        List<Employee> emp = null;
        try {
            Model model = new Model();
            emp = model.GetFeeds();            
        } catch (Exception e) {
            System.out.println("service error (DB)");
        }

        return emp;
    }
}
