package br.com.mmb.ed.listasequencial;
import java.util.ArrayList;
import java.util.Arrays;

//Armazenamento Sequencial - Array
public class Vetor {

	private Aluno[] alunos = new Aluno[100];
	private int totalDeAlunos = 0;
	
	/* O Java já tem uma implementação de Vetor, é a classe conhecida por "ArrayList". 
	 * Ela é bem parecida com tudo o que fizemos até agora e funciona como um 
	 * armazenamento sequencial, possuindo os métodos implementados aqui.
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
	
	//A inserção em um vetor será rápida se a estrutura internamente souber o índice da primeira 
	//posição vazia do array.
	//A inserção será demorada se o algoritmo passar por todos os elementos, desde o primeiro 
	//até o último, para encontrar a posição vazia. Nesse caso, o algoritmo tem tempo de 
	//execução linear (O(n)).
	public void adiciona(Aluno aluno) {
		//O(N)
		/*
		 * for(int i=0; i < alunos.length; i++) { if(alunos[i] == null) { alunos[i] =
		 * aluno; break; } }
		 */
		
		this.garanteEspaco();
		
		//performance melhor, pois não precisa varrer o array inteiro
		this.alunos[totalDeAlunos] = aluno;
		totalDeAlunos++;
	}
	
	private boolean posicaoValida(int posicao) {
		return posicao >=0 && posicao <= totalDeAlunos;
	}
	
	public void adiciona(int posicao, Aluno aluno) {
		this.garanteEspaco();
		
		if(!posicaoValida(posicao)) {
			throw new IllegalArgumentException("posição inválida");
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
			throw new IllegalArgumentException("Poosição inválida");
		}
		return null;
	}
	
	//Porque a deleção em um vetor geralmente implica em reorganizar todo o array. Se você deletar o elemento 3, de uma lista de 6 elementos, você precisará empurrar o 4, 5 e 6 um espaço para trás. Isso faz com que a deleção, no pior caso, seja linear (O(n)).
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
