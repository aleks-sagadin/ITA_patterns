package com.example.ita_projekt;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;

import com.example.ita_projekt.MainProgram.AddEditNoteActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AddEditNoteActivityTest {

    @Rule
    public ActivityTestRule<AddEditNoteActivity> mActivityTestRule = new ActivityTestRule<AddEditNoteActivity>(AddEditNoteActivity.class);

    private AddEditNoteActivity mActivity = null;

    @Before
    public void login() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }



    @Test
    public void AddEditNoteActivityTest(){
        View view = mActivity.findViewById(R.layout.activity_add_note);
        assertNotNull(view);
    }

    @Test
    public void  NaslovJediTestEspresso(){
        onView(withId(R.id.text_view_title)).perform(ViewActions.clearText())
                .perform(typeText(""),closeSoftKeyboard());

    }
    @Test
    public void  OpisJediTestEspresso(){
        onView(withId(R.id.text_view_description)).perform(ViewActions.clearText())
                .perform(typeText(""),closeSoftKeyboard());

    }

    @Test
    public void  TezavnostJediTestEspresso(){
        onView(withId(R.id.text_view_priority)).perform(ViewActions.clearText())
                .perform(typeText(""),closeSoftKeyboard());

    }

    @Test
    public  void saveTest(){
        onView(withId(R.id.save_note)).perform(click());
    }




    private static final String TAG = "MyActivity";
    @Test
    public void validateEditText() {
        EditText  editTextTitle = mActivity.findViewById(R.id.title);
        String title = editTextTitle.getText().toString();
        Log.v(TAG, "index=" + title);


    }





   /* @Test
    public void checkInput(){



    }*/

    private boolean checkInput(String title){
        char[] chars = title.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(Character.isDigit(c)){
                sb.append(c);
                return false;
            }
        }
        return true;

    }



}
