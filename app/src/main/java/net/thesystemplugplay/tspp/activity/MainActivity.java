package net.thesystemplugplay.tspp.activity;

import android.os.Bundle;

import android.widget.Toast;

import com.badoo.mobile.util.WeakHandler;

import net.thesystemplugplay.tspp.R;
import net.thesystemplugplay.tspp.fragments.HomeFragment;
import net.thesystemplugplay.tspp.fragments.LogoutFragment;


import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialAccountListener;

public class MainActivity extends MaterialNavigationDrawer implements MaterialAccountListener{
//    private GCMClientManager pushClientManager;
    private WeakHandler mHandler = new WeakHandler();
    boolean doubleBackToExitPressedOnce;

    @Override
    public void init(Bundle bundle) {

        MaterialAccount account = new MaterialAccount(this.getResources(),"PRAEDAO SIHAPONG","ID: 11035112349",R.drawable.photo, R.drawable.ng_intro);
        this.addAccount(account);

        allowArrowAnimation();
        enableToolbarElevation();

        // set listener
        this.setAccountListener(this);

        // create sections
        this.addSection(newSectionWithRealColor(getResources().getString(R.string.sb1), R.drawable.menu_icon_dashboard, new HomeFragment()));
        addDivisor();
        this.addSection(newSectionWithRealColor(getResources().getString(R.string.sb2), R.drawable.menu_icon_create_member, new HomeFragment()));
        addDivisor();
        this.addSection(newSectionWithRealColor(getResources().getString(R.string.sb4), R.drawable.menu_icon_extra, new HomeFragment()));
        addDivisor();
        this.addSection(newSectionWithRealColor(getResources().getString(R.string.sb5), R.drawable.menu_icon_how_to, new HomeFragment()));
        addDivisor();
        this.addSection(newSectionWithRealColor(getResources().getString(R.string.sb6), R.drawable.menu_icon_insurance, new HomeFragment()));
        addDivisor();
        this.addSection(newSectionWithRealColor(getResources().getString(R.string.sb7), R.drawable.menu_icon_sale_list, new HomeFragment()));
        addDivisor();
        this.addSection(newSectionWithRealColor(getResources().getString(R.string.sb8), R.drawable.menu_icon_buy_list, new HomeFragment()));
        addDivisor();
        this.addSection(newSectionWithRealColor(getResources().getString(R.string.sb9), R.drawable.menu_icon_order_pagkage, new HomeFragment()));
        addDivisor();
        this.addSection(newSectionWithRealColor(getResources().getString(R.string.sb10), R.drawable.menu_icon_log_out, new LogoutFragment()));

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setDefaultSectionLoaded(0);
                closeDrawer();
            }
        }, 1500);

        // add pattern
        this.setBackPattern(MaterialNavigationDrawer.BACKPATTERN_BACK_TO_FIRST);


//        pushClientManager = new GCMClientManager(this, PROJECT_NUMBER);
//
//        pushClientManager.registerIfNeeded(new GCMClientManager.RegistrationCompletedHandler() {
//            @Override
//            public void onSuccess(String registrationId, boolean isNewRegistration) {
//
//                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
//                SharedPreferences.Editor editor = settings.edit();
//                editor.putString("registrationId", registrationId);
//                editor.commit();
//
//                Call<RegisterPushEntity> call = restClient.getPushService().getPushRegister(
//                        getResources().getString(R.string.device),
//                        getResources().getString(R.string.true_app_name),
//                        getResources().getString(R.string.app_version),
//                        OpenUDID_manager.getOpenUDID(),
//                        registrationId,
//                        getResources().getString(R.string.device),
//                        getResources().getString(R.string.device),
//                        Build.VERSION.RELEASE,
//                        "enabled");
//                call.enqueue(new Callback<RegisterPushEntity>() {
//                    @Override
//                    public void onResponse(Response<RegisterPushEntity> response) {
//                        Log.d("getPushRegister", response.body().toString());
//                    }
//
//                    @Override
//                    public void onFailure(Throwable t) {
//                        Log.d("RetrofitError", t.getMessage());
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(String ex) {
//                super.onFailure(ex);
//                Log.i("onFailure", ex);
//            }
//        });
    }


    @Override
    public void onBackPressed() {
        if (!isCurrentFragmentChild && getCurrentSection() == getSectionList().get(0)) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            mHandler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onAccountOpening(MaterialAccount account) {

    }

    @Override
    public void onChangeAccount(MaterialAccount newAccount) {

    }
}

