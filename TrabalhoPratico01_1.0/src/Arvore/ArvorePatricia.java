package Arvore;

import java.util.ArrayList;

public class ArvorePatricia {
    private static abstract class PatNo {}

    private static class PatNoInt extends PatNo {
        int index;
        PatNo esq, dir;
    }

    // Nos Externos armazenam chave e uma lista com as posicoes
    private static class PatNoExt extends PatNo {
        char[] chave;
        ArrayList<Posicao> posicoes;
        public PatNoExt() {
            this.chave = new char[16];
            this.posicoes = new ArrayList<Posicao>();
        }
    }

    private PatNo raiz;
    private int nbitsChave = 16*8;

    // Retorna o i-esimo bit da string
    public int bit(int i, char[] k) {
        int iChar = i/8;
        int iBit = i%8;
        int c = (int)k[iChar];
        for (int j = 1; j < 8 - iBit; j++)
            c = c/2;
        return c%2;
    }

    private boolean eExterno (PatNo p) {
        Class<?> classe = p.getClass();
        return classe.getName().equals(PatNoExt.class.getName());
    }

    private PatNo criaNoInt(int i, PatNo esq, PatNo dir) {
        PatNoInt p = new PatNoInt();
        p.index = i;
        p.esq = esq;
        p.dir = dir;
        return p;
    }

    private PatNo criaNoExt (char[] k, Posicao pos) {
        PatNoExt p = new PatNoExt();
        p.chave = k;
        p.posicoes.add(pos);
        return p;
    }

    private ArrayList<Posicao> pesquisa (char[] k, PatNo t) {
        if (this.eExterno(t)){
            PatNoExt aux = (PatNoExt) t;
            if (java.util.Arrays.equals(aux.chave, k))
                return aux.posicoes;
            else
                return null;
        }
        else {
            PatNoInt aux = (PatNoInt) t;
            if (this.bit(aux.index, k) == 0)
                return pesquisa(k, aux.esq);
            else
                return pesquisa(k, aux.dir);
        }
    }

    private PatNo insere (char[] k, Posicao pos, PatNo t) {
        if (t == null)
            return this.criaNoExt(k, pos);

        PatNo p = t;
        while (!this.eExterno(p)) {
            PatNoInt aux = (PatNoInt) p;
            if (this.bit(aux.index, k) == 1)
                p = aux.dir;
            else
                p = aux.esq;
        }

        PatNoExt aux = (PatNoExt)p;
        int i = 0;
        while ((i < this.nbitsChave) && (this.bit(i, k) == this.bit(i, aux.chave)))
            i++;

        if (i >= this.nbitsChave) {
            aux.posicoes.add(pos);
            return t;
        }
        else
            return this.insereEntre(k, pos, t, i);
    }

    private PatNo insereEntre (char[] k, Posicao pos, PatNo t, int i) {
        PatNoInt aux = null;
        if (!this.eExterno(t))
            aux = (PatNoInt) t;

        if (this.eExterno(t) || (i < aux.index)) {
            PatNo p = this.criaNoExt(k, pos);
            if (this.bit(i, k) == 1)
                return this.criaNoInt(i, t, p);
            else
                return this.criaNoInt(i, p, t);
        } else {
            if (this.bit(aux.index, k) == 1)
                aux.dir = this.insereEntre(k, pos, aux.dir, i);
            else
                aux.esq = this.insereEntre(k, pos, aux.esq, i);
            return aux;
        }
    }

    // Retorna um vetor de caracteres com 16 posicoes
    // Se palavra fornecida for menor que 16, adiciona espacos em branco
    private char[] padronizaChar(char[] palavra){ //*
        char[] k = new char[16];

        for (int i = 0; i < palavra.length && i < 16; i++)
            k[i] = palavra[i];
        for (int i = palavra.length; i < 16; i++)
            k[i] = 32;

        return k;
    }

    public void insere(char[] palavra, Posicao pos) {
        char[] k = this.padronizaChar(palavra); //**
        this.raiz = this.insere(k, pos, this.raiz);
    }

    public ArrayList<Posicao> pesquisa(char[] palavra){
        char[] k = this.padronizaChar(palavra); //**
        return this.pesquisa(k, this.raiz);
    }

}
