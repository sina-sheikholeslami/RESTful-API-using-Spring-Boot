package com.riiidlabs.assessment.controller;

import com.riiidlabs.assessment.model.Speaker;
import com.riiidlabs.assessment.model.Talk;
import com.riiidlabs.assessment.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/conference/speakers")
public class SpeakerController {

    @Autowired
    SpeakerService speakerService;

    @GetMapping
    public List<Speaker> findAllSpeakers() {
        return speakerService.findAll();
    }

    @GetMapping("/{id}")
    public Speaker findSpeakerById(@PathVariable("id") Long id) {
        return speakerService.findById(id);
    }

    @PostMapping
    public Speaker createSpeaker(@RequestBody Speaker speaker) {
        return speakerService.create(speaker);
    }

    @PutMapping
    public Speaker updateSpeaker(@RequestBody Speaker speaker) {
        return speakerService.update(speaker);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpeaker(@PathVariable("id") Long id) {
        speakerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
