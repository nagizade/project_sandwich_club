package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    private Sandwich sandwich;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI();
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI() {
        TextView tv_description,tv_also_known,tv_ingredients,tv_origins;
        String ingredientsString = "";
        String  alsoKnownString = "";
        String description = sandwich.getDescription();
        String placeoforigin = sandwich.getPlaceOfOrigin();

        ArrayList<String> ingredientsArray = sandwich.getIngredients();
        for(int i=0;i<ingredientsArray.size();i++) {
            ingredientsString =  ingredientsString + ingredientsArray.get(i) + ",";
        }

        ArrayList<String> alsoKnownArray = sandwich.getAlsoKnownAs();
        for(int i=0;i<alsoKnownArray.size();i++) {
            alsoKnownString = alsoKnownString + alsoKnownArray.get(i)+",";
        }

        tv_origins = findViewById(R.id.tv_place_of_origin);
        tv_also_known = findViewById(R.id.tv_also_known_text);
        tv_ingredients = findViewById(R.id.tv_ingredients_text);
        tv_description = findViewById(R.id.tv_description_text);

        tv_description.setText(description);
        tv_origins.setText(placeoforigin);
        tv_also_known.setText(alsoKnownString);
        tv_ingredients.setText(ingredientsString);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
