package com.example.ita_projekt;

import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Button;

import com.example.ita_projekt.MainProgram.AddEditNoteActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;


@Config(sdk = {Build.VERSION_CODES.O_MR1})
@RunWith(RobolectricTestRunner.class)
public class LoginActivityRoboletricTest {

    private LoginActivity activity;
    private HomeActivity activityH;
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(LoginActivity.class)
                .create()
                .resume()
                .get();

        activityH = Robolectric.buildActivity(HomeActivity.class)
                .create()
                .resume()
                .get();


    }


    @Test
    public void LoginTestActivityRobo(){
        Button button = (Button) activity.findViewById( R.id.btnreg1 );

        button.performClick();
        Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
        assertEquals(MainActivity.class.getCanonicalName(), intent.getComponent().getClassName());

    }

    @Test
    public void LoginToHomeTest(){
        FloatingActionButton button = (FloatingActionButton) activityH.findViewById( R.id.button_dodaj_note );

        button.performClick();
        Intent intent = Shadows.shadowOf(activityH).peekNextStartedActivity();
        assertEquals(AddEditNoteActivity.class.getCanonicalName(), intent.getComponent().getClassName());

    }




}
