package com.oms.payloads;

public class Password {
    private String password;
    private String confirmPassword;
    private String email;

    public Password() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Password(String password, String confirmPassword, String email) {
        super();
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
