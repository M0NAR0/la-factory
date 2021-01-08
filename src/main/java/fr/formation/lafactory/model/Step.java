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
@Table(name = "step")
public class Step {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STEP_ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "STEP_ORIGAMI_ID")
	private Origami origami;
	
	@Column(name = "STEP_LABEL")
	private String label;
	
	@Column(name = "STEP_ORDER")
	private int order;
	
	/**/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Origami getOrigami() {
		return origami;
	}

	public void setOrigami(Origami origami) {
		this.origami = origami;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
