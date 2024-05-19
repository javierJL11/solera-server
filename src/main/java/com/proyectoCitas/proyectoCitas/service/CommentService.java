package com.proyectoCitas.proyectoCitas.service;

import com.proyectoCitas.proyectoCitas.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    List<Comment> getAllComments ();
    Comment getCommentById (Long commentId);
    Comment updateComment (Long commentId, Comment updatedComment);
    void deleteComment (Long commentId);
}
