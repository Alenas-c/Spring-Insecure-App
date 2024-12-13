package com.example.insecureapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/find")
    public List<Map<String, Object>> findUser(@RequestParam String username) {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        return jdbcTemplate.queryForList(query); // Vulnerable to SQL Injection
    }

    @PostMapping("/admin/deleteUser")
    public String deleteUser(@RequestParam String userId) {
        String query = "DELETE FROM users WHERE id = '" + userId + "'";
        jdbcTemplate.execute(query); // No authentication or authorization checks
        return "User deleted";
    }

    @GetMapping("/debug")
    public Map<String, String> debug() {
        return System.getenv(); // Exposes sensitive system environment variables
    }
}
