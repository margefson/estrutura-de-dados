package br.com.mmb.ed.testes;

import java.util.LinkedList;
import java.util.Queue;

import br.com.mmb.ed.fila.Fila;

public class FilaTeste {

	public static void main(String[] args) {
		
		Fila fila = new Fila();
		
		fila.adiciona("Mauricio");
		fila.adiciona("Guilherme");

		System.out.println(fila);
		
		String x1 = fila.remove();
		System.out.println(x1);
		System.out.println(fila);
		
		Queue<String> filaDoJava = new LinkedList<String>();

		filaDoJava.add("Mauricio");
		String x2 = filaDoJava.poll();
		System.out.println(x2);
	}

}
