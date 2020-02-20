package com.example.ui;

import com.example.appl.CardRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

/**
 * The {@code POST /editCard} route handler.
 * Takes in form data from page and modifies the respective Card in CardRepository.
 *
 * @author <a href='mailto:dw5005@rit.edu'>Devon Welcheck</a>
 */
public class PostEditRoute implements Route {
    private CardRepository cardRepository;

    /**
     * Constructor for the {@code POST /editCard} route handler.
     * @param cardRepository The CardRespository instance holding the Cards for the app
     */
    public PostEditRoute(CardRepository cardRepository) {
        Objects.requireNonNull(cardRepository, "cardRepository must not be null");

        this.cardRepository = cardRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object handle(Request request, Response response) {
        String uuid = request.queryParams("uuid");
        String title = request.queryParams("title");
        String description = request.queryParams("description");
        String status = request.queryParams("status");
        String owner = request.queryParams("owner");
        this.cardRepository.modifyCard(uuid, title, description, status, owner);

        response.redirect("/");
        return null;
    }
}
