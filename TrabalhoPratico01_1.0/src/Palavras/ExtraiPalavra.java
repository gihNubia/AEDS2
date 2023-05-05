package Palavras;

import Arvore.ArvorePatricia;
import Arvore.Posicao;

import java.io.*;
import java.util.*;

public class ExtraiPalavra {

    public static ArvorePatricia preenchimento(String arq, String delim) throws Exception{
        String palavra = null;
        int i = 1;
        int[] j = new int[2];

        ArvorePatricia ap = new ArvorePatricia();

        try{
            ExtraiPalavra lista_palavras = new ExtraiPalavra(delim, arq);

            while ((palavra = lista_palavras.proximaPalavra())!=null){
                if(lista_palavras.posicoes(i-1) != null){
                    j = lista_palavras.posicoes(i-1);
                }


                System.out.println ("Palavra"+ (i++) +": " + palavra + " ("+ j[0] + " , " + j[1] + ")");

                //adc obj palavra na arvore patricia, criando um obj_palavras
                if (i == 2){
                    ap.insere(palavra.toCharArray(), new Posicao(j[0], j[1]));
                }
                else if(ap.pesquisa(palavra.toCharArray()) == null){
                    ap.insere(palavra.toCharArray(), new Posicao(j[0], j[1]));
                }
                else{
                    ap.pesquisa(palavra.toCharArray()).add(new Posicao(j[0], j[1]));
                }

            }
            lista_palavras.fecharArquivos();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ap;
    }

    private BufferedReader arqDelim, arqTxt;
    private StringTokenizer palavras;
    private String delimitadores;

    private ArrayList retorno;

    private int lin, col;

    private int[] posicoesR;


    public ExtraiPalavra (String nomeArqDelim, String nomeArqTxt)  throws Exception {
        this.arqDelim = new BufferedReader(new FileReader (nomeArqDelim));
        this.arqTxt = new BufferedReader (new FileReader (nomeArqTxt));
        // @{\it Os delimitadores devem estar juntos em uma \'unica linha do arquivo}@
        this.delimitadores = arqDelim.readLine() + "\r\n";
        this.palavras = null;

        //identificar linhas e  colunas
        lin = 0;
        col = 0;

        //arraylist
        retorno = new ArrayList<Integer>();
        posicoesR = new int[2];
    }
    public String proximaPalavra() throws Exception{
        if (palavras == null || !palavras.hasMoreTokens()) {

            String linha = arqTxt.readLine();

            //if (linha == null) return null;
            if (linha == null) return "";
            this.palavras = new StringTokenizer (linha, this.delimitadores);
            lin++;
            col = 0;
            if (!palavras.hasMoreTokens()) return ""; // @{\it ignora delimitadores}@
        }
        col++;
        retorno.add(lin);
        retorno.add(col);
        //System.out.println(lin + " " + col);
        return this.palavras.nextToken ();

    }
    public void fecharArquivos () throws Exception {
        this.arqDelim.close();
        this.arqTxt.close();
    }

    public int[] posicoes(int i){
        posicoesR[0] = (int) retorno.get(2*i);
        posicoesR[1] = (int) retorno.get(2*i + 1);
        return posicoesR;
    }
}
