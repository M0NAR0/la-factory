package fr.formation.lafactory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMMENT_ID")
	private long id;
	
	@Column(name = "COMMENT_CONTENT")
	private String content;
	
	@Column(name = "COMMENT_NOTE")
	private int note;
	
	@ManyToOne
	@JoinColumn(name = "COMMENT_ORIGAMI_ID")
	private Origami origami;
	
	@ManyToOne
	@JoinColumn(name = "COMMENT_USER_ID")
	private User user;
	
	/**/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Origami getOrigami() {
		return origami;
	}

	public void setOrigami(Origami origami) {
		this.origami = origami;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
