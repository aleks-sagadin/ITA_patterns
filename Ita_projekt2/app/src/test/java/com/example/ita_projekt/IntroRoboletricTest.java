package com.example.ita_projekt;


import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.airbnb.lottie.LottieAnimationView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static android.content.ContentValues.TAG;
import static org.junit.Assert.assertEquals;

@Config(sdk = {Build.VERSION_CODES.O_MR1})
@RunWith(RobolectricTestRunner.class)
public class IntroRoboletricTest {


    private IntroActivity activity;
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(IntroActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void startDelayTest(){
        LottieAnimationView textView = (LottieAnimationView) activity.findViewById(R.id.lottie);
        long bottomMargin = textView.animate().getStartDelay();
        assertEquals(4000,bottomMargin);
    }

    @Test
    public void DurationTest(){
        LottieAnimationView lottieAnimationView = (LottieAnimationView) activity.findViewById(R.id.lottie);
        long translationY = lottieAnimationView.animate().getDuration();
        assertEquals(2000,translationY);
    }




}
