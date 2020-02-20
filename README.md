# ToDoApp
To-Do sample app for workshop

## How to run it

1. Execute `mvn compile exec:java`
1. Open in your browser `http://localhost:4567/`

## Workshop Instructions
### Adding a New Card
When launching the app for the first time, a `New Card` button will be visible.
Click the button.  You will notice it returns a 404 error. This is because
we need to create this page.  

1. Go to `newCard.ftl` and create a new HTML form that `POST`s to `/newCard`.
A tutorial on HTML forms [here](https://www.w3schools.com/html/html_forms.asp) 
may help.  If you get stuck, take a look at `editCard.ftl`. The form for new 
cards should be similar, minus the hidden input.
1. Next, you will need to create a new UI Controller called `PostCreateRoute` to
handle processing the user's data and adding the card to `CardRepository`.
Again, if you get stuck, refer to `PostEditRoute`.
1. Lastly, add the route mapping to `WebServer` similar to the one 
for `/editCard`.

Once you have complete these steps, fill out the form and create a new card.  
When you are returned to the homepage, you will notice your card is still not 
there.

### Displaying Cards
To get them to appear, you will need to modify the homepage's UI controller,
`GetHomeRoute` and UI view, `home.ftl`. You will need to have the UI controller
provide the list of cards to the FreeMarker template, which can iterate through
them as described 
[here](https://freemarker.apache.org/docs/ref_directive_list.html) to render
the cards.

### Archiving Cards
Now that we can see the cards, we can move on to archiving them.  This will
require a new method in `CardRepository`.  This method would be responsible
for adding the card to the `HashMap` of archived cards and removing it from the
`HashMap` of active cards.

You will also need a UI controller that maps to `POST /archiveCard`.  It will
need to call your newly-made method in `CardRepository`, and store the UUID
of the card you just archived to the user's session with the key `undoUuid`.
The Spark `Session` object can be accessed as shown 
[here](http://sparkjava.com/documentation#sessions).

Now, try to archive a card by pressing the `Archive` button.

### Undo an Archive
Once this happens, an `Undo` button will appear.  Pressing this will also
cause a 404 error.  This is because you need a UI controller to undo the
operation. This UI controller will need to:
 
 1. Access the UUID of the archived card via the `undoUuid` key in Session.
 1. Add the card to the `HashMap` of active cards.
 1. Remove the card from the `HashMap` of archived cards.
 1. Remove the UUID from the session.
