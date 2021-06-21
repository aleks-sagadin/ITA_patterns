package com.example.ita_projekt;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@Config(sdk = {Build.VERSION_CODES.O_MR1})
@RunWith(RobolectricTestRunner.class)
public class MenuRoboletricTest {

    private Menu activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(Menu.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void intentSeznam(){
        Button button = (Button) activity.findViewById( R.id.seznam );

        button.performClick();
        Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
        assertEquals(HomeActivity.class.getCanonicalName(), intent.getComponent().getClassName());

    }





    @Test
    public void intentNastavitve(){
        Button button = (Button) activity.findViewById( R.id.nastavitve );

        button.performClick();
        Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
        assertEquals(Options.class.getCanonicalName(), intent.getComponent().getClassName());
    }



    @Test
    public void intentrandomRecepti(){
        Button button = (Button) activity.findViewById( R.id.nastavitve );

        button.performClick();
        Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
        assertEquals(RandomFood.class.getCanonicalName(), intent.getComponent().getClassName());

    }

    @Test
    public void intentVsiRecepti(){
        Button button = (Button) activity.findViewById( R.id.nastavitve );

        button.performClick();
        Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
        assertEquals(CategoryFood.class.getCanonicalName(), intent.getComponent().getClassName());

    }



}


