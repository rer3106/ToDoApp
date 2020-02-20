package com.example.appl;

import com.example.model.Card;

import java.util.*;

/**
 * Contains application-level logic to collect Cards and provide interface to add, modify, and get Cards.
 *
 * @author <a href='mailto:dw5005@rit.edu'>Devon Welcheck</a>
 */
public class CardRepository {
    /**
     * Maps of UUID -> Card instance
     */
    private Map<String, Card> activeCards;
    private Map<String, Card> archivedCards;

    /**
     * Constructor for CardRespository.
     * Also seeds Card map with a few sample entries.
     */
    public CardRepository(){
        this.activeCards = new HashMap<>();
        this.archivedCards = new HashMap<>();
        this.addCard("test", "this is a test", "IN_PROGRESS", "Devon");
    }

    /**
     * Create a new card with the given values.
     * @param title String value of Card's title
     * @param description String value of Card's description
     * @param statusValue String value of Card's status
     * @param owner String value of Card's owner
     */
    public void addCard(String title, String description, String statusValue, String owner){
        Card newCard = new Card(title, description, statusValue, owner);
        activeCards.put(newCard.getUuid(), newCard);
    }

    /**
     * Updates an existing card with the given values.
     * @param uuid String value of Card's UUID
     * @param title String value of Card's title
     * @param description String value of Card's description
     * @param statusValue String value of Card's status
     * @param owner String value of Card's owner
     */
    public void modifyCard(String uuid, String title, String description, String statusValue, String owner){
        activeCards.get(uuid).updateCard(title, description, statusValue, owner);
    }

    // TODO: Make a method that archives a Card by removing it from `activeCards` and moving it to `archivedCards`.


    // TODO: Make a method that un-archives a Card by removing it from `archivedCards` and moving back to `activeCards`.

    /**
     * Retrieve a given card by its UUID.
     * @param uuid String UUID of the Card
     * @return Card instance of requested Card
     */
    public Card getCard(String uuid) {
        return activeCards.get(uuid);
    }

    public Collection<Card> getCards() {
        return activeCards.values();
    }

	public void createCard(String title, String description, String status, String owner) {
		// TODO Auto-generated method stub
		
	}
}
