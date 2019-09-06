package app.controller;

import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Transactional
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping(value="/users", produces = "application/json")
    @ResponseBody
    public List<User> getAll() {
        return userDao.getAll();
    }

    @PostMapping(value = "/users", consumes = "application/json")
    public ResponseEntity<String> post(@RequestBody User user) {
        userDao.create(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value="/users/{id}", produces = "application/json")
    @ResponseBody
    public User getById(@PathVariable Integer id) {
        return userDao.getById(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<String> put(@PathVariable Integer id, @RequestBody User user) {
        userDao.update(id, user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> put(@PathVariable Integer id) {
        userDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
