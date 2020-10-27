package com.riiidlabs.assessment.service;

import com.riiidlabs.assessment.exception.ResourceNotFoundException;
import com.riiidlabs.assessment.model.Talk;
import com.riiidlabs.assessment.repository.TalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalkService {

    @Autowired
    TalkRepository talkRepository;

    public Talk create(Talk talk) {
        return talkRepository.save(talk);
    }

    public List<Talk> findAll() {
        return talkRepository.findAll();
    }

    public Talk findById(Long id) {
        return talkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
    }

    public Talk update(Talk talk) {
        Talk entity = talkRepository.findById(talk.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        entity.setTitle(talk.getTitle());
        entity.setRoom(talk.getRoom());
        return talkRepository.save(entity);
    }

    public void delete(Long id) {
        Talk entity = talkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        talkRepository.delete(entity);
    }
}
