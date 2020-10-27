package com.riiidlabs.assessment.service;

import com.riiidlabs.assessment.converter.DozerConverter;
import com.riiidlabs.assessment.data.model.Talk;
import com.riiidlabs.assessment.data.vo.SpeakerVO;
import com.riiidlabs.assessment.data.vo.TalkVO;
import com.riiidlabs.assessment.exception.ResourceNotFoundException;
import com.riiidlabs.assessment.data.model.Speaker;
import com.riiidlabs.assessment.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerService {

    @Autowired
    SpeakerRepository speakerRepository;

    public SpeakerVO create(SpeakerVO speakerVO) {
        var entity = DozerConverter.parseObject(speakerVO, Speaker.class);
        var vo = DozerConverter.parseObject(speakerRepository.save(entity), SpeakerVO.class);
        return vo;
    }

    public List<SpeakerVO> findAll() {
        return DozerConverter.parseListObjects(speakerRepository.findAll(), SpeakerVO.class);
    }

    public SpeakerVO findById(Long id) {
        var entity = speakerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        return DozerConverter.parseObject(entity, SpeakerVO.class);
    }

    public SpeakerVO update(SpeakerVO speakerVO) {
        var entity = speakerRepository.findById(speakerVO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        entity.setName(speakerVO.getName());
        entity.setCompany(speakerVO.getCompany());
        entity.setEmail(speakerVO.getEmail());
        entity.setBio(speakerVO.getBio());
        return DozerConverter.parseObject(speakerRepository.save(entity), SpeakerVO.class);
    }

    public void delete(Long id) {
        Speaker entity = speakerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        speakerRepository.delete(entity);
    }
}
