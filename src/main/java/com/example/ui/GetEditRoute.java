package com.example.ui;

import com.example.appl.CardRepository;
import com.example.model.Status;
import spark.*;

import java.util.HashMap;
import java.util.Objects;

/**
 * The {@code GET /editCard} route handler.
 * Displays the page containing the form for modifying an existing card.
 * Grabs the card's current data and passes it on to the Freemarker template to pre-fill its fields.
 *
 * @author <a href='mailto:dw5005@rit.edu'>Devon Welcheck</a>
 */
public class GetEditRoute implements Route {
    static final String VIEW_NAME = "editCard.ftl";
    static final String TITLE = "Edit Card";

    private TemplateEngine templateEngine;
    private CardRepository cardRepository;

    /**
     * Constructor for the {@code GET /editCard} route handler.
     * @param templateEngine The TemplateEngine used for rendering HTML.
     * @param cardRepository The CardRespository instance holding the Cards for the app
     */
    public GetEditRoute(TemplateEngine templateEngine, CardRepository cardRepository) {
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
        String cardUuid = request.queryParams("id");
        vm.put("card", cardRepository.getCard(cardUuid));
        vm.put("title", TITLE);

        // Comment-out if you don't want to dynamically build the statuses list.
        vm.put("statuses", Status.class.getEnumConstants());

        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}
