package com.devspace.taskbeats.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devspace.taskbeats.R
import com.devspace.taskbeats.data.model.TaskUiData

class TaskListAdapter : ListAdapter<TaskUiData, TaskListAdapter.TaskViewHolder>(TaskDiffCallback()) {

    private var onClick: ((TaskUiData) -> Unit)? = null

    fun setOnClickListener(onClick: (TaskUiData) -> Unit) {
        this.onClick = onClick
        Log.d("TaskListAdapter", "setOnClickListener set")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = getItem(position)
        holder.bind(task, onClick)
    }

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvCategory = view.findViewById<TextView>(R.id.tv_category_name)
        private val tvTask = view.findViewById<TextView>(R.id.tv_task_name)
        private val checkbox = view.findViewById<CheckBox>(R.id.checkbox_task)
        private val expandIcon = view.findViewById<ImageView>(R.id.expand_icon)

        fun bind(task: TaskUiData, onClick: ((TaskUiData) -> Unit)?) {
            tvCategory.text = task.categoryName
            tvTask.text = task.name
            checkbox.isChecked = task.isCompleted
            expandIcon.rotation = if (task.isExpanded) 90f else 0f
            itemView.setOnClickListener {
                onClick?.invoke(task)
            }
        }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<TaskUiData>() {
        override fun areItemsTheSame(oldItem: TaskUiData, newItem: TaskUiData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TaskUiData, newItem: TaskUiData): Boolean {
            return oldItem == newItem
        }
    }
}