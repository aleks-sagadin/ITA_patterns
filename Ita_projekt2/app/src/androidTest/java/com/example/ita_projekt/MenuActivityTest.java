package com.example.ita_projekt;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MenuActivityTest {
    @Rule
    public ActivityTestRule<Menu> mActivityTestRule = new ActivityTestRule<>(Menu.class);
    private Menu mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }


    @Test
    public void  MenuTestEspresso(){
        Espresso.onView(ViewMatchers.withId(R.layout.activity_menu));
        Espresso.onView(ViewMatchers.withId(R.id.seznam));
        Espresso.onView(ViewMatchers.withId(R.id.nastavitve));


    }

    @Test
    public void TestButtoniXML(){
        Espresso.onView(ViewMatchers.withId(R.id.kategorije));
        Espresso.onView(ViewMatchers.withId(R.id.buttonrandom));
    }

}
