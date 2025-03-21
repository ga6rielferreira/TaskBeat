package com.devspace.taskbeats.data.model

data class TaskUiData(
    val id: Long,
    val name: String,
    val categoryName: String,
    val isCompleted: Boolean = false,
    var isExpanded: Boolean = false
)