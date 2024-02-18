package org.example.dailytask.mapper

import org.example.dailytask.dto.request.DailyTaskRequestDto
import org.example.dailytask.entity.DailyTask
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class DailyTaskRequestDtoToDailyTask : Function<DailyTaskRequestDto, DailyTask> {
    override fun apply(dto: DailyTaskRequestDto): DailyTask {
        return DailyTask(
            description = dto.dailyDescription,
            isTaskOpened = dto.isTaskOpen,
            priority = dto.taskPriority
        )
    }
}