package org.example.dailytask.repository

import org.example.dailytask.entity.DailyTask
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DailyTaskRepository:JpaRepository<DailyTask,Long>