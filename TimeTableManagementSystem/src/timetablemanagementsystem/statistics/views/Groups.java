/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.statistics.views;

/**
 *
 * @author thina
 */
public class Groups {
    
    private int ID;
    private String groupN;
    private String startTime;
    private String subgroup;
    private String endTime;
    private String room;
    
    public Groups() {
    }

    public Groups(int ID) {
        this.ID = ID;
    }

    public Groups(int ID, String groupN, String startTime, String subgroup, String endTime, String room) {
        this.ID = ID;
        this.groupN = groupN;
        this.startTime = startTime;
        this.subgroup = subgroup;
        this.endTime = endTime;
        this.room = room;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGroupN() {
        return groupN;
    }

    public void setGroupN(String groupN) {
        this.groupN = groupN;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    

    
    
}
