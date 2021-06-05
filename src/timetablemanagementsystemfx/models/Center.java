/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystemfx.models;

/**
 *
 * @author Programming
 */
public class Center {
    private String centerId;
    private String centerName;
    private String address;

    public Center(String centerId, String centerName, String address) {
        this.centerId = centerId;
        this.centerName = centerName;
        this.address = address;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.getCenterName();
    }
    
    
}
