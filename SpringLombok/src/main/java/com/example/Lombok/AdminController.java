package com.example.Lombok;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class AdminController {
    
    private List<ContactDetail> contactDetails = new ArrayList<>();
    
    @PostMapping("/contact")
    public ResponseEntity<ContactDetail> postContact(@RequestBody ContactDetail cd) {
        // Validate input and perform any necessary operations before adding to the list
        // You can also save the data to a database
        
        contactDetails.add(cd);
        return new ResponseEntity<>(cd, HttpStatus.CREATED);
    }
    
    @GetMapping("/contact")
    public ResponseEntity<List<ContactDetail>> getContactData(){
        return new ResponseEntity<>(contactDetails, HttpStatus.OK);
    }
}
