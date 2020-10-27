package com.riiidlabs.assessment.controller;

import com.riiidlabs.assessment.model.Attendee;
import com.riiidlabs.assessment.model.Speaker;
import com.riiidlabs.assessment.service.AttendeeService;
import com.riiidlabs.assessment.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/conference/attendees")
public class AttendeeController {

    @Autowired
    AttendeeService attendeeService;

    @GetMapping
    public List<Attendee> findAllAttendees() {
        return attendeeService.findAll();
    }

    @GetMapping("/{id}")
    public Attendee findAttendeeById(@PathVariable("id") Long id) {
        return attendeeService.findById(id);
    }

    @PostMapping
    public Attendee createAttendee(@RequestBody Attendee attendee) {
        return attendeeService.create(attendee);
    }

    @PutMapping
    public Attendee updateAttendee(@RequestBody Attendee attendee) {
        return attendeeService.update(attendee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAttendee(@PathVariable("id") Long id) {
        attendeeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
