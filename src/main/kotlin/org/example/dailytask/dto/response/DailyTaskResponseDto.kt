package org.example.dailytask.dto.response

import org.example.dailytask.enums.Priority
import java.time.LocalDateTime

data class DailyTaskResponseDto(
    var taskId:Long,
    var description:String,
    var isTaskOpen:Boolean,
    var createdOn:LocalDateTime,
    var taskPriority:Priority
)
