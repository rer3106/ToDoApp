package com.example.ui;

import com.example.appl.CardRepository;
import spark.*;

import java.util.HashMap;
import java.util.Objects;

/**
 * The {@code GET /} route handler.
 * Collects existing cards from CardRepository and passes them onto the Freemarker template for rendering.
 *
 * @author <a href='mailto:dw5005@rit.edu'>Devon Welcheck</a>
 */
public class GetHomeRoute implements Route {
    static final String VIEW_NAME = "home.ftl";
    static final String TITLE = "ToDo App";

    private TemplateEngine templateEngine;
    private CardRepository cardRepository;

    /**
     * Constructor for the {@code GET /} route handler.
     * @param templateEngine The TemplateEngine used for rendering HTML.
     * @param cardRepository The CardRespository instance holding the Cards for the app
     */
    public GetHomeRoute(TemplateEngine templateEngine, CardRepository cardRepository) {
        Objects.requireNonNull(cardRepository, "cardRepository must not be null");
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");

        this.templateEngine = templateEngine;
        this.cardRepository = cardRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object handle(Request request, Response response) {
        HashMap<String, Object> vm = new HashMap<>();
        vm.put("title", TITLE);

        // TODO: Provide the Card instances to the Freemarker template.
        vm.put("cards",this.cardRepository.getCards());
        
        // TODO: Provide the UUID of the Card instance that was archived.
        //vm.put("",);


        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}
