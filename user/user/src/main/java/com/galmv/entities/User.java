package com.galmv.entities;

import java.util.UUID;

public interface User {

    public UUID getId();
    public String getName();
    public void setName(String name);
    public String getEmail();
    public void setEmail(String email);
    public String getPassword();
    public void setPassword(String password);
    public String getPhone();
    public void setPhone(String phone);
    public String getStatus();
    public void setStatus(String status);
    public String getPhoto();
    public void setPhoto(String photo);
}
