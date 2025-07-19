package com.example.mywebproject.Pojo;

public class IdWithUUID {
    private Integer id;
    private String isLoggedIn;

    public IdWithUUID() {
    }

    public IdWithUUID(Integer id, String isLoggedIn) {
        this.id = id;
        this.isLoggedIn = isLoggedIn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(String isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    @Override
    public String toString() {
        return "IdWithUUID{" +
                "id=" + id +
                ", isLoggedIn='" + isLoggedIn + '\'' +
                '}';
    }
}
