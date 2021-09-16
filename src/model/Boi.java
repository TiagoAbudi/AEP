package model;

public class Boi {
	
	private int id;
	private String nome;
	private int idade;
	private String nomeUltimaVacina;
	private String dataUltimaVacina;
	private float peso;
	
	public Boi(int id, String nome, int idade, String nomeUltimaVacina, String dataUltimaVacina, float peso) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.nomeUltimaVacina = nomeUltimaVacina;
		this.dataUltimaVacina = dataUltimaVacina;
		this.peso = peso;
	}
	
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
	
	public String getNomeUltimaVacina() {
		return nomeUltimaVacina;
	}
	
	public void setNomeUltimaVacina(String nomeUltimaVacina) {
		this.nomeUltimaVacina = nomeUltimaVacina;
	}
	
	public String getDataUltimaVacina() {
		return dataUltimaVacina;
	}
	
	public void setDataUltimaVacina(String dataUltimaVacina) {
		this.dataUltimaVacina = dataUltimaVacina;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}

}
