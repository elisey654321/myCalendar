package com.example.mycalendar.classesDataBases.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mycalendar.R;
import com.example.mycalendar.classesDataBases.taskList;

import java.util.List;

public class Task_Adapter extends RecyclerView.Adapter<Task_Adapter.ViewHolder> {

    private final LayoutInflater inflater;
    private List<taskList> taskList;

    public Task_Adapter(Context context,List<taskList> taskList) {
        this.taskList = taskList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        taskList taskListNew = taskList.get(position);
        holder.info_text.setText(taskListNew.Name);
        holder.text_id.setText(Integer.toString(taskListNew.id));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView info_text,text_id;
        public ViewHolder(View view) {
            super(view);
            info_text = (TextView)view.findViewById(R.id.info_text);
            text_id = (TextView)view.findViewById(R.id.text_id);
        }
    }
}
