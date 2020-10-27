package com.riiidlabs.assessment.controller;

import com.riiidlabs.assessment.data.vo.TalkVO;
import com.riiidlabs.assessment.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/conference/talks")
public class TalkController {

	@Autowired
	TalkService talkService;

	@GetMapping
	public List<TalkVO> findAllTalks() {
		return talkService.findAll();
	}

	@GetMapping("/{id}")
	public TalkVO findTalkById(@PathVariable("id") Long id) {
		return talkService.findById(id);
	}

	@PostMapping
	public TalkVO createTalk(@RequestBody TalkVO talkVO) {
		return talkService.create(talkVO);
	}

	@PutMapping
	public TalkVO updateTalk(@RequestBody TalkVO talkVO) {
		return talkService.update(talkVO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTalk(@PathVariable("id") Long id) {
		talkService.delete(id);
		return ResponseEntity.ok().build();
	}
}
