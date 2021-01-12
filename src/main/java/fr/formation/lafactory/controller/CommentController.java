package fr.formation.lafactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.formation.lafactory.service.ICommentService;

@Controller
public class CommentController {

	@Autowired
	private ICommentService commentService;
}
