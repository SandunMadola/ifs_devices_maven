/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.service;

import ifs_devices.model.Edit_Mode;
import ifs_devices.model.Model;
import ifs_devices.model.Request;
import java.util.List;

/**
 *
 * @author sanmlk
 */
public class RequestService {

    public List<Request> getRequest() {
        System.out.println("RequestService call");
        List<Request> req = null;
        try {
            Model model = new Model();
            req = model.GetRequest();
            //System.out.println("sandun");
        } catch (Exception e) {
            System.out.println("error");
        }

        return req;
    }

    public Request addRequest(Request request) {
        System.out.println("RequestService call");
        Request req = null;
        try {
            Model model = new Model();
            req = model.addRequest(request);
        } catch (Exception e) {
            System.out.println("error");
        }

        return req;
    }

    public Request updateRequest(Request request) {
        System.out.println("EmployeeService Update");
        Request req = null;
        try {
            Model model = new Model();
            req = model.updateRequest(request);
        } catch (Exception e) {
            System.out.println("error");
        }

        return req;
    }

    public Edit_Mode editDetails(Edit_Mode edit_Mode) {
        System.out.println("Edit mode Service");
        Edit_Mode edit_Mode1 = null;
        try {
            Model model = new Model();
            edit_Mode1 = model.editDetails(edit_Mode);
        } catch (Exception e) {
            System.out.println("error");
        }

        return edit_Mode1;
    }
}
