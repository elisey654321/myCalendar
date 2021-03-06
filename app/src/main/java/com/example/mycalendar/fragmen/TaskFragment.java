package com.example.mycalendar.fragmen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mycalendar.R;
import com.example.mycalendar.classesDataBases.adapter.Task_Adapter;
import com.example.mycalendar.classesDataBases.taskList;
import com.example.mycalendar.databinding.FragmenTaskBinding;
import com.example.mycalendar.modulesDataBase.Helper_Add_DataBase;

import java.util.ArrayList;
import java.util.List;

public class TaskFragment extends Fragment {
    private FragmenTaskBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmenTaskBinding.inflate(inflater, container, false);

        List<taskList> mList = new ArrayList<>();
        fillTaskList(mList);

        RecyclerView mRecyclerView = binding.recyclerView;

        // Установите true, если ваш RecyclerView ограничен и имеет фиксированный размер
        mRecyclerView.setHasFixedSize(false);

        // Установите требуемый LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(inflater.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Инициализирование и установка адаптера в RecyclerView
        Task_Adapter mAdapter = new Task_Adapter(inflater.getContext(), mList);
        mRecyclerView.setAdapter(mAdapter);
        
        return binding.getRoot();       
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TaskFragment.this)
                        .navigate(R.id.action_taskFragment_to_fragment_main);
            }
        });

        binding.buttonAddNewElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TaskFragment.this)
                        .navigate(R.id.action_action_taskFragment_to_fragment_task_add);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void fillTaskList(List<taskList> task_list){
        Helper_Add_DataBase DB_Helper = new Helper_Add_DataBase(binding.getRoot().getContext(),1);
        SQLiteDatabase db = DB_Helper.getWritableDatabase();
        task_list = DB_Helper.getTaskList(db,task_list);
    }

}
