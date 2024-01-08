package com.oms.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String email;
    private String fullName;
    private String gender;
    private String moNumber;
    private String password;
    private String ref;
    private String status;
    private Set<Integer> roleIds;
    private Set<Integer> userTaskIds;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMoNumber() {
		return moNumber;
	}
	public void setMoNumber(String moNumber) {
		this.moNumber = moNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<Integer> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Set<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	public Set<Integer> getUserTaskIds() {
		return userTaskIds;
	}
	public void setUserTaskIds(Set<Integer> userTaskIds) {
		this.userTaskIds = userTaskIds;
	}
    
}
