package ksayker.seka2;

import java.util.HashMap;
import java.util.Map;

import ksayker.seka2.game.players.cards.Cards;

/**
 * Created by Yurec on 27.02.2016.
 */
public class ImageLoader {
    public Map<Cards, Integer> loadImages() {
        Map<Cards, Integer> result = new HashMap<>();

        result.put(Cards.CROSS_TWO, R.drawable.cross_two);
        result.put(Cards.CROSS_TWO, R.drawable.cross_two);
        result.put(Cards.CROSS_THREE, R.drawable.cross_three);
        result.put(Cards.CROSS_FOUR, R.drawable.cross_four);
        result.put(Cards.CROSS_FIVE, R.drawable.cross_five);
        result.put(Cards.CROSS_SIX, R.drawable.cross_six);
        result.put(Cards.CROSS_SEVEN, R.drawable.cross_seven);
        result.put(Cards.CROSS_EIGHT, R.drawable.cross_eight);
        result.put(Cards.CROSS_NINE, R.drawable.cross_nine);
        result.put(Cards.CROSS_TEN, R.drawable.cross_ten);
        result.put(Cards.CROSS_JACK, R.drawable.cross_jack);
        result.put(Cards.CROSS_QUEEN, R.drawable.cross_queen);
        result.put(Cards.CROSS_KING, R.drawable.cross_king);
        result.put(Cards.CROSS_ACE, R.drawable.cross_ace);
        result.put(Cards.DIAMONDS_TWO, R.drawable.diamonds_two);
        result.put(Cards.DIAMONDS_THREE, R.drawable.diamonds_three);
        result.put(Cards.DIAMONDS_FOUR, R.drawable.diamonds_four);
        result.put(Cards.DIAMONDS_FIVE, R.drawable.diamonds_five);
        result.put(Cards.DIAMONDS_SIX, R.drawable.diamonds_six);
        result.put(Cards.DIAMONDS_SEVEN, R.drawable.diamonds_seven);
        result.put(Cards.DIAMONDS_EIGHT, R.drawable.diamonds_eight);
        result.put(Cards.DIAMONDS_NINE, R.drawable.diamonds_nine);
        result.put(Cards.DIAMONDS_TEN, R.drawable.diamonds_ten);
        result.put(Cards.DIAMONDS_JACK, R.drawable.diamonds_jack);
        result.put(Cards.DIAMONDS_QUEEN, R.drawable.diamonds_queen);
        result.put(Cards.DIAMONDS_KING, R.drawable.diamonds_king);
        result.put(Cards.DIAMONDS_ACE, R.drawable.diamonds_ace);
        result.put(Cards.SPADES_TWO, R.drawable.hearts_two);
        result.put(Cards.SPADES_THREE, R.drawable.hearts_three);
        result.put(Cards.SPADES_FOUR, R.drawable.hearts_four);
        result.put(Cards.SPADES_FIVE, R.drawable.hearts_five);
        result.put(Cards.SPADES_SIX, R.drawable.hearts_six);
        result.put(Cards.SPADES_SEVEN, R.drawable.hearts_seven);
        result.put(Cards.SPADES_EIGHT, R.drawable.hearts_eight);
        result.put(Cards.SPADES_NINE, R.drawable.hearts_nine);
        result.put(Cards.SPADES_TEN, R.drawable.hearts_ten);
        result.put(Cards.SPADES_JACK, R.drawable.hearts_jack);
        result.put(Cards.SPADES_QUEEN, R.drawable.hearts_queen);
        result.put(Cards.SPADES_KING, R.drawable.hearts_king);
        result.put(Cards.SPADES_ACE, R.drawable.hearts_ace);
        result.put(Cards.HEARTS_TWO, R.drawable.spades_two);
        result.put(Cards.HEARTS_THREE, R.drawable.spades_three);
        result.put(Cards.HEARTS_FOUR, R.drawable.spades_four);
        result.put(Cards.HEARTS_FIVE, R.drawable.spades_five);
        result.put(Cards.HEARTS_SIX, R.drawable.spades_six);
        result.put(Cards.HEARTS_SEVEN, R.drawable.spades_seven);
        result.put(Cards.HEARTS_EIGHT, R.drawable.spades_eight);
        result.put(Cards.HEARTS_NINE, R.drawable.spades_nine);
        result.put(Cards.HEARTS_TEN, R.drawable.spades_ten);
        result.put(Cards.HEARTS_JACK, R.drawable.spades_jack);
        result.put(Cards.HEARTS_QUEEN, R.drawable.spades_queen);
        result.put(Cards.HEARTS_KING, R.drawable.spades_king);
        result.put(Cards.HEARTS_ACE, R.drawable.spades_ace);

        return result;
    }
}
