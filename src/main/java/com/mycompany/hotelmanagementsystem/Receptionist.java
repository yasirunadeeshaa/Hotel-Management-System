package com.mycompany.hotelmanagementsystem;

public class Receptionist extends HotelStaff {

    private String[] languagesSpoken;
    private boolean hasCustomerServiceCertification;

    public Receptionist(String name, String surname) {
        super(name, surname);
    }

    // Setter and Getter methods
    public void setLanguagesSpoken(String[] languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public String[] getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setHasCustomerServiceCertification(boolean hasCustomerServiceCertification) {
        this.hasCustomerServiceCertification = hasCustomerServiceCertification;
    }

    public boolean getHasCustomerServiceCertification() {
        return hasCustomerServiceCertification;
    }

    @Override
    public String toString() {
        String languages = "";
        if (languagesSpoken != null && languagesSpoken.length > 0) {
            languages = String.join(", ", languagesSpoken);
        }

        return super.toString() + " Receptionist - Languages: " + languages +
                ", Customer Service Certified: " + (hasCustomerServiceCertification ? "Yes" : "No");
    }
}