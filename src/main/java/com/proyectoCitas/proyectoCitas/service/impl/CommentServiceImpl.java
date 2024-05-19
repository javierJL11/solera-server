package com.proyectoCitas.proyectoCitas.service.impl;

import com.proyectoCitas.proyectoCitas.entity.Comment;
import com.proyectoCitas.proyectoCitas.entity.Comment;
import com.proyectoCitas.proyectoCitas.entity.Comment;
import com.proyectoCitas.proyectoCitas.exception.ResourceNotFoundException;
import com.proyectoCitas.proyectoCitas.repository.CommentRepository;
import com.proyectoCitas.proyectoCitas.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        Comment saveComment;
        try {
            saveComment = commentRepository.save(comment);
        }catch(Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("error al agregar consultorio");
        }
        return saveComment;
    }

    @Override
    public List<Comment> getAllComments() {
        List<Comment> listComments;
        try {
            listComments = commentRepository.findAll();
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al obtener lista de comentarios");
        }
        return listComments;
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId) .orElseThrow(() ->
                new ResourceNotFoundException(("El comentario no exixte para el id : " + commentId)));
    }

    @Override
    public Comment updateComment(Long commentId, Comment updatedComment) {
        Comment getComment = getCommentById(commentId);
        if(getComment !=null){
            getComment.setId(updatedComment.getId());
            getComment.setComment(updatedComment.getComment());
        }
        Comment saveComment;
        try {
            saveComment = commentRepository.save(getComment);
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al modificar el comentario");
        }
        return saveComment;
    }

    @Override
    public void deleteComment(Long commentId) {
        try {
            commentRepository.deleteById(commentId);
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al eliminar el comentario");
        }
    }
}
