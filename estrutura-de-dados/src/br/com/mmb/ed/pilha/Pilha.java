package br.com.mmb.ed.pilha;

import java.util.LinkedList;
import java.util.List;

//O Java tamb�m j� possui uma Classe pr�pria para pilhas, cujo nome � Stack
//O conceito de pilhas � muito utilizado por compiladores e aut�matos. Esta estrutura de dados tem muita usabilidade em ci�ncia da computa��o. O pr�prio, e muito conhecido, comando "Desfazer" dos editores de texto, de c�digo, de imagens, etc tem como base as pilhas. Podemos tamb�m brincar com palavras e inverter a ordem de suas letras utilizando as pilhas.
//Pilha � uma estrutura de dados na qual o �ltimo elemento a entrar � o primeiro a sair, tamb�m conhecida como LIFO(Last-In First-Out), por exemplo, uma pilha de pratos.
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
