package com.google.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SimpleMenuActivity extends AppCompatActivity {

    List<String> items;
    ListView lstView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_menu);
        lstView = findViewById(R.id.lstsimpleview);
        prepareData();
        prepareListView();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SimpleMenuActivity.this, items.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepareListView() {
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        lstView.setAdapter(arrayAdapter);
    }

    /**
     * fill 'items' list
     */
    public void prepareData() {
        if(items == null) {
            items = new ArrayList<>();
            items.add("Tehran");
            items.add("Mashhad");
            items.add("Shiraz");
            items.add("Ghom");
            items.add("Ahwaz");
            items.add("Isfahan");
            items.add("Tabriz");
            items.add("Sistam");
            items.add("Kerman");
            items.add("Ilam");
            items.add("Semnan");
            items.add("Ardebil");
            items.add("Kermanshah");
            items.add("Hamedan");
            items.add("Boshehr");
            items.add("Kish");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("add Item").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(items != null) {
                    items.add("new Item");
                    arrayAdapter.notifyDataSetChanged();
                }
                return false;
            }
        });
        menu.add("remove Last Item").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(!items.isEmpty()) {
                    items.remove(items.size()-1);
                    arrayAdapter.notifyDataSetChanged();
                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
