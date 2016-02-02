/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.service;

import ifs_devices.model.DeviceList;
import ifs_devices.model.Model;
import java.util.List;

/**
 *
 * @author nedilk
 */
public class SearchService {
    
    public List<DeviceList> getAll(String val) {
        System.out.println("SearchService call");
        List<DeviceList> searcheddevicels = null;
        try {
            Model model = new Model();
            searcheddevicels = model.GetAllSearchedDevices(val);            
        } catch (Exception e) {
            System.out.println("service error (DB)");
        }

        return searcheddevicels;
    }
    
}
