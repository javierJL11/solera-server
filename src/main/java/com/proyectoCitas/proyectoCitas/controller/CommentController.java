package com.proyectoCitas.proyectoCitas.controller;

import com.proyectoCitas.proyectoCitas.entity.Comment;
import com.proyectoCitas.proyectoCitas.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(path="/api/comment", method = RequestMethod.POST)
    public ResponseEntity<Comment> createComment (@RequestBody Comment comment){
        Comment saveComment =  commentService.createComment(comment);
        return new ResponseEntity<>(saveComment, HttpStatus.CREATED);
    }

    @RequestMapping (path="/api/comment/{id}", method = RequestMethod.GET)
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Long commentId){
        Comment comment =  commentService.getCommentById(commentId);
        return ResponseEntity.ok(comment);
    }

    @RequestMapping (path="/api/comment", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> getAllComments(){
        List<Comment> comments =  commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @RequestMapping (path="/api/comment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Comment> updateComment( @PathVariable("id") Long commentId,@RequestBody Comment updatedComment){
        Comment comment= commentService.updateComment(commentId,updatedComment);
        return ResponseEntity.ok(comment);
    }

    @RequestMapping (path="/api/comment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteComment (@PathVariable("id") Long commentId){
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comentario eliminado exitosamente!");

    }

}
