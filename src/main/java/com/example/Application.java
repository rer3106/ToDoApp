package com.example;

import java.io.InputStream;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.example.appl.CardRepository;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import com.example.ui.WebServer;

/**
 * The entry point for the To-Do web app.
 *
 * @author <a href='mailto:dw5005@rit.edu'>Devon Welcheck</a>
 */
public final class Application {
    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    private final WebServer webServer;

    private Application(final WebServer webServer) {
        Objects.requireNonNull(webServer, "webServer must not be null");

        this.webServer = webServer;
    }

    private void initialize() {
        LOG.config("Application is initializing.");

        this.webServer.initialize();
        LOG.config("Application initialization complete.");
    }

    /**
     * Entry point for the To-Do web app.
     *
     * @param args String[] of command line arguments
     */
    public static void main(String[] args) {
        // initialize Logging
        try {
            ClassLoader classLoader = Application.class.getClassLoader();
            final InputStream logConfig = classLoader.getResourceAsStream("log.properties");
            LogManager.getLogManager().readConfiguration(logConfig);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Could not initialize log manager because: " + e.getMessage());
        }

        final CardRepository cardRepository = new CardRepository();
        final TemplateEngine templateEngine = new FreeMarkerEngine();
        final WebServer webServer = new WebServer(cardRepository, templateEngine);
        final Application app = new Application(webServer);

        app.initialize();
    }

}
