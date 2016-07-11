package com.superapp.goinoimangsieukhuyenmaiviettelvinaphonemobifone.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.superapp.goinoimangsieukhuyenmaiviettelvinaphonemobifone.R;
import com.superapp.goinoimangsieukhuyenmaiviettelvinaphonemobifone.listener.IUtilitiesListener;

/**
 * Created by ManhNV on 6/14/2016.
 */
public class UtilitiesFragment extends Fragment implements IUtilitiesListener {
    private AdRequest adRequest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_utilities, container, false);
        adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        AdView mAdView = (AdView) v.findViewById(R.id.u_adView);
        mAdView.loadAd(adRequest);
        Fragment fragment = new UtilitiesListFragment();
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_utilities, fragment)
                .commit();
        return v;
    }

    @Override
    public void changeFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction().addToBackStack("addNewFragment")
                .replace(R.id.frame_utilities, fragment)
                .commit();
    }
}
