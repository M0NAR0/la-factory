package fr.formation.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.lafactory.model.Comment;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {

}
