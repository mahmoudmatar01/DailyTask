package org.example.dailytask

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DailyTaskApplication

fun main(args: Array<String>) {
    runApplication<DailyTaskApplication>(*args)
}
