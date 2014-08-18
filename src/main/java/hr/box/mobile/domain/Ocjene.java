package hr.box.mobile.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="OCJENE")
public class Ocjene implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2724521893167717875L;
	
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="comment")
	private String comment;
	
	@Temporal(TemporalType.DATE)
	@Column(name="datum")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "objekt_id")
	@JsonManagedReference
	private Objekt objekt;
	
	public Ocjene() {
		
	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public Objekt getObjekt() {
		return objekt;
	}

	public void setObjekt(Objekt objekt) {
		this.objekt = objekt;
	}
	
	

}
