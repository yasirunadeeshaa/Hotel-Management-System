package com.mycompany.hotelmanagementsystem;

public class Security extends HotelStaff {

    private String securityLevel; // e.g., "Level 1", "Level 2", "Level 3"
    private boolean isArmed;

    public Security(String name, String surname) {
        super(name, surname);
    }

    // Setter and Getter methods
    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setIsArmed(boolean isArmed) {
        this.isArmed = isArmed;
    }

    public boolean getIsArmed() {
        return isArmed;
    }

    @Override
    public String toString() {
        return super.toString() + " Security - Security Level: " + securityLevel +
                ", Armed: " + (isArmed ? "Yes" : "No");
    }
}
