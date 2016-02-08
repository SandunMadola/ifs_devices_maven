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
        System.out.println("RequestService call for get requested devices");
        List<Request> req = null;
        try {
            Model model = new Model();
            req = model.GetRequest();
        } catch (Exception e) {
            System.out.println("error");
        }

        return req;
    }

    public Request addRequest(Request request) {
        System.out.println("RequestService call for insert a new request");
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
        System.out.println("RequestService call for update a request");
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
        System.out.println("RequestService call for update a available device details");
        Edit_Mode edit_Mode1 = null;
        try {
            Model model = new Model();
            edit_Mode1 = model.editDetails(edit_Mode);
        } catch (Exception e) {
            System.out.println("error");
        }

        return edit_Mode1;
    }

    public String deleteRequest(int reqId) {
        System.out.println("RequestService call for delete rejected request");
        String msg = null;
        try {
            Model model = new Model();
            msg = model.deleteRequest(reqId);
        } catch (Exception e) {
            System.out.println("error");
        }
        return msg;
    }
}
