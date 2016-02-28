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
    private ImageView ivCompLeft;
    private ImageView ivCompCenter;
    private ImageView ivCompRight;
    private ImageView ivUserLeft;
    private ImageView ivUserCenter;
    private ImageView ivUserRight;

    private Button btNewGame;
    private Button btBet;
    private Button btPass;
    private Button btDeal;
    private Button btShow;

    private TextView tvCenterTable;
    private TextView tvCompCash;
    private TextView tvUserCash;
    private TextView tvCompMessage;

    private ImageLoader imageLoader;
    private SekaGame sekaGame;
    private Map<Cards, Integer> images;


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

    private void loadImages() {
        images = imageLoader.loadImages();
    }

    private void hideCompCard(){
        ivCompLeft.setImageResource(R.drawable.shirt);
        ivCompCenter.setImageResource(R.drawable.shirt);
        ivCompRight.setImageResource(R.drawable.shirt);
    }

    private void hideUserCard(){
        ivUserLeft.setImageResource(R.drawable.shirt);
        ivUserCenter.setImageResource(R.drawable.shirt);
        ivUserRight.setImageResource(R.drawable.shirt);
    }

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
     * with out btNewGame
     */
    private void disableGameControlButton(){
        btPass.setEnabled(false);
        btShow.setEnabled(false);
        btBet.setEnabled(false);
        btDeal.setEnabled(false);
    }

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
