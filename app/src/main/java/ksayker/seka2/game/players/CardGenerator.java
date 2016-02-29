package ksayker.seka2.game.players;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ksayker.seka2.game.players.cards.Cards;

/**
 * Class designed for random card generation.
 */
public class CardGenerator {

    /** random generator*/
    private Random random;
    /** list  with availability card*/
    private List<Cards> availabilityCards;

    /**
     * Constructor for card generator.
     */
    public CardGenerator(){
        random = new Random();
        availabilityCards = new LinkedList<>();

        for(Cards card: Cards.values()){
            availabilityCards.add(card);
        }
    }

    /** generate one card*/
    private Cards generateOneCard(){
        int index = random.nextInt(availabilityCards.size());
        Cards resultCard = availabilityCards.get(index);
        availabilityCards.remove(index);
        return resultCard;
    }

    /** generate three random card*/
    public PlayerCards generateRandomCardsForPlayer(){

        return new PlayerCards(
                generateOneCard(),
                generateOneCard(),
                generateOneCard()
        );
    }
}
