/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.service;

import ifs_devices.model.Model;
import ifs_devices.model.Request;

/**
 *
 * @author sanmlk
 */
public class RequestService {
    
        public Request addRequest(Request request) {
        System.out.println("EmployeeService call");
        Request req = null;
        try {
            Model model = new Model();
            req = model.addRequest(request);
        } catch (Exception e) {
            System.out.println("error");
        }

        return req;
    }
}
