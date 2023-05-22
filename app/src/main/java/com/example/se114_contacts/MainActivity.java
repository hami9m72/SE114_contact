package com.example.se114_contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFood;
    private PhoneAdapter phoneAdapter;
    private List<phone> phoneList;
    private PhoneDB db = new PhoneDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        int id = i.getIntExtra("ID",0);
        String n = i.getStringExtra("name");
        String p = i.getStringExtra("phone");
        if (id==3) {
            db.insertData(n, p);
        }
        recyclerViewFood = findViewById(R.id.recyclerviewSearchFood);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerViewFood.getContext());
        recyclerViewFood.setLayoutManager(linearLayoutManager);
        db.insertData("Mi","0923928383");
        db.insertData("Anh","0999123123");
        db.insertData("Nguyen Tran Linh","0722123123");
        db.insertData("Linh","0666343434");
        db.insertData("Nguyen Van B","0888123123");
        db.insertData("Kim Anh","0988343434");

        phoneList = new ArrayList<>(db.getData());
        phoneAdapter = new PhoneAdapter(phoneList);
        recyclerViewFood.setAdapter(phoneAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(recyclerViewFood.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewFood.addItemDecoration(itemDecoration);
    }
    private void getListFoodsACS() {

        Collections.sort(phoneList, new Comparator<phone>() {
            @Override
            public int compare(phone o1, phone o2) {
                return o1.name.compareToIgnoreCase(o2.name);
            }
        });
        Collections.reverse(phoneList);
        phoneAdapter = new PhoneAdapter(phoneList);
        recyclerViewFood.setAdapter(phoneAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(recyclerViewFood.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewFood.addItemDecoration(itemDecoration);
    }
    private void getListFoodsDESC() {

        Collections.sort(phoneList, new Comparator<phone>() {
            @Override
            public int compare(phone o1, phone o2) {
                return o1.name.compareToIgnoreCase(o2.name);
            }
        });

        phoneAdapter = new PhoneAdapter(phoneList);
        recyclerViewFood.setAdapter(phoneAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(recyclerViewFood.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewFood.addItemDecoration(itemDecoration);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.AddNew: {
                Intent i = new Intent(this, AddNewActivity.class);
                startActivity(i);
                break;
            }
            case R.id.ASC: {
                getListFoodsACS();
                break;
            }
            case R.id.DESC: {
                getListFoodsDESC();
                break;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}