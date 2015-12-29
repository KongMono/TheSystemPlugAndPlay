package net.thesystemplugplay.tspp.util;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

@Keep
public class Util extends FragmentActivity {

    public static float getsizescreen(Activity atx) {
        DisplayMetrics metrics = new DisplayMetrics();
        atx.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;

        float scaleFactor = metrics.density;
        float widthDp = widthPixels / scaleFactor;
        float heightDp = heightPixels / scaleFactor;
        return Math.min(widthDp, heightDp);
    }

}
