package com.riiidlabs.assessment.controller;

import com.riiidlabs.assessment.data.vo.SpeakerVO;
import com.riiidlabs.assessment.service.SpeakerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Speakers Endpoint")
@RestController
@RequestMapping("/api/conference/speakers/v1")
public class SpeakerController {

    @Autowired
    SpeakerService speakerService;

    @GetMapping
    public List<SpeakerVO> findAllSpeakers() {
        return speakerService.findAll();
    }

    @GetMapping("/{id}")
    public SpeakerVO findSpeakerById(@PathVariable("id") Long id) {
        return speakerService.findById(id);
    }

    @PostMapping
    public SpeakerVO createSpeaker(@RequestBody SpeakerVO speakerVO) {
        return speakerService.create(speakerVO);
    }

    @PutMapping
    public SpeakerVO updateSpeaker(@RequestBody SpeakerVO speakerVO) {
        return speakerService.update(speakerVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpeaker(@PathVariable("id") Long id) {
        speakerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
