package com.example.mycalendar.classesDataBases.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mycalendar.R;
import com.example.mycalendar.classesDataBases.StatusList;

import java.util.List;

public class Status_Adapter extends RecyclerView.Adapter<Status_Adapter.ViewHolder> {

    private final LayoutInflater inflater;
    private List<StatusList> statusList;

    public Status_Adapter(Context context, List<StatusList> statusList){
        this.statusList = statusList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.task_layout, parent, false);
        return new Status_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position == 0){
            holder.info_text.setText("Name");
            holder.text_id.setText("Id");
        }else {
            StatusList status = statusList.get(position);
            holder.info_text.setText(status.Name);
            holder.text_id.setText(Integer.toString(status.id));
        }
    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final TextView info_text,text_id;
        public ViewHolder(View view) {
            super(view);
            info_text = (TextView)view.findViewById(R.id.info_text);
            text_id = (TextView)view.findViewById(R.id.text_id);
        }
    }
}
