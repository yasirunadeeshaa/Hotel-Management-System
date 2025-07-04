/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem;

public class Guest{

    private String name;
    private String surname;
    private int roomNumber;
    private int nightsStayed;

    public Guest(String name, String surname , int roomNumber , int ns ) {
        this.name = name;
        this.surname = surname;
        this.roomNumber = roomNumber;
        this.nightsStayed = ns;
    }

    // Setter and Getter methods
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setNightsStayed(int nightsStayed) {
        this.nightsStayed = nightsStayed;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNightsStayed() {
        return nightsStayed;
    }

    @Override
    public String toString() {
        return "Name ;- "+name+ " Guest - Room number: " + roomNumber + ", Nights stayed: " + nightsStayed;
    }
}
