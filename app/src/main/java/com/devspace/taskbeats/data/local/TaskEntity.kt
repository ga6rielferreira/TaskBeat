package com.devspace.taskbeats.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

/**
 * Entidade que representa uma tarefa no banco de dados.
 * As tarefas são associadas a uma categoria e podem ter subtarefas.
 */
@Entity(
    tableName = "task_entity",
    foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = ["id"],
        childColumns = ["categoryId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class TaskEntity(
    /**
     * Identificador único da tarefa, gerado automaticamente.
     */
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    /**
     * Identificador da categoria à qual a tarefa pertence.
     */
    val categoryId: Long,

    /**
     * Nome ou título da tarefa.
     */
    val name: String,

    /**
     * Descrição opcional da tarefa.
     */
    val description: String? = null,

    /**
     * Indica se a tarefa foi concluída.
     */
    val isCompleted: Boolean = false
)