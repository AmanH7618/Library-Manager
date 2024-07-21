package com.library.Library.Admin;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private String phno;

    public Admin(Long adminId, String name, String password, String email, String phno) {
        this.adminId = adminId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phno = phno;
    }

    public Admin() {
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }
}
