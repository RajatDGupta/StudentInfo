package com.neeraj.studentinfo.prsenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neeraj.studentinfo.R;
import com.neeraj.studentinfo.data.model.Student;

import java.util.ArrayList;

/**
 * Created by neeraj on 10/2/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private ArrayList<Student> arrayList;
    Context context;

    public Adapter(ArrayList<Student> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_get_all_data, parent, false);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_name.setText(String.valueOf(arrayList.get(position).getStudent_name()));
        holder.tv_roll_no.setText(String.valueOf(arrayList.get(position).getStudent_roll_no()));
        holder.tv_percentage.setText(String.valueOf(arrayList.get(position).getStudent_percentage()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    final class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name,tv_roll_no,tv_percentage;

        ViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_roll_no = itemView.findViewById(R.id.tv_roll_no);
            tv_percentage = itemView.findViewById(R.id.tv_percentage);
        }
    }
}
