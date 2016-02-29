package ksayker.seka2.game;

import ksayker.seka2.game.players.CardGenerator;
import ksayker.seka2.game.players.Comp;
import ksayker.seka2.game.players.Player;

/**
 * Class contain seka game logic.
 * @author Kasyker
 * @date 27.02.2016
 * @version 0.1
 */
@SuppressWarnings("FieldCanBeLocal")
public class SekaGame {
    /** Started cash game.*/
    private final int START_CASH_PLAYER = 100;
    /** Default rate*/
    private final int DEFAULT_RATE = 5;

    /** Message win to user*/
    private String messageWin = "You Win";
    /** Message lose to user*/
    private String messageLose = "You Lose";
    /** String value bank*/
    private String stringBank = "Bank: ";
    /** String value cash*/
    private String stringCash = "cash: ";

    /** Message to user from computer*/
    private String messageCompPassed = "Comp passed";
    /** Message to user from computer*/
    private String messageCompShowCard = "Comp show card";
    /** Message to user from computer*/
    private String messageCompDoBet = "Comp do bet";
    /** Message to user*/
    private String messageGameWin = "YOU WIN!";
    /** Message to user*/
    private String messageGameLose = "YOU LOSE.";

    /** Cash in bank*/
    private int bank;

    /** Stay enable bet button*/
    private boolean isEnableBet;
    /** Stay enable show button*/
    private boolean isEnableShow;
    /** Stay enable pass button*/
    private boolean isEnablePass;
    /** Stay enable deal button*/
    private boolean isEnableDeal;

    /** Stay display user card*/
    private boolean isVisibleUserCard;
    /** Stay display comp card*/
    private boolean isVisibleCompCard;

    /** Main message from game*/
    private String messageFromGame;
    /** Message from computer*/
    private String messageFromComp;

    /** User object*/
    private Player user;
    /** User object*/
    private Player comp;

    /** Seka game constructor*/
    public SekaGame() {
        user = new Player();
        comp = new Comp();
    }


    /**
     * Comp do bet.
     */
    private void compDoBet() {
        messageFromComp = messageCompDoBet;
        comp.deductCash(DEFAULT_RATE);
        bank += DEFAULT_RATE;

        isEnableBet = !(user.isBankrupt() || comp.isBankrupt());
        isEnableShow = true;
        isEnablePass = true;
        isEnableDeal = !(user.isBankrupt() || comp.isBankrupt());
    }

    /**
     * Comp do show card.
     */
    private void compDoShow() {
        if (user.getPlayerScore() >= comp.getPlayerScore()) {
            loseComp();
        } else {
            winComp();
        }

        messageFromComp = messageCompShowCard;
        isEnableBet = false;
        isEnableShow = false;
        isEnablePass = false;
        isEnableDeal = !(user.isBankrupt() || comp.isBankrupt());
    }

    /**
     * Comp do pass.
     */
    private void compDoPass() {
        loseComp();

        messageFromComp = messageCompPassed;
        isEnableBet = false;
        isEnableShow = false;
        isEnablePass = false;
        isEnableDeal = !(user.isBankrupt() || comp.isBankrupt());
    }

    /**
     * Comp lose.
     */
    private void loseComp() {
        user.addCash(bank);
        bank = 0;

        messageFromGame = messageWin;
        isVisibleUserCard = true;
        isVisibleCompCard = true;
        if (comp.isBankrupt()){
            messageFromGame = messageGameWin;
            isEnableBet = false;
            isEnableShow = false;
            isEnablePass = false;
            isEnableDeal = false;
        }
    }

    /**
     * Comp won.
     */
    private void winComp() {
        comp.addCash(bank);
        bank = 0;

        messageFromGame = messageLose;
        isVisibleUserCard = true;
        isVisibleCompCard = true;

        if (user.isBankrupt()){
            messageFromGame = messageGameLose;
            isEnableBet = false;
            isEnableShow = false;
            isEnablePass = false;
            isEnableDeal = false;
        }
    }

    /**
     * Course of next player.
     */
    private void courseOfTheNextPlayer() {
        int tactic = comp.doStep();
        switch (tactic) {
            case Player.DO_BET:
                compDoBet();
                messageFromGame = stringBank + bank;
                break;
            case Player.DO_SHOW:
                compDoShow();
                break;
            case Player.DO_PASS:
                compDoPass();
                break;
        }
    }

    /**
     * Start new game.
     */
    public void startNewGame() {
        bank = 0;
        user.setCash(START_CASH_PLAYER);
        comp.setCash(START_CASH_PLAYER);

        messageFromGame = stringBank + bank;
        isVisibleCompCard = false;
        isEnableBet = false;
        isEnableShow = false;
        isEnablePass = false;
        isEnableDeal = true;
    }

    /**
     * User press bet.
     */
    public void userDoBet() {
        user.deductCash(DEFAULT_RATE);
        bank += DEFAULT_RATE;


        courseOfTheNextPlayer();
    }

    /**
     * User press show.
     */
    public void userDoShow() {
        if (comp.getPlayerScore() >= user.getPlayerScore()) {
            winComp();
        } else {
            loseComp();
        }

        isEnableBet = false;
        isEnableShow = false;
        isEnablePass = false;
        isEnableDeal = !(user.isBankrupt() || comp.isBankrupt());
    }

    /**
     * User press pass.
     */
    public void userDoPassed() {
        winComp();

        isEnableBet = false;
        isEnableShow = false;
        isEnablePass = false;
        isEnableDeal = !(user.isBankrupt() || comp.isBankrupt());
    }

    /**
     * User press deal.
     */
    public void userDoDeal() {
        CardGenerator cardGenerator = new CardGenerator();
        user.setCards(cardGenerator.generateRandomCardsForPlayer());
        comp.setCards(cardGenerator.generateRandomCardsForPlayer());
        user.deductCash(DEFAULT_RATE);
        bank += DEFAULT_RATE;
        comp.deductCash(DEFAULT_RATE);
        bank += DEFAULT_RATE;

        messageFromGame = stringBank + bank;
        messageFromComp = "";
        isEnableBet = !(user.isBankrupt() || comp.isBankrupt());
        isEnableShow = true;
        isEnablePass = true;
        isEnableDeal = false;
        isVisibleCompCard = false;
        isVisibleUserCard = true;
    }

    /**
     * Get current game state.
     *
     * @return Object that contain current game state.
     */
    public GameState getGameState() {
        return new GameState(
                stringCash + comp.getCash(),
                stringCash + user.getCash(),
                messageFromComp,
                isEnableBet,
                isEnableShow,
                isEnablePass,
                isEnableDeal,
                isVisibleCompCard,
                isVisibleUserCard,
                user.getCards(),
                comp.getCards(),
                messageFromGame
        );
    }
}
