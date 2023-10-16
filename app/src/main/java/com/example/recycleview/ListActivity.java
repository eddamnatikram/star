package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.recycleview.adapter.StarAdapter;
import com.example.recycleview.beans.Star;
import com.example.recycleview.service.StarService;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = "ListActivity"; // Define the TAG variable here

    private List<Star> stars;
    private RecyclerView recyclerView;
    private StarAdapter starAdapter = null;
    private StarService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        stars = new ArrayList<>();
        service = StarService.getInstance();
        init();
        recyclerView = findViewById(R.id.recycle_view);
        starAdapter = new StarAdapter(this, stars);
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Assuming you have imported LinearLayoutManager
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("stars");
    }

    public void init() {
        stars.add(new Star("Saïd Taghmaoui",  "https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Sa%C3%AFd_Taghmaoui_2014.jpg/220px-Sa%C3%AFd_Taghmaoui_2014.jpg", 3.5f));
        stars.add(new Star("Sofia Essaïdi", "https://fr.web.img3.acsta.net/r_1280_720/medias/nmedia/18/85/92/82/19813045.jpg", 3));
        stars.add(new Star("Rachid El Ouali", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2tavAhJdI51-iBROMsD0EIBO3v-FtNUISrgdK1UaOfA&s", 5));
        stars.add(new Star("Houda Rihani", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdlgNMtKja1i_EWrsmAbS9fguuEXc6vb6K2eKR-Zir&s", 1));
        stars.add(new Star("Amal Ayouch", "data:image/jpeg;base64,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", 5));
        stars.add(new Star("Abdellah Ferkous", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRafM8ZP2WY5pP9rXkMiiSWGRFGxBoXeU8ceUZlmo54&s", 1));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (starAdapter != null){
                    starAdapter.getFilter().filter(newText);
                }
                return true;
            }
        });
        return true;
    }

}
