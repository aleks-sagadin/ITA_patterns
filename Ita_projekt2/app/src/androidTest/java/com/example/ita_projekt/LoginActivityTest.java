package com.example.ita_projekt;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.ContentView;
import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LoginActivityTest {

    /** Upraba Expresso UI testinga za android
     * https://borgs.cybrilla.com/tils/ui-testing-android/
     * https://www.vogella.com/tutorials/AndroidTestingEspresso/article.html
     * */

    private LoginActivity  activity;
    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule =
            new ActivityTestRule<LoginActivity>(LoginActivity.class);

    @Test
    public void checkLoginButton()  {
        onView(withId(R.id.username1)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText(""),closeSoftKeyboard());
        onView(withId(R.id.password1)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText(""),closeSoftKeyboard());

        //onView(withId(R.id.btnsignin1)).perform(click());

        //onView(withId(R.id.btnreg1)).perform(click());
    }






}