package com.example.Inventory.Management.System.dto;

import com.example.Inventory.Management.System.model.Staff;

public class LoginResponse {
    private String token;
    private Staff staff;

    public LoginResponse(String token, Staff staff) {
        this.token = token;
        this.staff = staff;
    }

    public String getToken() { return token; }
    public Staff getStaff() { return staff; }
}
