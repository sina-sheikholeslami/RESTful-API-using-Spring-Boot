package com.riiidlabs.assessment.controller;

import com.riiidlabs.assessment.model.Talk;
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
	public List<Talk> findAllTalks() {
		return talkService.findAll();
	}

	@GetMapping("/{id}")
	public Talk findTalkById(@PathVariable("id") Long id) {
		return talkService.findById(id);
	}

	@PostMapping
	public Talk createTalk(@RequestBody Talk talk) {
		return talkService.create(talk);
	}

	@PutMapping
	public Talk updateTalk(@RequestBody Talk talk) {
		return talkService.update(talk);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTalk(@PathVariable("id") Long id) {
		talkService.delete(id);
		return ResponseEntity.ok().build();
	}
}
