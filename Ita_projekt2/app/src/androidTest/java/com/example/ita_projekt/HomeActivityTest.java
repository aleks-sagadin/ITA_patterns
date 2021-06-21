package com.example.ita_projekt;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.rule.ActivityTestRule;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HomeActivityTest {
    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<HomeActivity>(HomeActivity.class);

    private HomeActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }

    @Test
    public void homeTest(){
        View view = mActivity.findViewById(R.layout.activity_home);
        assertNull(view);
    }

    @Test
    public  void homeClikc(){

        onView(withId(R.id.button_dodaj_note)).perform(click());
    }

    @Test
    public  void st(){
        openActionBarOverflowOrOptionsMenu(mActivityTestRule.getActivity());
        onView(withText(R.string.zapri)).check(matches(isDisplayed()));

    }

    @Test
    public void preveriFloatingButton(){
        FloatingActionButton buttonAddNote = mActivity.findViewById(R.id.button_dodaj_note);
        assertNotNull(buttonAddNote);
    }

    @Test
    public void isRecycleViewNull(){
        if (getRVcount() > 0){
            onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition(0, click()));
        }
    }


    @Test
    public void dolzinaTrenutniRecylceViewTest(){
        int dolzina = 100;
        assertTrue(getRVcount()< dolzina);
        assertFalse(getRVcount() > dolzina);

    }

    private int getRVcount(){
        RecyclerView recyclerView = (RecyclerView) mActivityTestRule.getActivity().findViewById(R.id.recycler_view);
        return recyclerView.getAdapter().getItemCount();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }

}