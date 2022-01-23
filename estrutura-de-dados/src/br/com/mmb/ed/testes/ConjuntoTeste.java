package br.com.mmb.ed.testes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import br.com.mmb.ed.conjunto.Conjunto;

public class ConjuntoTeste {

	public static void main(String[] args) {

		LinkedList<String> conjuntoOld = new LinkedList<String>();
		
		//O problema � que essa condi��o estar� dentro de um m�todo "adiciona". Toda vez que chamarmos um add, chamaremos um contains. O tempo de execu��o desse algoritmo � muito lento, pois o contains varre todo o array e a opera��o de adi��o, que antes ocorria em tempo constante, agora ter� tempo linear.
		if(!conjuntoOld.contains("Mauricio")) {
			conjuntoOld.add("Mauricio");
	    }
		
		Conjunto conjunto = new Conjunto();
        conjunto.adiciona("Mauricio");
        System.out.println(conjunto);

        conjunto.adiciona("Mauricio");
        System.out.println(conjunto);
        
        conjunto.remove("Mauricio");
        System.out.println(conjunto);
        
        Set<String> conjuntoDoJava = new HashSet<String>();

        conjuntoDoJava.add("Mauricio");
        String x = "Guilherme";
        x.hashCode();

	}

}
