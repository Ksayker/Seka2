package ksayker.seka2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;

import ksayker.seka2.game.GameState;
import ksayker.seka2.game.SekaGame;
import ksayker.seka2.game.players.cards.Cards;

public class MainActivity extends AppCompatActivity {
    /** image view with left computer card*/
    private ImageView ivCompLeft;
    /** image view with center computer card*/
    private ImageView ivCompCenter;
    /** image view with right computer card*/
    private ImageView ivCompRight;
    /** image view with left user card*/
    private ImageView ivUserLeft;
    /** image view with center user card*/
    private ImageView ivUserCenter;
    /** image view with right user card*/
    private ImageView ivUserRight;

    /** button that started new game*/
    private Button btNewGame;
    /** button do bet*/
    private Button btBet;
    /** button do pass*/
    private Button btPass;
    /** button do deal*/
    private Button btDeal;
    /** button do show*/
    private Button btShow;

    /** center message area*/
    private TextView tvCenterTable;
    /** area with computer cash*/
    private TextView tvCompCash;
    /** area with user cash*/
    private TextView tvUserCash;
    /** area with message from computer*/
    private TextView tvCompMessage;

    /** image loader*/
    private ImageLoader imageLoader;
    /** main game controller*/
    private SekaGame sekaGame;
    /** map with image resources*/
    private Map<Cards, Integer> images;

    /**
     * Method designed from creating game objects.
     */
    private void createGameObjects() {
        ivCompLeft = (ImageView) findViewById(R.id.iv_compLeftCard);
        ivCompCenter = (ImageView) findViewById(R.id.iv_compCenterCard);
        ivCompRight = (ImageView) findViewById(R.id.iv_compRightCard);
        ivUserLeft = (ImageView) findViewById(R.id.iv_userLeftCard);
        ivUserCenter = (ImageView) findViewById(R.id.iv_userCenterCard);
        ivUserRight = (ImageView) findViewById(R.id.iv_userRightCard);

        btBet = (Button) findViewById(R.id.bt_bet);
        btPass = (Button) findViewById(R.id.bt_pass);
        btNewGame = (Button) findViewById(R.id.bt_new_game);
        btDeal = (Button) findViewById(R.id.bt_deal);
        btShow = (Button) findViewById(R.id.bt_show);

        tvCompCash = (TextView) findViewById(R.id.tv_compCash);
        tvCenterTable = (TextView) findViewById(R.id.tv_centerTable);
        tvUserCash = (TextView) findViewById(R.id.tv_userCash);
        tvCompMessage = (TextView) findViewById(R.id.tv_compMessage);

        sekaGame = new SekaGame();
        imageLoader = new ImageLoader();
    }

    /**
     * Loading images to map.
     */
    private void loadImages() {
        images = imageLoader.loadImages();
    }

    /**
     * Hiding computer card.
     */
    private void hideCompCard(){
        ivCompLeft.setImageResource(R.drawable.shirt);
        ivCompCenter.setImageResource(R.drawable.shirt);
        ivCompRight.setImageResource(R.drawable.shirt);
    }

    /**
     * Hiding user card.
     */
    private void hideUserCard(){
        ivUserLeft.setImageResource(R.drawable.shirt);
        ivUserCenter.setImageResource(R.drawable.shirt);
        ivUserRight.setImageResource(R.drawable.shirt);
    }

    /**
     * Initialization click listeners.
     */
    private void initOnClickListeners(){
        btNewGame.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sekaGame.startNewGame();
                        displayGameState(sekaGame.getGameState());

                    }
                }
        );
        btDeal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sekaGame.userDoDeal();
                        displayGameState(sekaGame.getGameState());
                    }
                }
        );
        btBet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sekaGame.userDoBet();
                        displayGameState(sekaGame.getGameState());
                    }
                }
        );
        btShow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sekaGame.userDoShow();
                        displayGameState(sekaGame.getGameState());
                    }
                }
        );
        btPass.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sekaGame.userDoPassed();
                        displayGameState(sekaGame.getGameState());
                    }
                }
        );
    }

    /**
     * Displaying current game state.
     *
     * @param gameState object that contain game state.
     */
    private void displayGameState(GameState gameState){
        if (gameState.getMessageFromGame() != null){
            tvCenterTable.setText(gameState.getMessageFromGame());
        } else {
            tvCenterTable.setText(gameState.getMessageFromGame());
        }
        tvCompCash.setText(gameState.getCompCash());
        tvUserCash.setText(gameState.getUserCash());
        tvCompMessage.setText(gameState.getMessageFromComputer());
        if (gameState.isVisibleUserCard() && gameState.getUserCards()!= null){
            ivUserLeft.setImageResource(images.get(gameState.getUserCards().firstCard));
            ivUserCenter.setImageResource(images.get(gameState.getUserCards().secondCard));
            ivUserRight.setImageResource(images.get(gameState.getUserCards().thirdCard));
        } else {
            ivUserLeft.setImageResource(R.drawable.shirt);
            ivUserCenter.setImageResource(R.drawable.shirt);
            ivUserRight.setImageResource(R.drawable.shirt);
        }
        if (gameState.isVisibleCompCard()&& gameState.getUserCards()!= null){
            ivCompLeft.setImageResource(images.get(gameState.getCompCards().firstCard));
            ivCompCenter.setImageResource(images.get(gameState.getCompCards().secondCard));
            ivCompRight.setImageResource(images.get(gameState.getCompCards().thirdCard));
        } else {
            ivCompLeft.setImageResource(R.drawable.shirt);
            ivCompCenter.setImageResource(R.drawable.shirt);
            ivCompRight.setImageResource(R.drawable.shirt);
        }
        btBet.setEnabled(gameState.isEnableBet());
        btShow.setEnabled(gameState.isEnableShow());
        btPass.setEnabled(gameState.isEnablePass());
        btDeal.setEnabled(gameState.isEnableDeal());
    }

    /**
     * Disable game controlled button with out button new game.
     */
    private void disableGameControlButton(){
        btPass.setEnabled(false);
        btShow.setEnabled(false);
        btBet.setEnabled(false);
        btDeal.setEnabled(false);
    }

    /**
     * Called when the activity with game is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createGameObjects();
        loadImages();
        initOnClickListeners();
        hideCompCard();
        hideUserCard();
        disableGameControlButton();
    }
}
