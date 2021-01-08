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
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private long id;
	
	@Column(name = "CATEGORY_LABEL")
	private String label;
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_PARENT_ID")
	private Category parentCategory;
	
	@OneToMany(mappedBy = "parentCategory")
	private List<Category> subcategories;
	
	@OneToMany(mappedBy = "category")
	private List<Origami> origamis;
	
	/**/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Category> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Category> subcategories) {
		this.subcategories = subcategories;
	}

	public List<Origami> getOrigamis() {
		return origamis;
	}

	public void setOrigamis(List<Origami> origamis) {
		this.origamis = origamis;
	}
}
