package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.TASK_ID
import java.text.SimpleDateFormat
import java.util.Locale

class DetailTaskActivity : AppCompatActivity() {

    private lateinit var detailTaskViewModel: DetailTaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action

        val factory = ViewModelFactory.getInstance(this)
        val id = intent.getIntExtra(TASK_ID, -1)
        detailTaskViewModel = ViewModelProvider(this, factory)[DetailTaskViewModel::class.java]

        detailTaskViewModel.setTaskId(id)
        detailTaskViewModel.task.observe(
            this
        ) { task ->
            // Show detail task
            if (task != null) {
                val title = task.title
                val description = task.description
                val edTitleTextView = findViewById<TextView>(R.id.detail_ed_title)
                val edDescriptionTextView = findViewById<TextView>(R.id.detail_ed_description)
                val edDueDate = findViewById<TextView>(R.id.detail_ed_due_date)

                edTitleTextView.text = title
                edDescriptionTextView.text = description
                edDueDate.text =
                    SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(task.dueDateMillis)
            }
        }

        val btn = findViewById<Button>(R.id.btn_delete_task)
        btn.setOnClickListener {
            detailTaskViewModel.deleteTask()
        }
    }
}