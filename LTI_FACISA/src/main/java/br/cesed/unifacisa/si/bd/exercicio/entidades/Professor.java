package br.cesed.unifacisa.si.bd.exercicio.entidades;

public class Professor {

	private String nome;
	private Long id;
	private int matricula;
	private boolean emProjeto;
	
	public Professor(String nome, int matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public Professor() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public boolean isEmProjeto() {
		return emProjeto;
	}
	public void setEmProjeto(boolean emProjeto) {
		this.emProjeto = emProjeto;
	}
}
