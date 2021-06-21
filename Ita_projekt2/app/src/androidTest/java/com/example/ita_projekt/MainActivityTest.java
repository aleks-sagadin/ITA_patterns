package com.example.ita_projekt;

import android.view.View;

import androidx.test.espresso.Root;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.remote.EspressoRemoteMessage;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;



@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }


    /**
     * TEST Z UPORABO OBJECT PATTERN
     *
     * */
    @Test
    public void MainATest(){
        View view = mActivity.findViewById(R.id.username);
        assertNotNull(view);
    }

    /**
     * Uporaba Instrumental testov:  v tem primetu se preverjajo ce so stringi prazni
     * */
    @Test
    public void checkStrings(){
        onView(withId(R.id.username)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText(""),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText(""),closeSoftKeyboard());
        onView(withId(R.id.repassword)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText(""),closeSoftKeyboard());
    }

    /*@Test
    public void checkToast(){
        String T = "TOAST";
         MainActivity  main= mActivityTestRule.getActivity();
        onView(withText(T)).
                inRoot(withDecorView(is(main.getWindow().getDecorView()))).
                check(matches(not(isDisplayed())));
    }
*/

    @After
    public void tearDown() throws Exception {
    mActivity = null;
    }
}