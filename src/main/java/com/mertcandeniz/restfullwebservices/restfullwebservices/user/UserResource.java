package com.mertcandeniz.restfullwebservices.restfullwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.mertcandeniz.restfullwebservices.restfullwebservices.exeptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    //retrieveAllUsers
    //retieveUser{id}

    @Autowired
    private UserDAOService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = userService.findUser(id);

        if(user == null) {
            throw new UserNotFoundException("id : " + id);
        }
        EntityModel<User> model = EntityModel.of(user);

        WebMvcLinkBuilder linkToUser = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        model.add(linkToUser.withRel("all-users"));

        return model;
    }

    //input - details of user
    //output - CREATED & Return the createl URL

    @PostMapping("/users")
    public void createUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);
    }

}
