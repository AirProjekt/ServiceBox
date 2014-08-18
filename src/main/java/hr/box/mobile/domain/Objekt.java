package hr.box.mobile.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="OBJEKT")
public class Objekt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1255230370407147756L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@NotEmpty(message="Polje ne smije biti prazno!")
	@Column(name = "NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "KATEGORIJA_ID")
	@JsonManagedReference
	@JsonIgnore
	private Kategorija kategorija;
	
	@OneToMany(mappedBy="objekt",fetch=FetchType.LAZY)
	@JsonBackReference
	private Set<Instanca> instance = new HashSet<Instanca>();
	
	@OneToMany(mappedBy="objekt",fetch=FetchType.LAZY)
	@JsonBackReference
	private Set<Ocjene> ocjene = new HashSet<Ocjene>();
	
	public Objekt() {}
	
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

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Set<Instanca> getInstance() {
		return instance;
	}

	public void setInstance(Set<Instanca> instance) {
		this.instance = instance;
	}

	public Set<Ocjene> getOcjene() {
		return ocjene;
	}

	public void setOcjene(Set<Ocjene> ocjene) {
		this.ocjene = ocjene;
	}


}
