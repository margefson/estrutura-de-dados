package br.com.mmb.ed.listasequencial;
import java.util.ArrayList;
import java.util.Arrays;

//Armazenamento Sequencial - Array
public class Vetor {

	private Aluno[] alunos = new Aluno[100];
	private int totalDeAlunos = 0;
	
	/* O Java j� tem uma implementa��o de Vetor, � a classe conhecida por "ArrayList". 
	 * Ela � bem parecida com tudo o que fizemos at� agora e funciona como um 
	 * armazenamento sequencial, possuindo os m�todos implementados aqui.
	 * 
	 * **/
	ArrayList<Aluno> listaDoJava = new ArrayList<Aluno>();
	
	private void garanteEspaco() {
		if(totalDeAlunos == alunos.length) {
			Aluno[] novoArray = new Aluno[alunos.length*2];
			for(int i = 0; i < alunos.length; i++ ) {
				novoArray[i] = alunos[i];
			}
			this.alunos = novoArray;
		}
		
	}
	
	//A inser��o em um vetor ser� r�pida se a estrutura internamente souber o �ndice da primeira 
	//posi��o vazia do array.
	//A inser��o ser� demorada se o algoritmo passar por todos os elementos, desde o primeiro 
	//at� o �ltimo, para encontrar a posi��o vazia. Nesse caso, o algoritmo tem tempo de 
	//execu��o linear (O(n)).
	public void adiciona(Aluno aluno) {
		//O(N)
		/*
		 * for(int i=0; i < alunos.length; i++) { if(alunos[i] == null) { alunos[i] =
		 * aluno; break; } }
		 */
		
		this.garanteEspaco();
		
		//performance melhor, pois n�o precisa varrer o array inteiro
		this.alunos[totalDeAlunos] = aluno;
		totalDeAlunos++;
	}
	
	private boolean posicaoValida(int posicao) {
		return posicao >=0 && posicao <= totalDeAlunos;
	}
	
	public void adiciona(int posicao, Aluno aluno) {
		this.garanteEspaco();
		
		if(!posicaoValida(posicao)) {
			throw new IllegalArgumentException("posi��o inv�lida");
		}
		
		for(int i = totalDeAlunos - 1; i >= posicao; i-=1) {
			alunos[i+1] = alunos[i];
		}
		alunos[posicao] = aluno;
		totalDeAlunos++;
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < totalDeAlunos;
	}
	
	public Aluno pega(int posicao) {
		
		if(!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Poosi��o inv�lida");
		}
		return null;
	}
	
	//Porque a dele��o em um vetor geralmente implica em reorganizar todo o array. Se voc� deletar o elemento 3, de uma lista de 6 elementos, voc� precisar� empurrar o 4, 5 e 6 um espa�o para tr�s. Isso faz com que a dele��o, no pior caso, seja linear (O(n)).
	public void remove (int posicao) {
		for(int i=posicao; i<this.totalDeAlunos - 1; i++) {
			this.alunos[i] = this.alunos[i+1];
		}
		totalDeAlunos--;
		this.alunos[totalDeAlunos] = null;
	}
	
	public boolean contem(Aluno aluno) {
		for(int i=0; i<totalDeAlunos; i++) {
			if(aluno.equals(alunos[i])) {
				return true;
			}
		}
		return false;
	}
	
	public int tamanho() {
		return totalDeAlunos;
	}
	
	public String toString() {
		return Arrays.toString(alunos);
	}
}
