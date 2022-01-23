package br.com.mmb.ed.fila;

import java.util.LinkedList;
import java.util.List;

//estrutura de Filas damos o nome de Queue
public class Fila {

    private List<String> alunos = new LinkedList<String>();
    
    public void adiciona(String aluno) {
        alunos.add(aluno);
    }
    
    //na estrutura de Fila, será sempre o primeiro elemento do array a ser removido
    public String remove() {
        return alunos.remove(0);
    }
    
    public boolean vazia() {
        return alunos.isEmpty();
    }
 
    @Override
    public String toString() {
        return alunos.toString();
    }
}
