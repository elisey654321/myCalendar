package com.example.mycalendar.fragmen;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.mycalendar.R;
import com.example.mycalendar.classesDataBases.StatusList;
import com.example.mycalendar.databinding.FragmentStatusAddBinding;
import com.example.mycalendar.modulesDataBase.Helper_Add_DataBase;

public class fragment_status_add extends Fragment {
    private FragmentStatusAddBinding binding;
    public Helper_Add_DataBase DB_Class;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStatusAddBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB_Class = new Helper_Add_DataBase(binding.getRoot().getContext(),1);
                SQLiteDatabase db = DB_Class.getWritableDatabase();
                DB_Class.createStatus(db,new StatusList(binding.editTextTextPersonName.getText().toString(),0));

                NavHostFragment.findNavController(fragment_status_add.this)
                        .navigate(R.id.action_fragment_status_add_to_action_statusFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
