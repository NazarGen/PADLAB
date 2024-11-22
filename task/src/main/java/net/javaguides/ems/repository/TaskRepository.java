package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {

}
