package com.example.lois.todo_list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by lois on 31/01/2018.
 */

public class TaskActivity extends Activity {

    DbHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);
        dbHelper = new DbHelper(this);

        final EditText title_add = (EditText) findViewById(R.id.add_title);
        final EditText desc_add = (EditText) findViewById(R.id.add_desc);
        final DatePicker date_add = (DatePicker) findViewById(R.id.add_date);
        final SeekBar prio_add = (SeekBar) findViewById(R.id.add_priority);

        final Button save_task = (Button) findViewById(R.id.save_task);
        save_task.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String title_tmp = String.valueOf(title_add.getText());
                String desc_tmp = String.valueOf(desc_add.getText());
                String date_tmp = String.valueOf(date_add.getDayOfMonth() + "/" + (date_add.getMonth() + 1) + "/" + date_add.getYear());
                String prio_tmp = String.valueOf((prio_add.getProgress() + 1));
                dbHelper.insertNewTask(title_tmp, desc_tmp, prio_tmp, date_tmp);
                finish();
            }
        });
    }
}
