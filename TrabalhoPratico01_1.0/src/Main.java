import Palavras.*;
import Arvore.*;

import java.util.ArrayList;

/*
        *cada palavra possui linha e coluna
        * char 1byte
        * palavra 16 bytes

        *Falta implementar a arvore patricia
 */

public class Main {
/*
    public static ArvorePatricia preenchimento(String arq,String delim) throws Exception{
        String palavra = null;
        int i = 1;
        int[] j = new int[2];

        ArvorePatricia ap = new ArvorePatricia();

        try{
            ExtraiPalavra lista_palavras = new ExtraiPalavra(delim, arq);

            while ((palavra = lista_palavras.proximaPalavra())!=null){
                j = lista_palavras.posicoes(i-1);
                System.out.println ("Palavra"+ (i++) +": " + palavra + " ("+ j[0] + " , " + j[1] + ")");

                //adc obj palavra na arvore patricia, criando um obj_palavras
                if(ap.pesquisa(palavra.toCharArray()) == null){
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
 */
    public static void main(String[]args){
        //variaveis auxiliares
        int linha, coluna;
        String palavra;
        //criar arvores patricia
        ArrayList<ArvorePatricia> ap = new ArrayList<>();
        ArvorePatricia ap1 = new ArvorePatricia();
        ArvorePatricia ap2 = new ArvorePatricia();
        ap.add(ap1);
        ap.add(ap2);

        //nome dos arquivos
        String[] arquivos = {"src/Texto/exemplo1.txt", "src/Texto/exemplo2.txt"};

        //palavras a serem comparadas
        String[][] palavras = { {"trabalho", "computacao", "governo", "educacao", "tecnologia",
                "formacao", "desenvolvimento", "que", "informatica", "em", "crise"}, {"sociedade", "software", "ideia", "pessoa", "Informatica",
                "etica", "muito", "ciencia", "computacao", "que", "area", "moral"} };


       try{
           //criar extrator de palavras
           for(int i = 0; i < 2; i++){
               ExtracaoDePalavras ep = new ExtracaoDePalavras(arquivos[i]);
               ArrayList<PalavraPos> pp = ep.extracao();
               for(int j = 0; j < pp.size(); j++){
                   linha = pp.get(j).getLin();
                   coluna = pp.get(j).getCol();
                   palavra = pp.get(j).getPalavra();

                   //inserir palavras
                   if(j == 0){
                       ap.get(i).insere(palavra.toCharArray(), new Posicao(linha, coluna));
                   }
                   else if(ap.get(i).pesquisa(palavra.toCharArray()) == null){
                       ap.get(i).insere(palavra.toCharArray(), new Posicao(linha, coluna));
                   }
                   else{
                       ap.get(i).pesquisa(palavra.toCharArray()).add(new Posicao(linha, coluna));
                   }
               }

           }

       }
       catch(Exception exception){
           throw new RuntimeException(exception);
       }

        //pesquisa
        for(int i = 0; i<2; i++){
            System.out.printf("=============================%da Arvore=============================", i + 1);
            for(String e : palavras[i]){
                System.out.println("\n" + e + ": ");
                ArrayList<Posicao> pq = ap.get(i).pesquisa(e.toCharArray());
                for(Posicao p : pq){
                    System.out.println(p.StringPosicao());
                }
            }
            System.out.println("====================================================================\n");
        }
    }
}
