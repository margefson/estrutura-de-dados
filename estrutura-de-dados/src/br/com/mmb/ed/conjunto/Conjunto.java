package br.com.mmb.ed.conjunto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Se pensarmos em um conjunto da disciplina de matemática, verificamos que uma de suas vantagens é que não há elementos repetidos. Sabemos também que é possível fazer operações com conjuntos, como intersecção, união e saber quais elementos estão contidos. A ideia para essa estrutura é essa.
//Para criarmos um conjunto, precisaremos inserir elementos - não repetidos, algo que já vimos com o LinkedList.
//À estrutura de Conjuntos damos o nome de Set e sua implementação é o HashSet:
//Conjuntos são estruturas de dados que não permitem dados repetidos.
//Para garantir que os dados não fiquem repetidos, conjuntos fazem uso de funções de hash para espalhar bem os dados, e em seguida, varrer o conteúdo de maneira eficiente.
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
