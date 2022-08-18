package com.pic_rrhh.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pic_rrhh.dao.DAOManager;
import com.pic_rrhh.repositories.ManagerRepository;

@Service
public class JwtService implements UserDetailsService{

	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOManager manager = managerRepository.findByUsername(username);
		
		if (manager == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(
				manager.getUsername(),
				manager.getPassword(),
				getAuthority(manager));
	}
	
	private Set getAuthority(DAOManager manager) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        manager.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

	public DAOManager loadUserByUsernameJWT(String username) throws UsernameNotFoundException {
		DAOManager manager = managerRepository.findByUsername(username);
		if (manager == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return manager;
	}

}
