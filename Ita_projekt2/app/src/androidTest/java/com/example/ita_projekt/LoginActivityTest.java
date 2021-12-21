package com.example.ita_projekt;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import androidx.annotation.ContentView;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.ita_projekt.MainProgram.AddEditNoteActivity;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.font.NumericShaper;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LoginActivityTest {

    /** Upraba Expresso UI testinga za android
     * https://borgs.cybrilla.com/tils/ui-testing-android/
     * https://www.vogella.com/tutorials/AndroidTestingEspresso/article.html
     * */
    private static final String LOGIN_USERNAME = "aleks1";
    private static final String PASS_USERNAME = "aleks1";
    private LoginActivity  activity;
    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void checkLoginButtonTest()  {
        onView(withId(R.id.username1)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText(LOGIN_USERNAME),closeSoftKeyboard());
        onView(withId(R.id.password1)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText(PASS_USERNAME),closeSoftKeyboard());
        onView(withId(R.id.btnsignin1)).perform(click());
    }

    @Test
    public void registerTest(){
        onView(withId(R.id.btnreg1)).perform(click());
        onView(withId(R.id.username)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText("aleks2"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText("aleks2"),closeSoftKeyboard());
        onView(withId(R.id.repassword)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText("aleks2"),closeSoftKeyboard());
        onView(withId(R.id.btnsignup)).perform(click());

    }

    @Test
    public void openReceiptsAndEditReceipTest(){
        //kličemo prejšnji test da se lahko loginamo
        checkLoginButtonTest();
        onView(withId(R.id.seznam)).perform(click());
        onView(withId(R.id.note)).perform(click());
        //dodamo novi recept
        onView(withId(R.id.title)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText("Bozicni piskoti"),closeSoftKeyboard());
        onView(withId(R.id.description)).perform(ViewActions.clearText())
                .perform(ViewActions.typeText("Sestavine"),closeSoftKeyboard());
        ViewInteraction numPicker = onView(withClassName(Matchers.equalTo(NumberPicker.class.getName())));
        numPicker.perform(setNumber(1));
        onView(withId(R.id.save_note)).perform(click());

    }
    public static ViewAction setNumber(final int num) {
        return new ViewAction() {
            @Override
            public void perform(UiController uiController, View view) {
                NumberPicker np = (NumberPicker) view;
                np.setValue(num); }
            @Override
            public String getDescription() {
                return "Set the passed number into the NumberPicker";
            }
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(NumberPicker.class);
            }
        };
    }
}