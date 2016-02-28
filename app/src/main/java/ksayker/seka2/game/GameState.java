package ksayker.seka2.game;

import ksayker.seka2.game.players.PlayerCards;

/**
 * Created by Yurec on 27.02.2016.
 */
public class GameState {
    private String compCash;
    private String userCash;

    private String messageFromComputer;
    private String messageFromGame;

    private boolean isEnableBet;
    private boolean isEnableShow;
    private boolean isEnablePass;
    private boolean isEnableDeal;

    private boolean isVisibleUserCard;
    private boolean isVisibleCompCard;

    private PlayerCards userCards;
    private PlayerCards compCards;

    /**
     * message from game перекрывает bank
     * @param compCash
     * @param userCash
     * @param messageFromComputer
     * @param isEnableBet
     * @param isEnableShow
     * @param isEnablePass
     * @param isEnableDeal
     * @param isVisibleCompCard
     * @param isVisibleUserCard
     * @param userCards
     * @param compCards
     * @param messageFromGame
     */
    public GameState(String compCash, String userCash, String messageFromComputer,
                     boolean isEnableBet, boolean isEnableShow, boolean isEnablePass,
                     boolean isEnableDeal, boolean isVisibleCompCard, boolean isVisibleUserCard,
                     PlayerCards userCards, PlayerCards compCards, String messageFromGame){

        this.compCash = compCash;
        this.userCash = userCash;
        this.messageFromComputer = messageFromComputer;
        this.isEnableBet = isEnableBet;
        this.isEnableShow = isEnableShow;
        this.isEnablePass = isEnablePass;
        this.isEnableDeal = isEnableDeal;
        this.isVisibleCompCard = isVisibleCompCard;
        this.isVisibleUserCard = isVisibleUserCard;
        this.userCards = userCards;
        this.compCards = compCards;
        this.messageFromGame = messageFromGame;
    }


    public String getCompCash() {
        return compCash;
    }

    public String getUserCash() {
        return userCash;
    }

    public String getMessageFromComputer() {
        return messageFromComputer;
    }

    public PlayerCards getCompCards() {
        return compCards;
    }

    public PlayerCards getUserCards() {
        return userCards;
    }

    public boolean isEnableBet() {
        return isEnableBet;
    }

    public boolean isEnableShow() {
        return isEnableShow;
    }

    public boolean isEnableDeal() {
        return isEnableDeal;
    }

    public boolean isEnablePass() {
        return isEnablePass;
    }

    public boolean isVisibleCompCard() {
        return isVisibleCompCard;
    }

    public boolean isVisibleUserCard() {
        return isVisibleUserCard;
    }

    public String getMessageFromGame(){
        return messageFromGame;
    }
}
