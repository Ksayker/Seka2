package ksayker.seka2.game.players;

/**
 * Created by Yurec on 27.02.2016.
 */
public interface Player {
    int DO_BET = 1;
    int DO_SHOW = 2;
    int DO_PASS = 3;

    void setCash(int value);
    int getCash();
    void addCash(int value);
    void deductCash(int value);

    boolean isBankrupt();
    PlayerCards getCards();
    void setCards(PlayerCards playerCards);
    int doStep();
    int getPlayerScore();
}
