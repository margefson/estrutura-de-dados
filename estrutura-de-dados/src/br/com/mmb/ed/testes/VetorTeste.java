package br.com.mmb.ed.testes;

import br.com.mmb.ed.listasequencial.Aluno;
import br.com.mmb.ed.listasequencial.Vetor;

public class VetorTeste {

	public static void main(String[] args) {

		Aluno a1 = new Aluno("João");
		Aluno a2 = new Aluno("Maria");
		
		Vetor lista = new Vetor();
		System.out.println(lista.tamanho());
		lista.adiciona(a1);
		lista.adiciona(a2);
		
		System.out.println(lista);
		System.out.println(lista.tamanho());
		
		Aluno a3 = new Aluno("Danilo");
		System.out.println(lista.contem(a3));
		
		for(int i = 0; i < 300; i++) {
		    Aluno y = new Aluno("Joao" + i);
		    lista.adiciona(y);
		}
		System.out.println(lista);
	}

}
