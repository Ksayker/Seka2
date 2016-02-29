package ksayker.seka2.game.players;

import ksayker.seka2.game.players.cards.Cards;

/**
 * Class contain player card.
 */
public class PlayerCards {
    /** first card*/
    public final Cards firstCard;
    /** second card*/
    public final Cards secondCard;
    /** third card*/
    public final Cards thirdCard;

    /**
     * Constructor for creating players card set.
     *
     * @param firstCard first card.
     * @param secondCard second card.
     * @param thirdCard third card.
     */
    public PlayerCards(Cards firstCard, Cards secondCard, Cards thirdCard){
        this.firstCard = firstCard;
        this.secondCard = secondCard;
        this.thirdCard = thirdCard;
    }
}
