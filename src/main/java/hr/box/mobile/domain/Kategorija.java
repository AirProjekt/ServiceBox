package hr.box.mobile.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="KATEGORIJA")
public class Kategorija implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6546289198476775069L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@NotEmpty(message="Polje ne smije biti prazno!")
	@Column(name = "NAME")
	private String name;
	
	@OneToMany(mappedBy="kategorija",fetch=FetchType.LAZY)
	@JsonBackReference
	private Set<Objekt> objekti = new HashSet<Objekt>();
	
	public Kategorija() {}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Objekt> getObjekti() {
		return objekti;
	}

	public void setObjekti(Set<Objekt> objekti) {
		this.objekti = objekti;
	}
	
	
}
