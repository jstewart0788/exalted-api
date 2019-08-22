package com.jstewart.exalted.controller;

import com.jstewart.exalted.exception.ResourceNotFoundException;
import com.jstewart.exalted.model.Charm;
import com.jstewart.exalted.repository.CharmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class CharmController {

    @Autowired
    private CharmRepository charmRepository;

    @GetMapping("/charms")
    public Page<Charm> getCharm(Pageable pageable) {
        return charmRepository.findAll(pageable);
    }


    @PostMapping("/charms")
    public Charm createCharm(@Valid @RequestBody Charm charm) {
        return charmRepository.save(charm);
    }

    @PutMapping("/charms/{charmId}")
    public Charm updateCharm(@PathVariable Long charmId,
                                   @Valid @RequestBody Charm charmRequest) {
        return charmRepository.findById(charmId)
                .map(charm -> {
                    charm.setTitle(charmRequest.getTitle());
                    charm.setDescription(charmRequest.getDescription());
                    return charmRepository.save(charm);
                }).orElseThrow(() -> new ResourceNotFoundException("Charm not found with id " + charmId));
    }

    @DeleteMapping("/charms/{charmId}")
    public ResponseEntity<?> deleteCharm(@PathVariable Long charmId) {
        return charmRepository.findById(charmId)
                .map(charm -> {
                    charmRepository.delete(charm);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Charm not found with id " + charmId));
    }
}