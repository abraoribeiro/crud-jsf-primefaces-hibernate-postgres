package com.beans;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name="nome")
	private String nome;
	@Column (name="idade")
	private int idade;
	@Column (name="dep")
	private int departamento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getDepartamento() {
		return departamento;
	}
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	
	@OneToMany (mappedBy = "pessoa", cascade = CascadeType.ALL )
	List<Departamento> departamentos = new ArrayList<Departamento>();

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
}
