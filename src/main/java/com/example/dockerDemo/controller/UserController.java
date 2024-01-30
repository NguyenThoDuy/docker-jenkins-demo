package com.example.dockerDemo.controller;

import com.example.dockerDemo.model.User;
import com.example.dockerDemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @PostMapping("save")
    public ResponseEntity<Object> hello(@RequestBody User user){
        try {
            User userSave = new User(user.getUsername(), user.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(userSave));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @GetMapping("/find")
    public ResponseEntity<Object> findById(@RequestParam Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userRepository.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

}
