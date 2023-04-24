package Main;

import Palavras.*;
import Arvore.*;

import java.util.Scanner;

/*
        *cada palavra possui linha e coluna
        * char 1byte
        * palavra 16 bytes

        *Falta implementar a arvore patricia
 */

public class Main {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        Obj_Palavras o_procurado;
        String p_procurada;

        System.out.println("Digite a palavra a ser procurada: ");
        p_procurada = sc.next();
        o_procurado = new Obj_Palavras(p_procurada, 0, 0);



        //testar o extrai palavras
        try{
            ExtraiPalavra lista_palavras = new ExtraiPalavra("src/Arquivos/delim.txt", "src/Arquivos/teste.txt");

            String palavra = null;
            int i = 1;
            int[] j = new int[2];

            while ((palavra = lista_palavras.proximaPalavra())!=null){
                j = lista_palavras.posicoes(i-1);
                //System.out.println ("Palavra"+ (i++) +": " + palavra);
                System.out.println ("Palavra"+ (i++) +": " + palavra + " ("+ j[0] + " , " + j[1] + ")");

                //adc obj palavra na arvore patricia, criando um obj_palavras


            }
            lista_palavras.fecharArquivos();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(TransformaBits.charPbits('b'));
        System.out.println(TransformaBits.charPbits('a'));

        System.out.println(TransformaBits.stingPbits("batata"));
        System.out.println(TransformaBits.stingPbits("b"));

        System.out.println("ok");


        //testar a arvore patricia

        //testar a identificacao de palavras (localização)
    }
}
