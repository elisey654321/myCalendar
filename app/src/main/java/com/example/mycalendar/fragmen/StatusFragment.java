package com.example.mycalendar.fragmen;

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
import com.example.mycalendar.classesDataBases.StatusList;
import com.example.mycalendar.classesDataBases.adapter.Status_Adapter;
import com.example.mycalendar.classesDataBases.adapter.Task_Adapter;
import com.example.mycalendar.classesDataBases.taskList;
import com.example.mycalendar.databinding.FragmenTaskBinding;
import com.example.mycalendar.databinding.FragmentStatusBinding;
import com.example.mycalendar.modulesDataBase.Helper_Add_DataBase;

import java.util.ArrayList;
import java.util.List;

public class StatusFragment extends Fragment {
    private FragmentStatusBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentStatusBinding.inflate(inflater, container, false);

        List<StatusList> mList = new ArrayList<>();
        fillStatusList(mList);

        RecyclerView mRecyclerView = binding.recyclerView;

        // Установите true, если ваш RecyclerView ограничен и имеет фиксированный размер
        mRecyclerView.setHasFixedSize(false);

        // Установите требуемый LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(inflater.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Инициализирование и установка адаптера в RecyclerView
        Status_Adapter mAdapter = new Status_Adapter(inflater.getContext(), mList);
        mRecyclerView.setAdapter(mAdapter);

        return binding.getRoot();
    }

    private void fillStatusList(List<StatusList> mList) {
        Helper_Add_DataBase DB_Helper = new Helper_Add_DataBase(binding.getRoot().getContext(),1);
        SQLiteDatabase db = DB_Helper.getWritableDatabase();
        mList = DB_Helper.getStatusList(db,mList);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StatusFragment.this)
                        .navigate(R.id.action_statusFragment_to_fragment_main);
            }
        });

        binding.addStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StatusFragment.this)
                        .navigate(R.id.action_action_statusFragment_to_fragment_status_add);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
