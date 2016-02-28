package ksayker.seka2.game.players;

import ksayker.seka2.game.players.cards.Cards;

/**
 * Created by Yurec on 27.02.2016.
 */
public abstract class AbstractPlayer implements Player {
    protected int cash;
    protected PlayerCards cards;

    @Override
    public int getCash() {
        return cash;
    }

    @Override
    public void addCash(int value) {
        cash += value;
    }

    @Override
    public void deductCash(int value) {
        cash -= value;
    }

    @Override
    public boolean isBankrupt() {
        return cash <= 0;
    }

    @Override
    public PlayerCards getCards() {
        return cards;
    }

    @Override
    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public int doStep() {
        return 0;
    }

    @Override
    public void setCards(PlayerCards cards) {
        this.cards = cards;

    }

    @Override
    public int getPlayerScore() {
        int crossScore = 0;
        int diamondsScore = 0;
        int heartsScore = 0;
        int spadesScore = 0;

        Cards card = null;
        for (int i = 0; i < 3; i++) {
            switch (i){
                case 0:card = cards.firstCard;break;
                case 1:card = cards.secondCard;break;
                case 2: card = cards.thirdCard; break;
            }
            switch (card) {
                //Cross
                case CROSS_TWO:crossScore += 2;break;
                case CROSS_THREE:crossScore += 3;break;
                case CROSS_FOUR:crossScore += 4;break;
                case CROSS_FIVE:crossScore += 5;break;
                case CROSS_SIX:crossScore += 6;break;
                case CROSS_SEVEN:crossScore += 7;break;
                case CROSS_EIGHT:crossScore += 8;break;
                case CROSS_NINE:crossScore += 9;break;
                case CROSS_TEN:
                case CROSS_JACK:
                case CROSS_QUEEN:
                case CROSS_KING:crossScore += 10;break;
                case CROSS_ACE:crossScore += 11;break;
                //Diamonds
                case DIAMONDS_TWO:diamondsScore += 2;break;
                case DIAMONDS_THREE:diamondsScore += 3;break;
                case DIAMONDS_FOUR:diamondsScore += 4;break;
                case DIAMONDS_FIVE:diamondsScore += 5;break;
                case DIAMONDS_SIX:diamondsScore += 6;break;
                case DIAMONDS_SEVEN:diamondsScore += 7;break;
                case DIAMONDS_EIGHT:diamondsScore += 8;break;
                case DIAMONDS_NINE:diamondsScore += 9;break;
                case DIAMONDS_TEN:
                case DIAMONDS_JACK:
                case DIAMONDS_QUEEN:
                case DIAMONDS_KING:diamondsScore += 10;break;
                case DIAMONDS_ACE:diamondsScore += 11;break;
                //Hearts
                case HEARTS_TWO:heartsScore += 2;break;
                case HEARTS_THREE:heartsScore += 3;break;
                case HEARTS_FOUR:heartsScore += 4;break;
                case HEARTS_FIVE:heartsScore += 5;break;
                case HEARTS_SIX:heartsScore += 6;break;
                case HEARTS_SEVEN:heartsScore += 7;break;
                case HEARTS_EIGHT:heartsScore += 8;break;
                case HEARTS_NINE:heartsScore += 9;break;
                case HEARTS_TEN:
                case HEARTS_JACK:
                case HEARTS_QUEEN:
                case HEARTS_KING:heartsScore += 10;break;
                case HEARTS_ACE:heartsScore += 11;break;
                //Spades
                case SPADES_TWO:spadesScore += 2;break;
                case SPADES_THREE:spadesScore += 3;break;
                case SPADES_FOUR:spadesScore += 4;break;
                case SPADES_FIVE:spadesScore += 5;break;
                case SPADES_SIX:spadesScore += 6;break;
                case SPADES_SEVEN:spadesScore += 7;break;
                case SPADES_EIGHT:spadesScore += 8;break;
                case SPADES_NINE:spadesScore += 9;break;
                case SPADES_TEN:
                case SPADES_JACK:
                case SPADES_QUEEN:
                case SPADES_KING:spadesScore += 10;break;
                case SPADES_ACE:spadesScore += 11;break;
            }
        }
        int result = 0;
        if (crossScore >= diamondsScore && crossScore >= heartsScore && crossScore >= spadesScore){
            result = crossScore;
        }
        if (diamondsScore >= crossScore && diamondsScore >= heartsScore && diamondsScore >= spadesScore){
            result = diamondsScore;
        }
        if (heartsScore >= diamondsScore && heartsScore >= crossScore && heartsScore >= spadesScore){
            result = heartsScore;
        }
        if (spadesScore >= diamondsScore && spadesScore >= crossScore && spadesScore >= heartsScore){
            result = spadesScore;
        }
        return result;
    }
}
