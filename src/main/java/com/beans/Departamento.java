package com.beans;

import javax.persistence.*;

@Entity
@Table (name="departamento")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name="nome")
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn (name="pes_id")
	Pessoa p = new Pessoa();

	public Pessoa getP() {
		return p;
	}
	public void setP(Pessoa p) {
		this.p = p;
	}
	
	

}
