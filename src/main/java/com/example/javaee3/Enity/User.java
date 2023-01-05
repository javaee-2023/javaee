package com.example.javaee3.Enity;

public class User {
    public String id;
    public String roleName;
    public String userName;
    public String mobile;

    public User(String id, String roleName, String userName, String mobile) {
        this.id = id;
        this.roleName = roleName;
        this.userName = userName;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
