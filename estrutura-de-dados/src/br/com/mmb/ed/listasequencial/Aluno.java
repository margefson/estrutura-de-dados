package br.com.mmb.ed.listasequencial;
import java.util.Objects;

public class Aluno {

	private String nome;

	public Aluno(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno outro = (Aluno) obj;
		return outro.getNome().equals(this.nome);
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + "]";
	}

	
	
	
}
