package com.example.recylerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Produkt> produkty;
    private RecyclerView recyclerView;
    private ZakupyAdapter zakupyAdapter;

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

        produkty.add(new Produkt("masło", 5));
        produkty.add(new Produkt("czekolada", 3));
        produkty.add(new Produkt("mleko", 2));
        produkty.add(new Produkt("jogurt", 7));
        produkty.add(new Produkt("w pysk", 1));

        recyclerView = findViewById(R.id.recyclerView);
        zakupyAdapter = new ZakupyAdapter(MainActivity.this, produkty);

        recyclerView.setAdapter(zakupyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}