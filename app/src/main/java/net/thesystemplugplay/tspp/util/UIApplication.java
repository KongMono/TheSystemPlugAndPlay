package net.thesystemplugplay.tspp.util;

import android.app.Application;
import android.content.ContextWrapper;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.pixplicity.easyprefs.library.Prefs;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import io.fabric.sdk.android.Fabric;
import net.thesystemplugplay.tspp.activity.SplashActivity;


public class UIApplication extends Application {
    public static class Config {
        public static final boolean DEVELOPER_MODE = false;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());

        new Prefs.Builder()
                .setContext(this)
                .build();

//        CustomActivityOnCrash.setLaunchActivityEvenIfInBackground(true);
//        CustomActivityOnCrash.setRestartActivityClass(SplashActivity.class);
//        CustomActivityOnCrash.setErrorActivityClass(CustomErrorActivity.class);
//        CustomActivityOnCrash.install(this);

    }

}
