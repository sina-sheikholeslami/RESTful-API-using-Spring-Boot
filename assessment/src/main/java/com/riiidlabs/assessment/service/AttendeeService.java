package com.riiidlabs.assessment.service;

import com.riiidlabs.assessment.exception.ResourceNotFoundException;
import com.riiidlabs.assessment.model.Attendee;
import com.riiidlabs.assessment.model.Speaker;
import com.riiidlabs.assessment.repository.AttendeeRepository;
import com.riiidlabs.assessment.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {

    @Autowired
    AttendeeRepository attendeeRepository;

    public Attendee create(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    public List<Attendee> findAll() {
        return attendeeRepository.findAll();
    }

    public Attendee findById(Long id) {
        return attendeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
    }

    public Attendee update(Attendee attendee) {
        Attendee entity = attendeeRepository.findById(attendee.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        entity.setName(attendee.getName());
        entity.setCompany(attendee.getCompany());
        entity.setEmail(attendee.getEmail());
        entity.setRegistered(attendee.getRegistered());
        return attendeeRepository.save(entity);
    }

    public void delete(Long id) {
        Attendee entity = attendeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        attendeeRepository.delete(entity);
    }
}
