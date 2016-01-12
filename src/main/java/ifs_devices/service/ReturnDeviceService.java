/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.service;

import ifs_devices.model.Model;



/**
 *
 * @author nedilk
 */
public class ReturnDeviceService {
    
      public String returnDeviceTransaction(int id) {
        System.out.println("ReturnDeviceService delete call"); 
        String returnTrans = null;
        try {
            Model model = new Model();
            returnTrans = model.returnDeviceTransaction(id);
        } catch (Exception e) {
            System.out.println("error");
        }        
        return returnTrans;
    }
}
