/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.service;

import ifs_devices.model.BorrowDevice;
import ifs_devices.model.Model;
import java.util.List;

/**
 *
 * @author nedilk
 */
public class BookedDatesService {

    public List<BorrowDevice> getbookedDates(String id) {
        System.out.println("GetBookedDeviceService call");
       List<BorrowDevice> bookreq = null;
        try {
            Model model = new Model();
            
            bookreq = model.GetbookedDates(id);
           
        } catch (Exception e) {
            System.out.println("error");
        }

        return bookreq;
    }
}

