package com.riiidlabs.assessment.service;

import com.riiidlabs.assessment.converter.DozerConverter;
import com.riiidlabs.assessment.data.model.Talk;
import com.riiidlabs.assessment.data.vo.AttendeeVO;
import com.riiidlabs.assessment.data.vo.TalkVO;
import com.riiidlabs.assessment.exception.ResourceNotFoundException;
import com.riiidlabs.assessment.data.model.Attendee;
import com.riiidlabs.assessment.repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {

    @Autowired
    AttendeeRepository attendeeRepository;

    public AttendeeVO create(AttendeeVO attendeeVO) {
        var entity = DozerConverter.parseObject(attendeeVO, Attendee.class);
        var vo = DozerConverter.parseObject(attendeeRepository.save(entity), AttendeeVO.class);
        return vo;
    }

    public List<AttendeeVO> findAll() {
        return DozerConverter.parseListObjects(attendeeRepository.findAll(), AttendeeVO.class);
    }

    public AttendeeVO findById(Long id) {
        var entity = attendeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        return DozerConverter.parseObject(entity, AttendeeVO.class);
    }

    public AttendeeVO update(AttendeeVO attendeeVO) {
        var entity = attendeeRepository.findById(attendeeVO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        entity.setName(attendeeVO.getName());
        entity.setCompany(attendeeVO.getCompany());
        entity.setEmail(attendeeVO.getEmail());
        entity.setRegistered(attendeeVO.getRegistered());
        return DozerConverter.parseObject(attendeeRepository.save(entity), AttendeeVO.class);
    }

    public void delete(Long id) {
        Attendee entity = attendeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        attendeeRepository.delete(entity);
    }
}
