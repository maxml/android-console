package com.maxml.example.console;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ViewAnimator;

import com.common.logger.Log;
import com.common.logger.LogFragment;
import com.common.logger.LogWrapper;
import com.common.logger.MessageOnlyLogFilter;

public class MainActivity extends SampleActivityBase {

    public static final String TAG = "SampleActivityBase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeLogging();

        exStrings();

    }

    private void exStrings() {
        long time = System.currentTimeMillis();
        String str = new String("sdf");
        String str2 = new String("sdf");

        if (true || false && false) {

        }
        if (true) {

        }
        if (true) {

        } else {

        }


        for (int i = 0; i < 5; i += 2) {


        }

        Log.e(TAG, "" + ((true || false && false) ? "dfgsdfg" : "dsfkgjhf"));

        Log.e(TAG, "" + str.equals(str2));
        Log.e(TAG, "" + (str == str2));

        Log.e(TAG, "" + (System.currentTimeMillis() - time));
    }
}

class SampleActivityBase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Set up targets to receive log data
     */
    public void initializeLogging() {
        // Wraps Android's native log framework.
        LogWrapper logWrapper = new LogWrapper();
        // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
        Log.setLogNode(logWrapper);

        // Filter strips out everything except the message text.
        MessageOnlyLogFilter msgFilter = new MessageOnlyLogFilter();
        logWrapper.setNext(msgFilter);

        // On screen logging via a fragment with a TextView.
        LogFragment logFragment = (LogFragment) getSupportFragmentManager()
                .findFragmentById(R.id.log_fragment);
        msgFilter.setNext(logFragment.getLogView());

        ViewAnimator output = (ViewAnimator) findViewById(R.id.sample_output);
        output.setDisplayedChild(1);

        Log.i(MainActivity.TAG, "Ready");
    }
}