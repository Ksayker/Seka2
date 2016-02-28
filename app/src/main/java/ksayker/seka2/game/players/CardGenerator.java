package ksayker.seka2.game.players;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ksayker.seka2.game.players.cards.Cards;


public class CardGenerator {

    private Random random;
    private List<Cards> availabilityCards;

    public CardGenerator(){
        random = new Random();
        availabilityCards = new LinkedList<>();

        for(Cards card: Cards.values()){
            availabilityCards.add(card);
        }
    }

    private Cards generateOneCard(){
        int index = random.nextInt(availabilityCards.size());
        Cards resultCard = availabilityCards.get(index);
        availabilityCards.remove(index);
        return resultCard;
    }
    public PlayerCards generateRandomCardsForPlayer(){

        return new PlayerCards(
                generateOneCard(),
                generateOneCard(),
                generateOneCard()
        );
    }
}
