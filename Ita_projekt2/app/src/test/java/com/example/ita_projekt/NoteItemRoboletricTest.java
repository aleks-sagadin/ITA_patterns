package com.example.ita_projekt;

import android.os.Build;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.ita_projekt.MainProgram.NoteAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@Config(sdk = {Build.VERSION_CODES.O_MR1})
@RunWith(RobolectricTestRunner.class)
public class NoteItemRoboletricTest {

    private HomeActivity activity;


    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(HomeActivity.class)
                .create()
                .resume()
                .get();
    }


    @Test
    public void cardViewMargin(){

        FloatingActionButton textView = (FloatingActionButton) activity.findViewById(R.id.button_dodaj_note);
        int bottomMargin = ((CoordinatorLayout.LayoutParams) textView.getLayoutParams()).bottomMargin;
        assertEquals(32, bottomMargin);
    }
}
