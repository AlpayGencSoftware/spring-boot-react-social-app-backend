package com.socialtime.webservis.user;

 
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.socialtime.webservis.shared.Views;

import lombok.Data;

@Data
@Entity
public class User implements UserDetails {
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private long id;	
  
  @NotNull(message="{webservis.constraint.username.Notnull.message}") 
  @Size(min=4, max=255)
  @UniqueUsername 
  @JsonView(Views.Base.class)
  private String username;
  
  @NotNull(message="{webservis.constraint.displayName.Notnull.message}") 
  @Size(min=4, max=255)
  private String displayName;
  
  @NotNull 
  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="{webservis.constraint.password.Notnull.message}")
  @Size(min=8, max=255)
  @JsonView(Views.Base.class) 
  private String password;
  
  @JsonView(Views.Base.class)
  private String image;
  
  

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	return AuthorityUtils.createAuthorityList("Role_user");
}

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return true;
}
  

  
  
}
