package com.codegym.furama.service.user_detail;

import com.codegym.furama.entity.User;
import com.codegym.furama.repository.UserRepository;
import com.codegym.furama.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("User " + username + " not exist in database");
        }

        List<String> roles = userRoleRepository.findAllRoleByUser(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantedAuthorities);
        return userDetails;
    }
}
