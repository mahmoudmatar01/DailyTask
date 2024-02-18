package org.example.dailytask.service

import org.example.dailytask.dto.request.DailyTaskRequestDto
import org.example.dailytask.dto.response.DailyTaskResponseDto

interface DailyTaskService {
    fun getAllTasks() : List<DailyTaskResponseDto>
    fun getTaskById(id:Long) : DailyTaskResponseDto
    fun saveTask(request: DailyTaskRequestDto):DailyTaskResponseDto
    fun updateTask(taskId:Long , request: DailyTaskRequestDto):DailyTaskResponseDto
    fun removeTaskById(taskId:Long):DailyTaskResponseDto

}