package com.example.ui;

import java.util.Objects;

import com.example.appl.CardRepository;

import spark.Request;
import spark.Response;
import spark.Route;

public class PostCreateRoute implements Route{
	private CardRepository cardRepo;
	
	public PostCreateRoute(CardRepository cardRepo) {
		Objects.requireNonNull(cardRepo, "cardRepository must not be null.");
		this.cardRepo=cardRepo;
	}
	@Override
	public Object handle(Request request, Response response) throws Exception {
		String title = request.queryParams("title");
        String description = request.queryParams("description");
        String status = request.queryParams("status");
        String owner = request.queryParams("owner");
        this.cardRepo.addCard(title, description, status, owner);
        
        response.redirect("/");
        return null;
	}
}
