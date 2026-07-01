package com.example.Inventory.Management.System.dto;

import com.example.Inventory.Management.System.model.Staff;
import com.example.Inventory.Management.System.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StaffDetails implements UserDetailsService {

    @Autowired
    private StaffRepo staffRepo;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Staff staff = staffRepo.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));


            return new CustomStaffDetails(staff);

    }
}
