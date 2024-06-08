package com.proyectoCitas.proyectoCitas.repository;

import com.proyectoCitas.proyectoCitas.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from task where DATE(created_date) BETWEEN to_date(:firstDate,'YYYY-MM-DD') and  to_date(:lastDate,'YYYY-MM-DD')  order by created_date")
    List<Task> getTasksByWeek(@Param("firstDate") String firstDate, @Param("lastDate") String lastDate);
}
