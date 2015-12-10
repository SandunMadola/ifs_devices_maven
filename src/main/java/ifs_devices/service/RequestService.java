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

    public Request getRequest() {
        System.out.println("RequestService call");
        Request req = null;
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
}
