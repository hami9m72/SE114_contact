package com.example.se114_contacts;

public class phone {
    String name;
    String phone;
    public phone(String name, String phone) {
        this.name = name;
        this.phone = phone;

    }
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
