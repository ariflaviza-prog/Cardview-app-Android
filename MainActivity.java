package com.example.assignment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.Model.FoodModel;

import java.util.ArrayList;

import Adapterpkg.FoodAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);

        // Setup LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Prepare Data
        ArrayList<FoodModel> arrlist = new ArrayList<>();
        arrlist.add(new FoodModel(R.drawable.cheese, "Cheese Burger"));
        arrlist.add(new FoodModel(R.drawable.macaroni, "Fettuccine Alfredo Pasta"));
        arrlist.add(new FoodModel(R.drawable.fries, "French fries"));
        arrlist.add(new FoodModel(R.drawable.pasta, "Fruits cocktail"));
        arrlist.add(new FoodModel(R.drawable.kebab, "Loaded Cheese Fries"));
        arrlist.add(new FoodModel(R.drawable.pizza, "Chicken nuggets"));
        arrlist.add(new FoodModel(R.drawable.panini, "Panini grilled sandwich"));
        arrlist.add(new FoodModel(R.drawable.spaghetti, "Chill Sauce spaghetti"));

        // Set Adapter
        FoodAdapter adapter = new FoodAdapter(arrlist, this);
        recyclerView.setAdapter(adapter);
    }
}