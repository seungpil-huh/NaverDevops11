package com.jspProject.dto;

public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private double point;

    public UserDTO(int id, String username, String password, String email, double point, String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.point = point;
        this.nickname = nickname;
    }

    // Getter and Setter methods
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public double getPoint() { return point; }
    public void setPoint(double point) { this.point = point; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
}

