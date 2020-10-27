package com.riiidlabs.assessment.service;

import com.riiidlabs.assessment.converter.DozerConverter;
import com.riiidlabs.assessment.data.vo.TalkVO;
import com.riiidlabs.assessment.exception.ResourceNotFoundException;
import com.riiidlabs.assessment.data.model.Talk;
import com.riiidlabs.assessment.repository.TalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalkService {

    @Autowired
    TalkRepository talkRepository;

    public TalkVO create(TalkVO talkVO) {
        var entity = DozerConverter.parseObject(talkVO, Talk.class);
        var vo = DozerConverter.parseObject(talkRepository.save(entity), TalkVO.class);
        return vo;
    }

    public List<TalkVO> findAll() {
        return DozerConverter.parseListObjects(talkRepository.findAll(), TalkVO.class);
    }

    public TalkVO findById(Long id) {
        var entity = talkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        return DozerConverter.parseObject(entity, TalkVO.class);
    }

    public TalkVO update(TalkVO talkVO) {
        var entity = talkRepository.findById(talkVO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        entity.setTitle(talkVO.getTitle());
        entity.setRoom(talkVO.getRoom());
        return DozerConverter.parseObject(talkRepository.save(entity), TalkVO.class);
    }

    public void delete(Long id) {
        Talk entity = talkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
        talkRepository.delete(entity);
    }
}
