package org.talentiq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.talentiq.model.entity.PortalUser;
import org.talentiq.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/talentiq/users")
public class UserController {

    @Autowired
    private UserService userService;

   @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PortalUser> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PortalUser getUsers(@RequestBody PortalUser talentiqUser){
        return userService.saveUser(talentiqUser);
    }
}
