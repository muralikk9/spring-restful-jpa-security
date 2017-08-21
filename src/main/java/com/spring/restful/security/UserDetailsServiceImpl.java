package com.spring.restful.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.restful.model.User;
import com.spring.restful.repository.UserRepository;

/**
 * @author Murali.Kodavati
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByusername(userName);
		if (user == null) {
			return null;
		}
		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("USER");
		String password = user.getPassword();
		return new org.springframework.security.core.userdetails.User(userName, password, auth);
	}
}
