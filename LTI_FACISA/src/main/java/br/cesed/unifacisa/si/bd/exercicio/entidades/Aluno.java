package br.cesed.unifacisa.si.bd.exercicio.entidades;

public class Aluno {
	
	private String nome;
	private Long id;
	private String matricula;
	private int Periodo;
	
	
	public Aluno(String nome, String matricula, int periodo) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		Periodo = periodo;
	}
	
	public Aluno() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getPeriodo() {
		return Periodo;
	}
	public void setPeriodo(int periodo) {
		Periodo = periodo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}