package br.com.mmb.ed.pilha;

import java.util.LinkedList;
import java.util.List;

//O Java também já possui uma Classe própria para pilhas, cujo nome é Stack
//O conceito de pilhas é muito utilizado por compiladores e autômatos. Esta estrutura de dados tem muita usabilidade em ciência da computação. O próprio, e muito conhecido, comando "Desfazer" dos editores de texto, de código, de imagens, etc tem como base as pilhas. Podemos também brincar com palavras e inverter a ordem de suas letras utilizando as pilhas.
//Pilha é uma estrutura de dados na qual o último elemento a entrar é o primeiro a sair, também conhecida como LIFO(Last-In First-Out), por exemplo, uma pilha de pratos.
public class Pilha {

private List<String> nomes = new LinkedList<String>();

	public void push(String nome) {
	    nomes.add(nome);    
	}

	public String pop() {
	    return nomes.remove(nomes.size()-1);
	}

	public boolean vazia() {
	    return nomes.isEmpty();
	}
    
    @Override
    public String toString() {
        return nomes.toString();
    }
}
