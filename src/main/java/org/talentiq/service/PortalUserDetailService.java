package org.talentiq.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.talentiq.model.entity.PortalUser;
import org.talentiq.repository.UserRepository;

import java.util.Optional;

@Service
public class PortalUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    // Constructor injection for MyUserRepository
    public PortalUserDetailService(UserRepository myUserRepository) {
        this.userRepository = myUserRepository;
    }

    /**
     * Loads the user by username.
     *
     * @param username the username to search for
     * @return the UserDetails object
     * @throws UsernameNotFoundException if the username is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PortalUser> myUserOptional = userRepository.findByUserName(username);
        if (myUserOptional.isPresent()) {
            PortalUser myUser = myUserOptional.get();
            return User.builder()
                    .username(myUser.getUserName())
                    .password(myUser.getPassword())
                    .roles(myUser.getRoles().split(","))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

}
