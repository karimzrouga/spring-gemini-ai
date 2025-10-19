package com.app.spring_ai.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.spring_ai.model.Request;
import com.app.spring_ai.service.GeminiService;

import jakarta.validation.Valid;

@org.springframework.web.bind.annotation.RestController
@RequestMapping()
public class RestController {
	@Autowired
	private GeminiService geminiService;

	@PostMapping("/ask")
	public String generateStoryPdf(@RequestBody @Valid Request request) {
		return geminiService.generateStory(request);

	}
}
