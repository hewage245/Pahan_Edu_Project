package com.example.PahanaEduProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.PahanaEduProject.model.RequestForm;
import com.example.PahanaEduProject.repository.RequestFormRepository;

@RestController
@RequestMapping("/api/request-book")
@CrossOrigin(origins = "*")
public class RequestFormController {

    @Autowired
    private RequestFormRepository requestFormRepository;

    @PostMapping
    public ResponseEntity<RequestForm> createRequest(@RequestBody RequestForm requestForm) {
        RequestForm savedRequest = requestFormRepository.save(requestForm);
        return ResponseEntity.ok(savedRequest);
    }

    @GetMapping
    public ResponseEntity<List<RequestForm>> getAllRequests() {
        return ResponseEntity.ok(requestFormRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestForm> getRequestById(@PathVariable String id) {
        return requestFormRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable String id) {
        if (!requestFormRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        requestFormRepository.deleteById(id);
        return ResponseEntity.ok("Request deleted with id: " + id);
    }
}
