package com.riiidlabs.assessment.service;

import com.riiidlabs.assessment.exception.ResourceNotFoundException;
import com.riiidlabs.assessment.model.Speaker;
import com.riiidlabs.assessment.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerService {

    @Autowired
    SpeakerRepository speakerRepository;

    public Speaker create(Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }

    public Speaker findById(Long id) {
        return speakerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
    }

    public Speaker update(Speaker speaker) {
        Speaker entity = speakerRepository.findById(speaker.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        entity.setName(speaker.getName());
        entity.setCompany(speaker.getCompany());
        entity.setEmail(speaker.getEmail());
        entity.setBio(speaker.getBio());
        return speakerRepository.save(entity);
    }

    public void delete(Long id) {
        Speaker entity = speakerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        speakerRepository.delete(entity);
    }
}
