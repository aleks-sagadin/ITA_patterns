package com.example.ita_projekt;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Test;

public class AllFoodTest {
    @Test
    public  void xmlTest(){
        Espresso.onView(ViewMatchers.withId(R.id.test1));
        Espresso.onView(ViewMatchers.withId(R.id.novi));
    }
    @Test
    public void layoutTest(){
        Espresso.onView(ViewMatchers.withId(R.layout.activity_category_food));
    }
}
