package org.example.dailytask.dto.request
import org.example.dailytask.enums.Priority

data class DailyTaskRequestDto(
    var dailyDescription:String,
    var isTaskOpen:Boolean,
    var taskPriority: Priority
)
