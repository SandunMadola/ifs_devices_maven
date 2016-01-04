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
public class CancelService {
    
    public String deleteTransaction(int id) {
       
        String delTrans = null;
        try {
            Model model = new Model();
            delTrans = model.deleteTransaction(id);
        } catch (Exception e) {
            System.out.println("error");
        }        
        return delTrans;
    }

    
}
