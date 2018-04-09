package br.cesed.unifacisa.si.bd.exercicio.entidades;

public class Tecnologia {
	
	private Long id;
	private String nome;
	private String descricao;
	private String arearelacionada;
	private String documentacao;
	
	public Tecnologia(String nome, String descricao, String arearelacionada, String documentacao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.arearelacionada = arearelacionada;
		this.documentacao = documentacao;
	}

	public Tecnologia() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getArearelacionada() {
		return arearelacionada;
	}
	public void setArearelacionada(String arearelacionada) {
		this.arearelacionada = arearelacionada;
	}
	public String getDocumentacao() {
		return documentacao;
	}
	public void setDocumentacao(String documentacao) {
		this.documentacao = documentacao;
	}
}
