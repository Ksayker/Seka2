package ksayker.seka2.game.players;

import ksayker.seka2.game.players.cards.Cards;

public class PlayerCards {
    public final Cards firstCard;
    public final Cards secondCard;
    public final Cards thirdCard;

    public PlayerCards(Cards firstCard, Cards secondCard, Cards thirdCard){
        this.firstCard = firstCard;
        this.secondCard = secondCard;
        this.thirdCard = thirdCard;
    }
}
