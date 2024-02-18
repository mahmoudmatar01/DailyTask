package org.example.dailytask.controller

import org.example.dailytask.dto.request.DailyTaskRequestDto
import org.example.dailytask.dto.response.DailyTaskResponseDto
import org.example.dailytask.service.DailyTaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/tasks")
class DailyTaskController (private val dailyTaskService: DailyTaskService) {
    @GetMapping
    fun getAllTasks(): ResponseEntity<List<DailyTaskResponseDto>> =
        ResponseEntity.ok(dailyTaskService.getAllTasks())

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: Long): ResponseEntity<DailyTaskResponseDto> =
        ResponseEntity.ok(dailyTaskService.getTaskById(id))

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveTask(@RequestBody request: DailyTaskRequestDto): ResponseEntity<DailyTaskResponseDto> =
        ResponseEntity.ok(dailyTaskService.saveTask(request))

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody request: DailyTaskRequestDto): ResponseEntity<DailyTaskResponseDto> =
        ResponseEntity.ok(dailyTaskService.updateTask(id, request))

    @DeleteMapping("/{id}")
    fun removeTaskById(@PathVariable id: Long): ResponseEntity<DailyTaskResponseDto> =
        ResponseEntity.ok(dailyTaskService.removeTaskById(id))
}