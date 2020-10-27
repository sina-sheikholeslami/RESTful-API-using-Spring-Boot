package com.riiidlabs.assessment.controller;

import com.riiidlabs.assessment.data.model.Attendee;
import com.riiidlabs.assessment.data.vo.AttendeeVO;
import com.riiidlabs.assessment.service.AttendeeService;
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
    public List<AttendeeVO> findAllAttendees() {
        return attendeeService.findAll();
    }

    @GetMapping("/{id}")
    public AttendeeVO findAttendeeById(@PathVariable("id") Long id) {
        return attendeeService.findById(id);
    }

    @PostMapping
    public AttendeeVO createAttendee(@RequestBody AttendeeVO attendeeVO) {
        return attendeeService.create(attendeeVO);
    }

    @PutMapping
    public AttendeeVO updateAttendee(@RequestBody AttendeeVO attendeeVO) {
        return attendeeService.update(attendeeVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAttendee(@PathVariable("id") Long id) {
        attendeeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
