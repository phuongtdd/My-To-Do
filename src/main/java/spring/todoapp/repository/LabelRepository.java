package spring.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.todoapp.modal.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, String> {

}
