package ksayker.seka2.game.players;

import java.util.Random;

/**
 * Class contain computer logic.
 *
 * @author Ksayker
 * @data 27.02.2016
 * @version 0.1
 */
public class Comp extends Player {
    @Override
    /**
     * Get computer step.
     */
    public int doStep() {
        Random random = new Random();

        int result;
        int cardScore = getPlayerScore();
        int lot;
        if (cardScore >= 20) {
            result = DO_BET;
        } else if (cardScore >= 15) {
            lot = random.nextInt(4);
            if (lot != 0) {
                result = DO_BET;
            } else {
                result = DO_SHOW;
            }
        } else if (cardScore >= 11) {
            lot = random.nextInt(2);
            if (lot == 0) {
                result = DO_BET;
            } else {
                result = DO_SHOW;
            }
        } else if (cardScore >= 7) {
            lot = random.nextInt(5);
            if (lot == 0) {
                result = DO_BET;
            } else {
                if (lot == 1) {
                    result = DO_PASS;
                } else {
                    result = DO_SHOW;
                }
            }
        } else if (cardScore >= 4) {
            lot = random.nextInt(5);
            if (lot == 0) {
                result = DO_PASS;
            } else {
                result = DO_SHOW;
            }
        } else {
            lot = random.nextInt(2);
            if (lot == 0){
                result = DO_SHOW;
            } else {
                result = DO_PASS;
            }
        }
        return result;
    }
}
