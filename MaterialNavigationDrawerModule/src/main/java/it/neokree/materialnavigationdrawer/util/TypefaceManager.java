package it.neokree.materialnavigationdrawer.util;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;

public class TypefaceManager {
    private static final String TBLACK ="Montserrat-Black.otf";
    private static final String TBOLD ="Montserrat-Bold.otf";
    private static final String THAIRLINE ="Montserrat-Hairline.otf";
    private static final String TLIGHT ="Montserrat-Light.otf";
    private static final String TREGULAR = "Montserrat-Regular.otf";
    private static final String TSukhumvitSet = "SukhumvitSet.ttc";
    private final LruCache<String, Typeface> mCache;
    private final AssetManager mAssetManager;

    public TypefaceManager(AssetManager assetManager) {
        mAssetManager = assetManager;
        mCache = new LruCache<>(3);
    }
    public Typeface getTBLack() {
        return getTypeface(TBLACK);
    }

    public Typeface getTBold() {
        return getTypeface(TBOLD);
    }

    public Typeface getTHairline() {
        return getTypeface(THAIRLINE);
    }

    public Typeface getTLight() {
        return getTypeface(TLIGHT);
    }

    public Typeface getTRegular() {
        return getTypeface(TREGULAR);
    }

    public Typeface getTSukhumvitSet() {
        return getTypeface(TSukhumvitSet);
    }

    private Typeface getTypeface(final String filename) {
        Typeface typeface = mCache.get(filename);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(mAssetManager, "fonts/" + filename);
            mCache.put(filename, typeface);
        }
        return typeface;
    }
}
