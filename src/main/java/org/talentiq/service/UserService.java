package org.talentiq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talentiq.model.entity.PortalUser;
import org.talentiq.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<PortalUser> getUsers() {
        List<PortalUser> talentiqUsers = userRepository.findAll();
        return talentiqUsers;
    }

    public PortalUser saveUser(PortalUser talentiqUser) {
        return userRepository.save(talentiqUser);
    }
}
