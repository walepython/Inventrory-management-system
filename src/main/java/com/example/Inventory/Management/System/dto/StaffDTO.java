package com.example.Inventory.Management.System.dto;

import com.example.Inventory.Management.System.model.Staff;

import java.util.List;


public class StaffDTO {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private String role;
    private String phoneNumber;
    private String address;

    public StaffDTO() {
    }

    public StaffDTO(Staff staff) { // ADMIN/USERS
        this.firstName = staff.getFirstName();
        this.lastName = staff.getLastName();
        this.age = staff.getAge();
        this.email = staff.getEmail();
        this.password = staff.getPassword();
        this.role = staff.getRole();
        this.phoneNumber = staff.getPhoneNumber();
        this.address = staff.getAddress();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
