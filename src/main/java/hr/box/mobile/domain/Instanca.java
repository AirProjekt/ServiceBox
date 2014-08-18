package hr.box.mobile.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="INSTANCA")
public class Instanca implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5542082966544790184L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@NotEmpty(message="Polje ne smije biti prazno!")
	@Column(name="NAME")
	private String name;
	
	@Column(name="TELEFON")
	private String telefon;
	
	@NotEmpty(message="Polje ne smije biti prazno!")
	@Column(name="ADRESA")
	private String adresa;
	
	@NotEmpty(message="Polje ne smije biti prazno!")
	@Column(name="GRAD")
	private String grad;
	
	@Column(name="WEB")
	private String web;
	
	@Column(name="OPIS")
	private String opis;
	
	@NotNull(message="Polje ne smije biti prazno!")
	@Column(name="LATITUDE")
	private double latitude;
	
	@NotNull(message="Polje ne smije biti prazno!")
	@Column(name="LONGITUDE")
	private double longitude;
	
	@ManyToOne
	@JoinColumn(name = "OBJEKT_ID")
	@JsonManagedReference
	private Objekt objekt;
	
	
	public Instanca() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String getGrad() {
		return grad;
	}
	
	public void setGrad(String grad) {
		this.grad = grad;
	}
	
	public String getWeb() {
		return web;
	}
	
	public void setWeb(String web) {
		this.web = web;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Objekt getObjekt() {
		return objekt;
	}

	public void setObjekt(Objekt objekt) {
		this.objekt = objekt;
	}
	
}
