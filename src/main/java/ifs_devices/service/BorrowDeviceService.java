/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.service;

import ifs_devices.model.BorrowDevice;
import ifs_devices.model.Model;


/**
 *
 * @author nedilk
 */
public class BorrowDeviceService {
    
    public BorrowDevice getBorrowRequest() {
        System.out.println("BorrowDeviceService call");
        BorrowDevice borrowreq = null;
        try {
            Model model = new Model();
            borrowreq = model.GetBorrowRequest();
            //System.out.println("sandun");
        } catch (Exception e) {
            System.out.println("error");
        }

        return borrowreq;
    }

    public BorrowDevice addBorrowRequest(BorrowDevice borrowRequest) {
        System.out.println("BorrowDeviceService call");
        BorrowDevice borrowreq = null;
        try {
            Model model = new Model();
            borrowreq = model.addBorrowRequest(borrowRequest);
        } catch (Exception e) {
            System.out.println("error");
        }

        return borrowreq;
    }
}
