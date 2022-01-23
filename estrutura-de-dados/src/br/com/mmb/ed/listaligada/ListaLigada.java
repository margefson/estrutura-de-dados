package br.com.mmb.ed.listaligada;


//A vantagem da lista ligada � que como a rela��o entre duas c�lulas � feita por refer�ncias, � f�cil inserir um elemento no meio da lista (afinal, basta acertar das c�lulas a esquerda e a direita).
//Inserir no come�o e no fim tamb�m leva tempo constante, afinal geralmente a estrutura possui refer�ncias para o primeiro e �ltimo elemento.
//Desvantagens: Recuperar um elemento em uma posi��o aleat�ria pode levar tempo linear. Afinal, diferente do vetor, onde pegar um elemento qualquer custa uma simples opera��o de array, em uma lista ligada, precisamos navegar pelas refer�ncias at� encontrar o elemento desejado.

//Na lista ligada simples a c�lula s� aponta para a pr�xima c�lula da lista. J� na lista duplamente ligada, a c�lula tem refer�ncias para a anterior e para a pr�xima. A grande vantagem � que muitas opera��es necessitam tamb�m da c�lular anterior, e tudo fica mais f�cil com a refer�ncia armazenada em cada c�lula.
public class ListaLigada {

    private Celula primeira = null;
    private Celula ultima = null;
    private int totalDeElementos = 0;

    //Se a lista est� vazia, criamos uma c�lula e o pr�ximo dela � null. Logicamente o anterior tamb�m. Isto j� hav�amos feito anteriormente.
    //Criamos uma nova c�lula cuja pr�xima � a primeira. E a anterior a esta � a nova. E a primeira � a nova.
    public void adicionaNoComeco(Object elemento) {
        if(this.totalDeElementos == 0) {
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            Celula nova = new Celula(this.primeira, (Celula) elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        this.totalDeElementos++;
    }

    //Muito parecido com o m�todo anteriormente implementado. A �nica diferen�a � que setamos para a c�lula anterior.
	//Criamos uma nova c�lula.
	//A �ltima foi apontou a pr�xima para essa nova c�lula.
	//A nova aponta a anterior para a �ltima atual.
	//A �ltima atual agora � a nova c�lula.
    public void adiciona(Object elemento) {
        if(this.totalDeElementos == 0) {
            adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProximo(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }
    
    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }
    
    private Celula pegaCelula(int posicao) {

        if(!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("posicao inexistente");
        }

        Celula atual = primeira;

        for(int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public void adiciona(int posicao, Object elemento) {

        if(posicao == 0) {
            adicionaNoComeco(elemento);
        } else if (posicao == this.totalDeElementos) {
            this.adiciona(elemento);
        } else {
            Celula anterior = pegaCelula(posicao - 1);
            Celula proxima = anterior.getProximo();

            Celula nova = new Celula(anterior.getProximo(), (Celula) elemento);
            nova.setAnterior(anterior);
            anterior.setProximo(nova);
            proxima.setAnterior(nova);
            this.totalDeElementos++;
        }
    }

    public Object pega(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }

    //Se o elemento (por exemplo, X) est� no meio de uma lista, a remo��o dele � basicamente acertar a refer�ncia proximo do elemento a esquerda e faz�-lo apontar para o pr�ximo de X. Dessa forma, "pulamos" o elemento X e a lista continua certa.
    //A remo��o em uma lista ligada simples (igual a que vimos) leva tempo linear. Afinal, precisamos navegar na lista at� achar o elemento antes e o depois do elemento a ser removido
    public void removeDoComeco() {
        if(this.totalDeElementos == 0) {
            throw new IllegalArgumentException("lista vazia");
        }

        this.primeira = this.primeira.getProximo();
        this.totalDeElementos--;

        if(this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }
    
    public void removeDoFim() {
        if(this.totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProximo(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }

    public void remove(int posicao) {
        if(posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.totalDeElementos - 1) {
            this.removeDoFim();
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula atual = anterior.getProximo();
            Celula proxima = atual.getProximo();

            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);

            this.totalDeElementos--;
        }
    }
    
    public int tamanho() {
        return this.totalDeElementos;
    }

    public boolean contem(Object elemento) {
        Celula atual = this.primeira;

        while(atual != null) {
            if(atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }
    
    @Override
    public String toString () {

        if(this.totalDeElementos == 0) {
            return "[]";
        }

        Celula atual = primeira;

        StringBuilder builder = new StringBuilder("[");

        for(int i = 0; i < totalDeElementos; i++) {
            builder.append(atual.getElemento());
            builder.append(",");

            atual = atual.getProximo();
        }

        builder.append("]");

        return builder.toString();
    }
}
