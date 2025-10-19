package com.app.spring_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.spring_ai.model.Request;


@Service
public class GeminiService {

	@Autowired
	private ChatClient chatClient;

	public String generateStory(Request request) {
		return chatClient.prompt(request.getPrompt()).call().content();
	}

}
