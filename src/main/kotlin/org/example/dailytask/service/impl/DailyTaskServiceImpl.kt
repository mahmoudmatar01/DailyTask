package org.example.dailytask.service.impl

import lombok.RequiredArgsConstructor
import org.example.dailytask.dto.request.DailyTaskRequestDto
import org.example.dailytask.dto.response.DailyTaskResponseDto
import org.example.dailytask.entity.DailyTask
import org.example.dailytask.mapper.DailyTaskRequestDtoToDailyTask
import org.example.dailytask.mapper.DailyTaskToDailyTaskResponseDto
import org.example.dailytask.repository.DailyTaskRepository
import org.example.dailytask.service.DailyTaskService
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class DailyTaskServiceImpl(
    private val repository: DailyTaskRepository,
    private val toResponseDto: DailyTaskToDailyTaskResponseDto,
    private val toTaskEntity: DailyTaskRequestDtoToDailyTask
):DailyTaskService{

    override fun getAllTasks(): List<DailyTaskResponseDto> {
        val tasks: List<DailyTask> = repository.findAll()
        return tasks.map(toResponseDto::apply)
    }

    override fun getTaskById(id:Long): DailyTaskResponseDto {
        val task:DailyTask=repository.findById(id).orElseThrow{ RuntimeException("Task with ID $id not found") }
        return toResponseDto.apply(task)
    }

    override fun saveTask(request: DailyTaskRequestDto): DailyTaskResponseDto {
        var newTask:DailyTask=toTaskEntity.apply(request)
        newTask=repository.save(newTask)
        return toResponseDto.apply(newTask)
    }

    override fun updateTask(taskId: Long, request: DailyTaskRequestDto): DailyTaskResponseDto {
        try {
            var task:DailyTask=repository.findById(taskId).orElseThrow{ RuntimeException("Task with ID $taskId not found") }
            task.apply {
                description = request.dailyDescription
                isTaskOpened = request.isTaskOpen
                priority = request.taskPriority
            }
            task= repository.save(task)
            return toResponseDto.apply(task)
        }catch (e:Exception){
             throw RuntimeException("Something Invalid!")
        }
    }

    override fun removeTaskById(taskId: Long): DailyTaskResponseDto {
        val task:DailyTask=repository.findById(taskId).orElseThrow{ RuntimeException("Task with ID $taskId not found") }
        repository.delete(task)
        return toResponseDto.apply(task)
    }
}