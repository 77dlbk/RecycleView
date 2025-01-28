package com.example.recycleview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recycleview.databinding.ActivityMainBinding;
import com.example.recycleview.databinding.ActivityRecycleViewBinding;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {
    private ActivityRecycleViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecycleViewBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FoodCategory foodCategory1 = new FoodCategory("Burgers", R.drawable.ic_burgers);
        FoodCategory foodCategory2 = new FoodCategory("Pizza", R.drawable.ic_pizza);
        FoodCategory foodCategory3 = new FoodCategory("Burgers", R.drawable.ic_chicken);
        ArrayList<FoodCategory> arrayList1 = new ArrayList<>();
        arrayList1.add(foodCategory1);
        arrayList1.add(foodCategory2);
        arrayList1.add(foodCategory3);
        CategoryAdapter adapter = new CategoryAdapter(arrayList1);
        binding.recyclerView1.setAdapter(adapter);
        binding.recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Burgers burgers1 = new Burgers("Salad Burger","$12", R.drawable.img_burger);
        Burgers burgers2 = new Burgers("Chicken Burger", "$15", R.drawable.img_burger);
        Burgers burgers3 = new Burgers("Cheese Burger", "$13", R.drawable.img_burger);
        ArrayList<Burgers> arrayList2 = new ArrayList<>();
        arrayList2.add(burgers1);
        arrayList2.add(burgers2);
        arrayList2.add(burgers3);
        BurgersAdapter burgersAdapter = new BurgersAdapter(arrayList2);
        binding.burgerrv.setAdapter(burgersAdapter);
        binding.burgerrv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));






    }
}