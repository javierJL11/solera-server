package com.proyectoCitas.proyectoCitas.repository;

import com.proyectoCitas.proyectoCitas.entity.Appointment;
import com.proyectoCitas.proyectoCitas.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from comment where parent_id = :parentId  order by created_date DESC")
    List<Comment> getCommentByParentId(@Param("parentId") Long parentId);
}
