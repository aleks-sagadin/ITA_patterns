package com.example.ita_projekt;

import android.os.Build;
import android.widget.NumberPicker;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ita_projekt.MainProgram.AddEditNoteActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@Config(sdk = {Build.VERSION_CODES.O_MR1})
@RunWith(RobolectricTestRunner.class)
public class AddEditNoteTest {

    private AddEditNoteActivity activity;
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(AddEditNoteActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void maxValueTest(){
        NumberPicker numberPicker = (NumberPicker) activity.findViewById(R.id.number_picker);
        int max = numberPicker.getMaxValue();
        assertEquals(10,max);
    }

    @Test
    public void minValueTest(){
        NumberPicker numberPicker = (NumberPicker) activity.findViewById(R.id.number_picker);
        int min = numberPicker.getMinValue();
        assertEquals(1,min);
    }


}
