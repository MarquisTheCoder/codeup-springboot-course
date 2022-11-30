package com.codeup.spring_blog.services;

import com.codeup.spring_blog.models.SpringBlogUserDetails;
import com.codeup.spring_blog.models.Users;
import com.codeup.spring_blog.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringBlogUserDetailsService implements UserDetailsService {
    //automatically inject usersrepository dao
    @Autowired private UsersRepository usersRepository;

    //loads user data from the dao and checks it against user input
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("UserDetails Not found");
        } else{
            return new SpringBlogUserDetails(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword());
        }
    }
}
