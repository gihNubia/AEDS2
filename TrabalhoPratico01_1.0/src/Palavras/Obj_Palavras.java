package Palavras;

import Arvore.Posicao;

import java.util.ArrayList;

public class Obj_Palavras {
    private ArrayList<Posicao> pos;
    private String  chave;
    private String palavra;

    private int repeticoes; //quantas vezes a palavra se repete no total

    private int[] x = new int[2];

    public Obj_Palavras(String palavra, Posicao pos){
        this.pos = new ArrayList<Posicao>();
        this.palavra = palavra;
        repeticoes = 1;

        this.pos.add(pos);
        chave =  TransformaBits.stringPbits(palavra);
    }

    public Obj_Palavras(String palavra){
        this.pos = new ArrayList<Posicao>();
        this.palavra = palavra;
        repeticoes = 0;

        chave =  TransformaBits.stringPbits(palavra);
    }

    public void addPosicao(Posicao pos){
        this.pos.add(pos);
        repeticoes++;
    }

    public Posicao getPosicao(int i){
        return pos.get(i);
    }

    public String getChave() {
        return chave;
    }

    public String getPalavra() {
        return palavra;
    }
    public int getRepeticoes(){
        return  repeticoes;
    }

}
