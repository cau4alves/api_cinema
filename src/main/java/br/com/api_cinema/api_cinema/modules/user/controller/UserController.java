package br.com.api_cinema.api_cinema.modules.user.controller;

import br.com.api_cinema.api_cinema.modules.user.model.UserModel;
import br.com.api_cinema.api_cinema.modules.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody UserModel userModel) {
        try {
            var result = this.userService.execute(userModel);
            return ResponseEntity.ok().body(result);
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
