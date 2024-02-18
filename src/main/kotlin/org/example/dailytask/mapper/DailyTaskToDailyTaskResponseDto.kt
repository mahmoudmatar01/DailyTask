package org.example.dailytask.mapper

import org.example.dailytask.dto.response.DailyTaskResponseDto
import org.example.dailytask.entity.DailyTask
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class DailyTaskToDailyTaskResponseDto:Function<DailyTask,DailyTaskResponseDto> {
    override fun apply(t: DailyTask): DailyTaskResponseDto {
        return DailyTaskResponseDto(
            taskId = t.id,
            description = t.description,
            isTaskOpen = t.isTaskOpened,
            createdOn = t.createdAt,
            taskPriority = t.priority
        )
    }
}