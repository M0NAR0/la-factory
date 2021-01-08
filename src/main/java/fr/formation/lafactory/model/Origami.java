package fr.formation.lafactory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "origami")
public class Origami {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORIGAMI_ID")
	private long id;
	
	@Column(name = "ORIGAMI_NAME")
	private String name;
	
	@Column(name = "ORIGAMI_CODE")
	private String code;
	
	@Column(name = "ORIGAMI_PREP_TIME")
	private int prepTime;
	
	@Column(name = "ORIGAMI_DIFFICULTY")
	private String difficulty;
	
	@Column(name = "ORIGAMI_PAPER_SHEETS")
	private int paperSheets;
	
	@OneToMany(mappedBy = "origami")
	private List<Step> steps;
	
	@Column(name = "ORIGAMI_AVERAGE_NOTE")
	private int averageNote;
	
	@Column(name = "ORIGAMI_IS_ACTIVATED")
	private boolean activated;
	
	@ManyToOne
	@JoinColumn(name = "ORIGAMI_CATEGORY_ID")
	private Category category;
	
	/**/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public int getPaperSheets() {
		return paperSheets;
	}

	public void setPaperSheets(int paperSheets) {
		this.paperSheets = paperSheets;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public int getAverageNote() {
		return averageNote;
	}

	public void setAverageNote(int averageNote) {
		this.averageNote = averageNote;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
