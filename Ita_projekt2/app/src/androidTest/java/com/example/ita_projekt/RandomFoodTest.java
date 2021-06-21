package com.example.ita_projekt;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;

import com.example.ita_projekt.Api.RandomApiCall;
import com.example.ita_projekt.Api.RandomDataModel;
import com.example.ita_projekt.MainProgram.Note;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class RandomFoodTest {
    @Test
    public void xml() {
        Espresso.onView(ViewMatchers.withId(R.id.textView));
        Espresso.onView(ViewMatchers.withId(R.id.textViewopis));
        Espresso.onView(ViewMatchers.withId(R.id.textViewSestavine));
    }

    @Test
    public void layoutTEst() {
        Espresso.onView(ViewMatchers.withId(R.layout.activity_random_food));
    }
}
