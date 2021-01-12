package fr.formation.lafactory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.lafactory.dao.ICommentRepository;
import fr.formation.lafactory.model.Comment;

@Service
public class CommentService implements ICommentService {

	@Autowired
	private ICommentRepository commentRepository;
	
	@Override
	public List<Comment> getAllComments() {
		return commentRepository.findAll();
	}
	
	@Override
	public void saveComment(Comment comment) {
		this.commentRepository.save(comment);
	}
	
	@Override
	public Comment getCommentById(long id) {
		Optional<Comment> optional = commentRepository.findById(id);
		Comment comment = new Comment();
		if (optional.isPresent()) {
			comment = optional.get();
		}
		else {
			throw new RuntimeException("Comment not found for id :: " + id);
		}
		
		return comment;
	}
	
	@Override
	public void deleteCommentById(long id) {
		this.commentRepository.deleteById(id);
	}
}
