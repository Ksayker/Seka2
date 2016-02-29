package ksayker.seka2.game;

import ksayker.seka2.game.players.CardGenerator;
import ksayker.seka2.game.players.Comp;
import ksayker.seka2.game.players.Player;

/**
 * Created by Yurec on 27.02.2016.
 */
@SuppressWarnings("FieldCanBeLocal")
public class SekaGame {
    private final int START_CASH_PLAYER = 100;
    private final int DEFAULT_RATE = 5;

    private String messageWin = "You Win";
    private String messageLose = "You Lose";
    private String stringBank = "Bank: ";
    private String stringCash = "cash: ";

    private String messageCompPassed = "Comp passed";
    private String messageCompShowCard = "Comp show card";
    private String messageCompDoBet = "Comp do bet";
    private String messageGameWin = "YOU WIN!";
    private String messageGameLose = "YOU LOSE.";

    private int bank;

    private boolean isEnableBet;
    private boolean isEnableShow;
    private boolean isEnablePass;
    private boolean isEnableDeal;

    private boolean isVisibleUserCard;
    private boolean isVisibleCompCard;

    private String messageFromGame;
    private String messageFromComp;

    private Player user;
    private Player comp;

    public SekaGame() {
        user = new Player();
        comp = new Comp();
    }


    private void compDoBet() {
        messageFromComp = messageCompDoBet;
        comp.deductCash(DEFAULT_RATE);
        bank += DEFAULT_RATE;

        isEnableBet = !(user.isBankrupt() || comp.isBankrupt());
        isEnableShow = true;
        isEnablePass = true;
        isEnableDeal = !(user.isBankrupt() || comp.isBankrupt());
    }

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

    private void compDoPass() {
        loseComp();

        messageFromComp = messageCompPassed;
        isEnableBet = false;
        isEnableShow = false;
        isEnablePass = false;
        isEnableDeal = !(user.isBankrupt() || comp.isBankrupt());
    }

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

    public void userDoBet() {
        user.deductCash(DEFAULT_RATE);
        bank += DEFAULT_RATE;


        courseOfTheNextPlayer();
    }

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

    public void userDoPassed() {
        winComp();

        isEnableBet = false;
        isEnableShow = false;
        isEnablePass = false;
        isEnableDeal = !(user.isBankrupt() || comp.isBankrupt());
    }

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
