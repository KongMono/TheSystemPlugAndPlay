package net.thesystemplugplay.tspp.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;


import com.pixplicity.easyprefs.library.Prefs;

import net.thesystemplugplay.tspp.R;
import net.thesystemplugplay.tspp.tranformation.PhotographicPrintAnimator;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.splashimage)
    ImageView splash;

    Runnable runFadeIn = new Runnable() {
        @Override
        public void run() {
            splash.setImageResource(R.drawable.logo);
            PhotographicPrintAnimator photographicPrintAnimator = new PhotographicPrintAnimator(splash);
            photographicPrintAnimator.start(1500);

            mHandler.postDelayed(runApp, 1500);
        }
    };

    Runnable runApp = new Runnable() {
        @Override
        public void run() {
            goToNextActivity();
        }
    };

    private Handler mHandler = new Handler();

    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        ButterKnife.bind(this);

        mHandler.postDelayed(runFadeIn, 1500);

    }

    private void goToNextActivity() {

        if (Prefs.getBoolean("logged", false)) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);

        } else {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        finish();

    }
}
