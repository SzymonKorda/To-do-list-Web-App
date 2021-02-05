package com.example.demo.repositories;

import com.example.demo.model.Task;
import com.example.demo.payload.response.TaskResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long taskId);
//    Optional<List<TaskResponse>> getAllByUserId(Long userId);
}
