package Arvore;

public class Posicao {
    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    public String StringPosicao(){
        return "(" + this.linha + ", " + this.coluna + ")";
    }
}
