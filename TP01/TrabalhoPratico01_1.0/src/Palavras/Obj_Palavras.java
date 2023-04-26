package Palavras;

import java.util.ArrayList;

public class Obj_Palavras {
    private ArrayList<Integer> linha;
    private ArrayList<Integer> coluna;
    private String  chave;
    private String palavra;

    private int repeticoes; //quantas vezes a palavra se repete no total

    private int[] x = new int[2];

    public Obj_Palavras(String palavra, int linha, int coluna){
        this.linha = new ArrayList<Integer>();
        this.coluna = new ArrayList<Integer>();
        this.palavra = palavra;
        repeticoes = 1;

        this.linha.add((Integer) linha);
        this.coluna.add(coluna);
        chave =  TransformaBits.stringPbits(palavra);
    }

    public Obj_Palavras(String palavra){
        this.linha = new ArrayList<Integer>();
        this.coluna = new ArrayList<Integer>();
        this.palavra = palavra;
        repeticoes = 0;

        chave =  TransformaBits.stringPbits(palavra);
    }

    public void addPosicao(int i, int j){
        linha.add(i);
        coluna.add(j);
        repeticoes++;
    }

    public int[] getPosicao(int i){
        x[0] = linha.get(i);
        x[1] = coluna.get(i);
        return x;
    }

    public ArrayList<Integer> getLinha() {
        return linha;
    }

    public ArrayList<Integer> getColuna() {
        return coluna;
    }

    public int getLinhaPos(int i){
        return linha.get(i);
    }

    public int getColunaPos(int i){
        return coluna.get(i);
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
