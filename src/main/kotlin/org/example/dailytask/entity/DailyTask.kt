package org.example.dailytask.entity
import jakarta.persistence.*
import org.example.dailytask.enums.Priority
import java.time.LocalDateTime

@Entity
@Table(name = "task")
class DailyTask(
    @Column(name = "description", nullable = false, unique = true)
    var description: String,
    @Column(name = "is_task_open", nullable = false)
    var isTaskOpened: Boolean,
    @Enumerated(EnumType.STRING)
    var priority: Priority
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long=0
    @Column(name = "created_on", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
}
