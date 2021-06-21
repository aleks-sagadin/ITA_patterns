package com.example.ita_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.StyleSpan;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ita_projekt.Api.Meal;
import com.example.ita_projekt.Api.RandomApiCall;
import com.example.ita_projekt.Api.RandomDataModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryFood extends AppCompatActivity {
    //www.themealdb.com/api/json/v1/1/
    TextView textView;

    TextView novi;
    TextView test1;
    TextView test2;
    List<Meal> mealLis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_food);

        textView = findViewById(R.id.textView1);
        novi = findViewById(R.id.novi);
        test1 = findViewById(R.id.test1);
        test2 = findViewById(R.id.test2);

        String NAME ="NAME";
        SpannableString ss = new SpannableString(NAME);
        StyleSpan spanBold = new StyleSpan(Typeface.BOLD);
        ss.setSpan(spanBold,0,4,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(new ScrollingMovementMethod());
        novi.setMovementMethod(new ScrollingMovementMethod());
        // opis = findViewById(R.id.textViewopis1);
        //  sestavine = findViewById(R.id.textViewSestavine1);
        mealLis = new ArrayList<>();



        //retrofit builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instance
        RandomApiCall randomApiCall = retrofit.create(RandomApiCall.class);


        Call<RandomDataModel> call = randomApiCall.getCategory();
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


                String random = "";


                for (int i = 0; i < mealLis.size(); i++) {
                    if (mealLis.get(i).getStrIngredient16() == null && mealLis.get(i).getStrIngredient17() == null) {
                        mealLis.get(i).setStrIngredient16("");
                        mealLis.get(i).setStrIngredient17("");
                        mealLis.get(i).setStrIngredient18("");
                        mealLis.get(i).setStrIngredient19("");
                        mealLis.get(i).setStrIngredient20("");
                    }


                    random = ss  + "\n" + mealLis.get(i).getStrMeal() + " \n" +
                            "CATEGORY:  " + "\n" + mealLis.get(i).getStrCategory() +
                            "\n" +"INSTRUCTIONS  :" +
                            " \n" + mealLis.get(i).getStrInstructions() + "\n" +
                            "INGREDIENTS:  " + "\n"
                            + mealLis.get(i).getStrIngredient1() + "\n"
                            + mealLis.get(i).getStrIngredient2() + "\n"
                            + mealLis.get(i).getStrIngredient3() + "\n"
                            + mealLis.get(i).getStrIngredient4() + "\n"
                            + mealLis.get(i).getStrIngredient5() + "\n"
                            + mealLis.get(i).getStrIngredient6() + "\n"
                            + mealLis.get(i).getStrIngredient7() + "\n"
                            + mealLis.get(i).getStrIngredient8() + "\n"
                            + mealLis.get(i).getStrIngredient9() + "\n"
                            + mealLis.get(i).getStrIngredient10() + "\n"
                            + mealLis.get(i).getStrIngredient11() + "\n"
                            + mealLis.get(i).getStrIngredient12() + "\n"
                            + mealLis.get(i).getStrIngredient13() + "\n"
                            + mealLis.get(i).getStrIngredient14() + "\n"
                            + mealLis.get(i).getStrIngredient15() + "\n"
                            + mealLis.get(i).getStrIngredient16() + "\n"
                            + mealLis.get(i).getStrIngredient17() + "\n"
                            + mealLis.get(i).getStrIngredient18() + "\n"
                            + mealLis.get(i).getStrIngredient19() + "\n"
                            + mealLis.get(i).getStrIngredient20() + "\n";
                    textView.append(random);
                }
            }

            @Override
            public void onFailure(Call<RandomDataModel> call, Throwable t) {
                Toast.makeText(CategoryFood.this, "ne gre", Toast.LENGTH_SHORT).show();

            }
        });


        Call<RandomDataModel> call1 = randomApiCall.getB();
        call1.enqueue(new Callback<RandomDataModel>() {
            @Override
            public void onResponse(Call<RandomDataModel> call, Response<RandomDataModel> response) {
                //checking for reponse
                if (response.code() != 200) {
                    textView.setText("preveri povezavo");
                    return;
                }

                RandomDataModel randomDataModel = response.body();
                mealLis = new ArrayList<>(Arrays.asList(randomDataModel.getMeals()));

                String random = "";

                for (int i = 0; i < mealLis.size(); i++) {
                    if (mealLis.get(i).getStrIngredient16() == null && mealLis.get(i).getStrIngredient17() == null) {
                        mealLis.get(i).setStrIngredient16("");
                        mealLis.get(i).setStrIngredient17("");
                        mealLis.get(i).setStrIngredient18("");
                        mealLis.get(i).setStrIngredient19("");
                        mealLis.get(i).setStrIngredient20("");
                    }

                    random = "NAME: " + "\n" + mealLis.get(i).getStrMeal() + " \n" +
                            "CATEGORY:  " + "\n" + mealLis.get(i).getStrCategory() +
                            "\n" +"INSTRUCTIONS  :" +
                            " \n" + mealLis.get(i).getStrInstructions() + "\n" +
                            "INGREDIENTS:  " + "\n"
                            + mealLis.get(i).getStrIngredient1() + "\n"
                            + mealLis.get(i).getStrIngredient2() + "\n"
                            + mealLis.get(i).getStrIngredient3() + "\n"
                            + mealLis.get(i).getStrIngredient4() + "\n"
                            + mealLis.get(i).getStrIngredient5() + "\n"
                            + mealLis.get(i).getStrIngredient6() + "\n"
                            + mealLis.get(i).getStrIngredient7() + "\n"
                            + mealLis.get(i).getStrIngredient8() + "\n"
                            + mealLis.get(i).getStrIngredient9() + "\n"
                            + mealLis.get(i).getStrIngredient10() + "\n"
                            + mealLis.get(i).getStrIngredient11() + "\n"
                            + mealLis.get(i).getStrIngredient12() + "\n"
                            + mealLis.get(i).getStrIngredient13() + "\n"
                            + mealLis.get(i).getStrIngredient14() + "\n"
                            + mealLis.get(i).getStrIngredient15() + "\n"
                            + mealLis.get(i).getStrIngredient16() + "\n"
                            + mealLis.get(i).getStrIngredient17() + "\n"
                            + mealLis.get(i).getStrIngredient18() + "\n"
                            + mealLis.get(i).getStrIngredient19() + "\n"
                            + mealLis.get(i).getStrIngredient20() + "\n";
                    textView.append(random);
                }
            }

            @Override
            public void onFailure(Call<RandomDataModel> call, Throwable t) {
                Toast.makeText(CategoryFood.this, "ne gre", Toast.LENGTH_SHORT).show();

            }
        });



    }
}