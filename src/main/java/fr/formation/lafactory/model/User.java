package fr.formation.lafactory.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long id;
	
	@Column(name = "USER_USERNAME", length = 50, nullable = false)
	private String username;
	
	@Column(name = "USER_PASSWORD", length = 300, nullable = false)
	private String password;
	
	@Column(name = "USER_ADMIN", nullable = false)
	private boolean admin;
	
	@Column(name = "USER_ACTIVATED", nullable = false)
	private boolean activated;
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(
		name = "user_role",
		joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")},
		inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")}
	)
	private List<Role> roles;
	
	@OneToMany(mappedBy = "origami")
	private List<Comment> comments;
	
	/**/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
