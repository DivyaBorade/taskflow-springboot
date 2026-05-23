package taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskflow.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
