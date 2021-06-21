package com.example.ita_projekt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ita_projekt.Api.Meal;
import com.example.ita_projekt.Api.RandomApiCall;
import com.example.ita_projekt.Api.RandomDataModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RandomFood extends AppCompatActivity {

    TextView textView;
    TextView opis;
    TextView sestavine;
    List<Meal> mealLis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_food);

        textView = findViewById(R.id.textView);
        opis = findViewById(R.id.textViewopis);
        sestavine = findViewById(R.id.textViewSestavine);
        mealLis = new ArrayList<>();



        //retrofit builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instance
        RandomApiCall randomApiCall = retrofit.create(RandomApiCall.class);

        Call<RandomDataModel> call = randomApiCall.getRandomDataModel();

        call.enqueue(new Callback<RandomDataModel>() {
            @Override
            public void onResponse(Call<RandomDataModel> call, Response<RandomDataModel> response) {
                //checking for reponse
                if (response.code() != 200) {
                    textView.setText("preveri povezavo");
                    return;
                }

                    RandomDataModel randomDataModel = response.body();
                mealLis = new ArrayList<>(Arrays.asList(randomDataModel.getMeals()));
                String image = mealLis.get(0).getSlika();
                String  random = "";
                 random = "NAME: " + "\n"+ mealLis.get(0).getStrMeal() +" \n" +
                 "CATEGORY:  "+ "\n" + mealLis.get(0).getStrCategory();
                 String random_opis = "INSTRUCTIONS :" +
                         " \n" + mealLis.get(0).getStrInstructions();

                String random_sestavine = "INGREDIENTS:  " +"\n"
                        + mealLis.get(0).getStrIngredient1() +"\n"
                        + mealLis.get(0).getStrIngredient2() +"\n"
                        + mealLis.get(0).getStrIngredient3() +"\n"
                        + mealLis.get(0).getStrIngredient4() +"\n"
                        + mealLis.get(0).getStrIngredient5() +"\n"
                        + mealLis.get(0).getStrIngredient6() +"\n"
                        + mealLis.get(0).getStrIngredient7() +"\n"
                        + mealLis.get(0).getStrIngredient8() +"\n"
                        + mealLis.get(0).getStrIngredient9() +"\n"
                        + mealLis.get(0).getStrIngredient10() +"\n"
                        + mealLis.get(0).getStrIngredient11() +"\n"
                        + mealLis.get(0).getStrIngredient12() +"\n"
                        + mealLis.get(0).getStrIngredient13() +"\n"
                        + mealLis.get(0).getStrIngredient14() +"\n"
                        + mealLis.get(0).getStrIngredient15() +"\n"
                        + mealLis.get(0).getStrIngredient16() +"\n"
                        + mealLis.get(0).getStrIngredient17() +"\n"
                        + mealLis.get(0).getStrIngredient18() +"\n"
                        + mealLis.get(0).getStrIngredient19() +"\n"
                        + mealLis.get(0).getStrIngredient20() +"\n";


                textView.append(random);
                opis.append(random_opis);
                sestavine.append(random_sestavine);

            }

            @Override
            public void onFailure(Call<RandomDataModel> call, Throwable t) {
                Toast.makeText(RandomFood.this, "ne gre", Toast.LENGTH_SHORT).show();

            }
        });
    }
}