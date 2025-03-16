package com.example.service;


import com.example.Entity.User;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDetailsImpl implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	 private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }
	   
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
