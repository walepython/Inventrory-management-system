package com.example.Inventory.Management.System.service;

import com.example.Inventory.Management.System.dto.EmailDetails;
import com.example.Inventory.Management.System.dto.StaffDTO;
import com.example.Inventory.Management.System.model.Staff;
import com.example.Inventory.Management.System.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    private StaffRepo staffRepo;

    @Autowired
    private EmailService emailService;

    private BCryptPasswordEncoder bencoder = new BCryptPasswordEncoder(10);

    public ResponseEntity<Staff> registerstaff(StaffDTO staffDTO) {
        Staff staff = new Staff();
        if(staffRepo.existsByEmail(staffDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        staff.setFirstName(staffDTO.getFirstName());
        staff.setLastName(staffDTO.getLastName());
        staff.setAge(staffDTO.getAge());
        staff.setEmail(staffDTO.getEmail());
        staff.setPassword(bencoder.encode(staffDTO.getPassword()));
        staff.setPhoneNumber(staffDTO.getPhoneNumber());
        staff.setAddress(staffDTO.getAddress());
        staff.setRole(staffDTO.getRole());

        Staff savedStaff = staffRepo.save(staff);

        EmailDetails staffEmail = new EmailDetails();

        staffEmail.setRecipient(staffDTO.getEmail());
        staffEmail.setSubject("Welcome to Inventory Management");

        staffEmail.setMessageBody(
                "Hello " + staffDTO.getFirstName() + ",\n\n" +
                        "Your account has been created successfully.\n" +
                        "Staff ID: SOFT2026" + savedStaff.getId()
        );

        EmailDetails adminEmail = new EmailDetails();

        adminEmail.setRecipient("onidareadewaleoluwafemi@gmail.com");
        adminEmail.setSubject("New Staff Registration");

        adminEmail.setMessageBody(
                "A new staff member has been registered.\n\n" +
                        "Name: " + staffDTO.getFirstName() + " " + staffDTO.getLastName() +
                        "\nEmail: " + staffDTO.getEmail()
        );


        try {
            emailService.sendMail(adminEmail);
            emailService.sendMail(staffEmail);
        } catch (Exception e) {
            System.out.println("Email failed: " + e.getMessage());
        }

        return new ResponseEntity<>(savedStaff, HttpStatus.CREATED);
    }


    public Staff login(String email, String password) {

        Optional<Staff> optionalStaff =
                staffRepo.findByEmail(email);

        if(optionalStaff.isPresent()) {

            Staff staff = optionalStaff.get();

            if(bencoder.matches(password, staff.getPassword())) {

                return staff;
            }
        }

        return null;
    }

    public List<Staff> allstaff() {
        return staffRepo.findAll();
    }

    public Staff getbystaffid(int id) {
        return staffRepo.findById(id).get();
    }

    public ResponseEntity<Staff> updateStaff(int id, StaffDTO dto){

        Staff staff = staffRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        staff.setFirstName(dto.getFirstName());
        staff.setLastName(dto.getLastName());
        staff.setAge(dto.getAge());
        staff.setEmail(dto.getEmail());
        staff.setRole(dto.getRole());
        staff.setPhoneNumber(dto.getPhoneNumber());
        staff.setAddress(dto.getAddress());

        EmailDetails staffEmail = new EmailDetails();

        staffEmail.setRecipient(dto.getEmail());
        staffEmail.setSubject("Welcome to Inventory Management");

        staffEmail.setMessageBody(
                "Hello " + dto.getFirstName() + ",\n\n" +
                        "Your account has been created successfully.\n" +
                        "Staff ID: SOFT2026" + staff.getId()
        );

        EmailDetails adminEmail = new EmailDetails();

        adminEmail.setRecipient("onidareadewaleoluwafemi@gmail.com");
        adminEmail.setSubject("New Staff Registration");

        adminEmail.setMessageBody(
                "A new staff member has been registered.\n\n" +
                        "Name: " + dto.getFirstName() + " " + dto.getLastName() +
                        "\nEmail: " + dto.getEmail()
        );


        try {
            emailService.sendMail(adminEmail);
            emailService.sendMail(staffEmail);
        } catch (Exception e) {
            System.out.println("Email failed: " + e.getMessage());
        }

        return ResponseEntity.ok(staffRepo.save(staff));
    }

    public void deletebyid(int id) {
        staffRepo.deleteById(id);
    }
}
