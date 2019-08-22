package com.jstewart.exalted.controller;

import java.util.List;

import com.jstewart.exalted.exception.ResourceNotFoundException;
import com.jstewart.exalted.model.Charm;
import com.jstewart.exalted.repository.CharmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import com.jstewart.exalted.enumerations.Types;
import com.jstewart.exalted.enumerations.Durations;

@RestController
public class CharmController {

    @Autowired
    private CharmRepository charmRepository;

    @GetMapping("/charms")
    public List<Charm> getCharm() {
        return charmRepository.findAll();
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

    @ModelAttribute("types")
    public Types[] getTypes() {
        return Types.values();
    }

    @ModelAttribute("durations")
    public Durations[] getDurations() {
        return Durations.values();
    }
}
