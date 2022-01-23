package br.com.mmb.ed.conjunto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Se pensarmos em um conjunto da disciplina de matem�tica, verificamos que uma de suas vantagens � que n�o h� elementos repetidos. Sabemos tamb�m que � poss�vel fazer opera��es com conjuntos, como intersec��o, uni�o e saber quais elementos est�o contidos. A ideia para essa estrutura � essa.
//Para criarmos um conjunto, precisaremos inserir elementos - n�o repetidos, algo que j� vimos com o LinkedList.
//� estrutura de Conjuntos damos o nome de Set e sua implementa��o � o HashSet:
//Conjuntos s�o estruturas de dados que n�o permitem dados repetidos.
//Para garantir que os dados n�o fiquem repetidos, conjuntos fazem uso de fun��es de hash para espalhar bem os dados, e em seguida, varrer o conte�do de maneira eficiente.
public class Conjunto {
	
	private ArrayList<LinkedList<String>> tabela = new ArrayList<LinkedList<String>>();

	//Cria as 26 listas por meio de um Construtor, organizando as palavaras pelo alfabeto
	//Agora temos 26 listas, uma para cada letra do alfabeto.
	public Conjunto() {
        for(int i = 0; i < 26; i++) {
            tabela.add(new LinkedList<String>());
        }
    }
	
	//Dada uma palavra, conseguimos, assim, calcular o lugar em que ela deve ficar por meio de sua primeira letra.
	private int calculaIndiceDaTabela(String palavra) {
	    return palavra.toLowerCase().charAt(0) % 26;
	}
	
	public void adiciona(String palavra) {
	    if(!contem(palavra)) {
	        int indice = calculaIndiceDaTabela(palavra);
	        List<String> lista = tabela.get(indice);
	        lista.add(palavra);
	    }
	}
	
	private boolean contem(String palavra) {
	    int indice = calculaIndiceDaTabela(palavra);
	    return tabela.get(indice).contains(palavra);
	}
	
	public void remove(String palavra) {
	    if(contem(palavra)) {
	        int indice = calculaIndiceDaTabela(palavra);
	        List<String> lista = tabela.get(indice);
	        lista.remove(palavra);
	    }
	}
	
	@Override
	public String toString() {
	    return tabela.toString();
	}


}
