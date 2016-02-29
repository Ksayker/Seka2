package ksayker.seka2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Class designed for show splash screen be fore
 * the start game.
 *
 * @author Ksayker
 * @version 0.1
 * @date 28.02.2016
 */
public class SplashScreen extends Activity {
    /** Time displaying splash screen in millis.*/
    protected int splashTime = 2000;
    /** Thread displaying splash screen.*/
    private Thread splashTread;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        final SplashScreen sPlashScreen = this;

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized(this){
                        wait(splashTime);
                    }
                } catch(InterruptedException e) {}
                finally {
                    finish();
                    //start a new activity
                    Intent intent = new Intent();
                    intent.setClass(sPlashScreen, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        splashTread.start();
    }

    /**
     * Function that will handle the touch.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            synchronized(splashTread){
                splashTread.notifyAll();
            }
        }

        return true;
    }
}
