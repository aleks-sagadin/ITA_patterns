package com.example.ita_projekt;

import android.content.Intent;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ita_projekt.MainProgram.AddEditNoteActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

public class IntroActivityTest {


    @Rule
    public ActivityTestRule<IntroActivity> mActivityTestRule = new ActivityTestRule<>(IntroActivity.class);

    private IntroActivity mActivity;

    @Test
    public void  splashTestEspresso(){
        Espresso.onView(ViewMatchers.withId(R.layout.activity_intro));
        Espresso.onView(ViewMatchers.withId(R.id.lottie));


    }
}
