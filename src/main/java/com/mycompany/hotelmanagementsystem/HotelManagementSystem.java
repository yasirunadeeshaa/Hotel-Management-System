package com.mycompany.hotelmanagementsystem;

/**** ENTER HERE YOUR DETAILS:*******
         * FIRST NAME: A.YASIRU NADEESHA
         * LAST NAME: ATHTHANAYAKA
         * STUDENT ID: 20232389
         */

public class HotelManagementSystem  {

    public static void main(String[] args) {
        
        HotelManager hotelManager = new WestminsterHotelManager(100);
        boolean exit = false;
        while (!exit) {
            exit = hotelManager.runMenu();
        }
    }
}
