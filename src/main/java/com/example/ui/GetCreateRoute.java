package com.example.ui;

import java.util.HashMap;
import java.util.Objects;

import com.example.appl.CardRepository;
import com.example.model.Status;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateEngine;

public class GetCreateRoute implements Route{
	static final String VIEW_NAME = "newCard.ftl";
	static final String TITLE ="Create Card";
	
	private TemplateEngine templateEngine;
	private CardRepository cardRepo;
	
	public GetCreateRoute(TemplateEngine templateEngine, CardRepository cardRepo) {
		Objects.requireNonNull(cardRepo,"CardRepo must not be null");
		Objects.requireNonNull(templateEngine, "TemplateEngine mustnt be null");
		
		this.templateEngine=templateEngine;
		this.cardRepo=cardRepo;
	}
	
	@Override
	public Object handle(Request request, Response response) throws Exception {
		HashMap<String,Object> vm = new HashMap<>();
		String cardUUID = request.queryParams("id");
		vm.put("card", cardRepo.getCard(cardUUID));
		vm.put("title", TITLE);
		
        vm.put("statuses", Status.class.getEnumConstants());

		return templateEngine.render(new ModelAndView(vm,VIEW_NAME));
	}


}
