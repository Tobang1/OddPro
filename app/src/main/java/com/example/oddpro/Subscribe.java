package com.example.oddpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import static com.example.oddpro.Constants.SKU_WEEKLY;
import static com.example.oddpro.Constants.SKU_MONTHLY;
import static com.example.oddpro.Constants.SKU_THREEMONTH;
import static com.example.oddpro.Constants.SKU_SIXMONTH;
import static com.example.oddpro.Constants.SKU_ANNUALY;
import static com.example.oddpro.Constants.base64EncodedPublicKey;

public class Subscribe extends AppCompatActivity implements IabBroadcastReciever.IabBroadcastListener, DialogInterface.OnClickListener {

    //Debug tag for logging
    static final String TAG = "Subscribe";

    //check if user have active subscription

    boolean mSubscribeToOddpro = false;

    //will the subscription auto renew?
    boolean mAutoRenewEnable = false;

    //Tracks the currently owned subsription to the odd pro plan
    String mOddproSku = "";
    String mFirstChoiceSku = "";
    String mSecondChoiceSku = "";
    String mThirdChoiceSku = "";
    String mFourthChoiceSku = "";
    String mFifthChoiceSku = "";


    //Used to select betweeen subsription on a weekly, monthly, threemonth, sixmonth, annually
    String mSelectedSubscriptionPeriod = "";
    // SKU for our subscription

    //arbitiart request code for the purchase flow
    static final int RC_REQUEST = 10001;

    // The helper object





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
    }
}