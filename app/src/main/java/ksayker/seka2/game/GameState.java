package ksayker.seka2.game;

import ksayker.seka2.game.players.PlayerCards;

/**
 * Class contain game state.
 *
 * @author Ksayker
 * @data 27.02.2016
 * @version 0.1
 */
@SuppressWarnings("JavaDoc")
public class GameState {
    /** string comp cash*/
    private String compCash;
    /** string user cash*/
    private String userCash;

    /** message from computer*/
    private String messageFromComputer;
    /** message from game*/
    private String messageFromGame;

    /** enable bet button*/
    private boolean isEnableBet;
    /** enable show button*/
    private boolean isEnableShow;
    /** enable pass button*/
    private boolean isEnablePass;
    /** enable deal button*/
    private boolean isEnableDeal;

    /** visible user card*/
    private boolean isVisibleUserCard;
    /** visible comp card*/
    private boolean isVisibleCompCard;

    private PlayerCards userCards;
    private PlayerCards compCards;

    /**
     * Game state constructor.
     *
     * @param compCash comp cash
     * @param userCash user cash
     * @param messageFromComputer message from computer
     * @param isEnableBet is enable bet button
     * @param isEnableShow is enable show button
     * @param isEnablePass is enable pass button
     * @param isEnableDeal is enable deal button
     * @param isVisibleCompCard is visible user card
     * @param isVisibleUserCard is visible comp card
     * @param userCards user cards
     * @param compCards comp cards
     * @param messageFromGame message from game
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
