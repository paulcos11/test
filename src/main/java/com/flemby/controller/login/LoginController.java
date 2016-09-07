package com.flemby.controller.login;

import com.flemby.entity.User;
import com.flemby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * Created by Paul on 02/09/2016.
 */
@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/editAppConfig", method = RequestMethod.GET)
    public ResponseEntity<User> findAllAccounts(@RequestParam(value = "name", required = false) String name,
                                                @RequestParam(value = "password", required = false) String password) {

        User user = userRepository.findByName(name);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/editAppLogin", method = RequestMethod.POST, produces = {"application/json"})
    public String userLogin(@RequestParam(value = "username", required = false) String username,
                            @RequestParam(value = "password", required = false) String password) {

        User user = userRepository.findByName(username);
        String userPassword = "{ \"correct\" : \"fail\" }";

        boolean password_verified;

        if (null == user.getPassword() || !user.getPassword().startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(password, user.getPassword());

        System.out.println(password_verified);
        if (password_verified) {
            userPassword = "{ \"correct\" : \"correct\" }";
        }
        System.out.println(userPassword);

        return userPassword;
    }

    @RequestMapping(value = "/editApp", method = RequestMethod.GET)
    public String successfulLogin(Locale locale, Model model) {
        return "editApp";
    }

}
