package com.example.lois.todo_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lois on 31/01/2018.
 */

public class Manager  extends ArrayAdapter<Task> {

    public Manager(Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        TaskViewHolder viewHolder = (TaskViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TaskViewHolder();
            viewHolder.task_id = (TextView) convertView.findViewById(R.id.task_id);
            viewHolder.task_title = (TextView) convertView.findViewById(R.id.task_title);
            viewHolder.task_date = (TextView) convertView.findViewById(R.id.task_date);
            viewHolder.task_desc = (TextView) convertView.findViewById(R.id.task_desc);
            viewHolder.task_prio = (TextView) convertView.findViewById(R.id.task_prio);
            convertView.setTag(viewHolder);
        }

        Task task = getItem(position);

        viewHolder.task_id.setText(Integer.toString((task.get_id())));
        viewHolder.task_title.setText(task.get_name());
        viewHolder.task_date.setText(task.get_date());
        viewHolder.task_desc.setText(task.get_desc());
        viewHolder.task_prio.setText(task.get_prio());

        return convertView;
    }

    private class TaskViewHolder{
        public TextView task_id;
        public TextView task_title;
        public TextView task_date;
        public TextView task_desc;
        public TextView task_prio;
    }
}
