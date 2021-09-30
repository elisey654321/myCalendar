package com.example.mycalendar;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import com.example.mycalendar.classesDataBases.taskList;
import com.example.mycalendar.databinding.FragmentTaskAddBinding;
import com.example.mycalendar.fragmen.StatusFragment;
import com.example.mycalendar.modulesDataBase.Helper_Add_DataBase;

public class fragment_task_add extends Fragment {
    private FragmentTaskAddBinding binding;
    public Helper_Add_DataBase DB_Class;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTaskAddBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB_Class = new Helper_Add_DataBase(binding.getRoot().getContext(),1);
                SQLiteDatabase db = DB_Class.getWritableDatabase();
                DB_Class.createTask(db,new taskList(binding.editTextTextPersonName.getText().toString(),0));

                NavHostFragment.findNavController(fragment_task_add.this)
                        .navigate(R.id.action_fragment_task_add_to_action_taskFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}