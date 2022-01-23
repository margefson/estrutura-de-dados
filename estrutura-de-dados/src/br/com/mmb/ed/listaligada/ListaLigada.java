package br.com.mmb.ed.listaligada;


//A vantagem da lista ligada é que como a relação entre duas células é feita por referências, é fácil inserir um elemento no meio da lista (afinal, basta acertar das células a esquerda e a direita).
//Inserir no começo e no fim também leva tempo constante, afinal geralmente a estrutura possui referências para o primeiro e último elemento.
//Desvantagens: Recuperar um elemento em uma posição aleatória pode levar tempo linear. Afinal, diferente do vetor, onde pegar um elemento qualquer custa uma simples operação de array, em uma lista ligada, precisamos navegar pelas referências até encontrar o elemento desejado.

//Na lista ligada simples a célula só aponta para a próxima célula da lista. Já na lista duplamente ligada, a célula tem referências para a anterior e para a próxima. A grande vantagem é que muitas operações necessitam também da célular anterior, e tudo fica mais fácil com a referência armazenada em cada célula.
public class ListaLigada {

    private Celula primeira = null;
    private Celula ultima = null;
    private int totalDeElementos = 0;

    //Se a lista está vazia, criamos uma célula e o próximo dela é null. Logicamente o anterior também. Isto já havíamos feito anteriormente.
    //Criamos uma nova célula cuja próxima é a primeira. E a anterior a esta é a nova. E a primeira é a nova.
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

    //Muito parecido com o método anteriormente implementado. A única diferença é que setamos para a célula anterior.
	//Criamos uma nova célula.
	//A última foi apontou a próxima para essa nova célula.
	//A nova aponta a anterior para a última atual.
	//A última atual agora é a nova célula.
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

    //Se o elemento (por exemplo, X) está no meio de uma lista, a remoção dele é basicamente acertar a referência proximo do elemento a esquerda e fazê-lo apontar para o próximo de X. Dessa forma, "pulamos" o elemento X e a lista continua certa.
    //A remoção em uma lista ligada simples (igual a que vimos) leva tempo linear. Afinal, precisamos navegar na lista até achar o elemento antes e o depois do elemento a ser removido
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
