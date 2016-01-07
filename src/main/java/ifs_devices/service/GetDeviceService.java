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
public class GetDeviceService {
    
    public BorrowDevice updateDevice(BorrowDevice updatedevice) {
        System.out.println("GetDeviceService Update");
        BorrowDevice update = null;
        try {
            Model model = new Model();
            update = model.updateDevice(updatedevice);
        } catch (Exception e) {
            System.out.println("error");
        }

        return update;
    }
    
}
