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
public class Building {
    private String buildingId;
    private String buildingName;

    public Building(String buildingId, String buildingName) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @Override
    public String toString() {
        return this.getBuildingName();
    }
    
    
}
