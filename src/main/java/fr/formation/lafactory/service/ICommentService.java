package fr.formation.lafactory.service;

import java.util.List;

import fr.formation.lafactory.model.Comment;

public interface ICommentService {

	List<Comment> getAllComments();
	
	void saveComment(Comment comment);
	
	Comment getCommentById(long id);
	
	void deleteCommentById(long id);
}
