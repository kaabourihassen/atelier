package iset.example.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Compte {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;
	private double solde;
	private Date dateC;
	
	@OneToMany(mappedBy="compte")
	@JsonIgnore
	private List <Operation> operation;

	public Compte(double solde, Date dateC) {
		super();
		this.solde = solde;
		this.dateC = dateC;
	}

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

	public long getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateC() {
		return dateC;
	}

	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}
	
	
}

