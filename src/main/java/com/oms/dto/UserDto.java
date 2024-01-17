package com.oms.dto;

import com.oms.Entity.UserRole;
import com.oms.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	@Getter
	private Integer userId;
	private Collection<? extends GrantedAuthority> authorities;
    private String email;
    private String fullName;
    private String gender;
    private String moNumber;
    private String password;
    private String ref;
    private String status;
	private boolean enabled;
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

	public Set<Integer> getUserTaskIds() {
		return userTaskIds;
	}
	public void setUserTaskIds(Set<Integer> userTaskIds) {
		this.userTaskIds = userTaskIds;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
