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

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        Helper_Add_DataBase myClass_DB = new Helper_Add_DataBase(this,1);
        //SQLiteDatabase myDB = myClass_DB.getWritableDatabase(); помогает получить базу данных
    }

}