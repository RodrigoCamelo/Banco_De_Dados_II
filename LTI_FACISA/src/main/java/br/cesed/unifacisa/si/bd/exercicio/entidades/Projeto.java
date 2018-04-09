package br.cesed.unifacisa.si.bd.exercicio.entidades;

import java.util.ArrayList;
import java.util.Date;

public class Projeto {
	
	private Long id;
	private ArrayList<Aluno> alunos;
	private ArrayList<Tecnologia> tecnologias;
	private Professor responsavel;
	private Date inicio;
	private Date conclusao;
	private String areaRelacionada;
	private String titulo;
	private String descricao;
	
	public Projeto(ArrayList<Aluno> alunos, ArrayList<Tecnologia> tecnologias, Professor responsavel,
			Date inicio, Date conclusao, String areaRelacionada, String titulo, String descricao) {
		super();
		this.alunos = alunos;
		this.tecnologias = tecnologias;
		this.responsavel = responsavel;
		this.inicio = inicio;
		this.conclusao = conclusao;
		this.areaRelacionada = areaRelacionada;
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	public Projeto() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	public ArrayList<Tecnologia> getTecnologias() {
		return tecnologias;
	}
	public void setTecnologia(ArrayList<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}
	public Professor getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Professor responsavel) {
		this.responsavel = responsavel;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getConclusao() {
		return conclusao;
	}
	public void setConclusao(Date conclusao) {
		this.conclusao = conclusao;
	}
	public String getAreaRelacionada() {
		return areaRelacionada;
	}
	public void setAreaRelacionada(String areaRelacionada) {
		this.areaRelacionada = areaRelacionada;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
