package com.example.jwtwithroles.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class Security {
    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('Role_super_admin', 'Role_admin')")
    public String getAdmin(){
        return "admin panel";
    }

    @GetMapping("/superadmin")
    @PreAuthorize("hasAuthority('Role_super_admin')")
    public String getSuperadmin(){
        return "superadmin panel";
    }
}
