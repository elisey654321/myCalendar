package com.example.mycalendar;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.example.mycalendar.modulesDataBase.Helper_Add_DataBase;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.mycalendar.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public Helper_Add_DataBase DB_Class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        DB_Class = new Helper_Add_DataBase(this,1);
        SQLiteDatabase db = DB_Class.getWritableDatabase();
        DB_Class.onUpgrade(db,1,1);
    }

}