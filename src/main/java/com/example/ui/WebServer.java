package com.example.ui;

import java.util.Objects;
import java.util.logging.Logger;

import static spark.Spark.get;
import static spark.Spark.post;

import com.example.appl.CardRepository;
import spark.TemplateEngine;

/**
 * The server that initializes the set of HTTP request handlers.
 *
 * @author <a href='mailto:dw5005@rit.edu'>Devon Welcheck</a>
 */
public class WebServer {
    private static final Logger LOG = Logger.getLogger(WebServer.class.getName());

    // The URL pattern to request the Home page.
    public static final String HOME_URL = "/";

    // The URL pattern to request the New Card page.
    public static final String NEW_CARD_URL = "/newCard";

    // The URL pattern to request the Edit Card page.
    public static final String EDIT_CARD_URL = "/editCard";

    // The URL pattern to request the Undo Card action.
    public static final String UNDO_CARD_URL = "/undoArchiveCard";

    // The URL pattern to request the Archive Card action.
    public static final String ARCHIVE_CARD_URL = "/archiveCard";

    private final CardRepository cardRepository;
    private final TemplateEngine templateEngine;

    /**
     * The constructor for the Web Server.
     *
     * @param cardRepository The {@link CardRepository} for the application.
     * @param templateEngine The default {@link TemplateEngine} to render views.
     */
    public WebServer(final CardRepository cardRepository, final TemplateEngine templateEngine) {
        Objects.requireNonNull(cardRepository, "cardRepository must not be null");
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");

        this.cardRepository = cardRepository;
        this.templateEngine = templateEngine;
    }

    /**
     * Initialize all of the HTTP routes that make up this web application.
     */
    public void initialize() {
        // Displays the home page.
        get(HOME_URL, new GetHomeRoute(templateEngine, cardRepository));

        // Shows create card page.
        get(NEW_CARD_URL, new GetCreateRoute(templateEngine, cardRepository));

        // Shows the edit card page.
        get(EDIT_CARD_URL, new GetEditRoute(templateEngine, cardRepository));

        // Posts a new card.
        post(NEW_CARD_URL, new PostCreateRoute(cardRepository));

        // Post a card update.
        post(EDIT_CARD_URL, new PostEditRoute(cardRepository));

        // Post to archive card.
        // TODO: Make a route controller that archives a Card by its UUID, puts that UUID in the session, and put it here.
        //post(ARCHIVE_CARD_URL, new PostArchiveRoute(cardRepository));

        // Post to undo archiving card.
        // TODO: Make a route controller that un-archives a Card by its UUID, clears its UUID from the session, and put it here.
        //post(UNDO_CARD_URL, new PostUndoRoute(cardRepository));

        LOG.config("WebServer is initialized.");
    }

}
