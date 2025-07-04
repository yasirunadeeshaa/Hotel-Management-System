package com.mycompany.hotelmanagementsystem;

public class Chef extends HotelStaff{
    private String speciality;
    private int yearsOfExperience;

    public Chef(String N, String SN){
        super(N,SN);
    }

    public void setSpeciality(String S){
        this.speciality=S;
    }
    public String getSpeciality(){
        return speciality;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString(){
        return super.toString() + "Speciality :- "+ speciality+"Years if experience :- " + yearsOfExperience;
    }
}
