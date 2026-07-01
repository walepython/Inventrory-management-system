package com.example.Inventory.Management.System.controller;

import com.example.Inventory.Management.System.configuration.JwtUtil;
import com.example.Inventory.Management.System.dto.LoginResponse;
import com.example.Inventory.Management.System.dto.StaffDTO;
import com.example.Inventory.Management.System.dto.StaffDetails;
import com.example.Inventory.Management.System.model.Staff;
import com.example.Inventory.Management.System.repository.StaffRepo;
import com.example.Inventory.Management.System.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("staff")
@CrossOrigin(origins = "http://localhost:5173")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StaffDetails staffDetails;


    private StaffDTO staffDTO;

    @PostMapping("register")
    public ResponseEntity<Staff> registerstaff(@RequestBody StaffDTO staffDTO){
        return staffService.registerstaff(staffDTO);
    }
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody StaffDTO staffDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            staffDTO.getEmail(), staffDTO.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        Staff staff = staffService.login(staffDTO.getEmail(), staffDTO.getPassword());
        UserDetails userDetails = staffDetails.loadUserByUsername(staffDTO.getEmail());
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponse(token, staff));
    }

    @GetMapping("getallstaff")
    public List<Staff> getallstaff(){
        return staffService.allstaff();
    }

    @GetMapping("getbystaff/{id}")
    public Staff getbystaffid(@PathVariable int id){
        return staffService.getbystaffid(id);
    }

    @PostMapping("updatestaff/{id}")
    public ResponseEntity<Staff> updateStaff(
            @PathVariable int id,
            @RequestBody StaffDTO staffDTO) {

        return staffService.updateStaff(id, staffDTO);
    }

    @DeleteMapping("deletebyid/{id}")
    public void deletebyid(@PathVariable int id){
        staffService.deletebyid(id);
    }


}
