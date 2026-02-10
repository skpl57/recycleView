package com.example.recylerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Produkt> produkty = new ArrayList<>();
    private RecyclerView recyclerView;
    private ZakupyAdapter zakupyAdapter;
    private Button usun;

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
        Button dodaj = findViewById(R.id.dodajBtn);
        EditText nazwaInp = findViewById(R.id.nazwaInput);
        EditText cenaInp = findViewById(R.id.cenaInput);

        produkty.add(new Produkt("masło", 5));
        produkty.add(new Produkt("czekolada", 3));
        produkty.add(new Produkt("mleko", 2));
        produkty.add(new Produkt("jogurt", 7));


        recyclerView = findViewById(R.id.recyclerView);
        zakupyAdapter = new ZakupyAdapter(MainActivity.this, produkty);

        recyclerView.setAdapter(zakupyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        usun = findViewById(R.id.usunBtn);

        usun.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        zakupyAdapter.usunZaznaczone();
                    }
                }
        );

        dodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        produkty.add(new Produkt(nazwaInp.getText().toString(), Integer.parseInt(cenaInp.getText().toString())));
                        nazwaInp.setText("");
                        cenaInp.setText("");

//                        zakupyAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, produkty.get(0).toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }
}