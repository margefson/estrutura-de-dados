package br.com.mmb.ed.testes;

import java.util.Stack;

import br.com.mmb.ed.pilha.Pilha;


public class PilhaTeste {

	public static void main(String[] args) {
		
		/*
		 * Pilha pilha = new Pilha();
		 * 
		 * System.out.println(pilha.vazia()); pilha.push("Mauricio");
		 * System.out.println(pilha); System.out.println(pilha.vazia());
		 * 
		 * pilha.push("Guilherme"); System.out.println(pilha);
		 * 
		 * String r1 = pilha.pop(); System.out.println(r1);
		 * 
		 * String r2 = pilha.pop(); System.out.println(r2);
		 * 
		 * System.out.println(pilha);
		 */
		
		Stack<String> stack = new Stack<String>();
		stack.push("Mauricio");
		stack.push("Marcelo");

		System.out.println(stack);
		
		stack.pop();
		System.out.println(stack);
	}

}
