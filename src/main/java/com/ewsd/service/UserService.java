package com.ewsd.service;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ewsd.dto.UserDto;
import com.ewsd.enums.Role;
import com.ewsd.exceptions.ResourceAlreadyExistsException;
import com.ewsd.repositories.UserRepository;
import com.sun.jdi.request.DuplicateRequestException;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var userFromDb = userRepository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with this email address."));
        List<GrantedAuthority> authorities = new java.util.ArrayList<>(Collections.emptyList());

        authorities.add((GrantedAuthority) () -> userFromDb.getRole().name());

        return new User(userFromDb.getUsername(), userFromDb.getPassword(), authorities);
    }
    public Optional<com.ewsd.model.User> getUserByUserName(String s) { 
		  return userRepository.findByUsername(s); 
		  }
    public com.ewsd.model.User getUserByName(String s) { 
		  return userRepository.findByusername(s); 
		  }
    public void addUser(UserDto userDto) {
  		LocalDateTime entry_date = LocalDateTime.now();
  		checkUserInList(userDto);
  		var userEntity = new com.ewsd.model.User();
  		BeanUtils.copyProperties(userDto, userEntity);
  		userEntity.setActiveStatus(true);
  		userEntity.setIsExpired(true);
  		userEntity.setIsLocked(true);
  		userEntity.setRole(Role.ROLE_STUDENT);
  		userEntity.setEntryDate(entry_date);
  		userRepository.save(userEntity);
  	}
	private void checkUserInList(UserDto userDto) {

		var username = userRepository.findByusername(userDto.getUsername());
		var userEmail = userRepository.findByEmail(userDto.getEmail());

		if (username != null) {
			throw new ResourceAlreadyExistsException("UserName Already exists");
		}
		if (userEmail != null) {
			throw new DuplicateRequestException("Email Already Used");
		}

	}
    public void edit(com.ewsd.model.User user) {
    	userRepository.save(user);
    }
}
