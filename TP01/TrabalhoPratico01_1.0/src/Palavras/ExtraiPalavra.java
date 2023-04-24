package Palavras;

import java.io.*;
import java.util.*;

public class ExtraiPalavra {
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

            if (linha == null) return null;
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
