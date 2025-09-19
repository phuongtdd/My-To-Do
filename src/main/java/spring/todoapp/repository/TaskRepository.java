package spring.todoapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.todoapp.modal.Task;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    Optional<Task> findByTitle(String title);
    Boolean existsByTitle(String title);

}
