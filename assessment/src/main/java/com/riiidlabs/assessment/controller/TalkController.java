package com.riiidlabs.assessment.controller;

import com.riiidlabs.assessment.model.Talk;
import com.riiidlabs.assessment.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/conference/talks")
public class TalkController {

	@Autowired
	TalkService talkService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Talk> findAllTalks() {
		return talkService.findAll();
	}

	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Talk findTalkById(@PathVariable("id") Long id) {
		return talkService.findById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Talk createTalk(@RequestBody Talk talk) {
		return talkService.create(talk);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Talk updateTalk(@RequestBody Talk talk) {
		return talkService.update(talk);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteTalk(@PathVariable("id") Long id) {
		talkService.delete(id);
	}
}
