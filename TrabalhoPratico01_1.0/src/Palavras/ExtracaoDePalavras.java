package Palavras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ExtracaoDePalavras {
    private BufferedReader arqTxt;
    private ArrayList<PalavraPos> palavraPos;
    private int lin, col;

    public ExtracaoDePalavras (String nomeArqTxt)  throws Exception {
        this.arqTxt = new BufferedReader (new FileReader(nomeArqTxt));

        //identificar linhas e  colunas
        lin = 0;
        col = 0;

        //arraylist
        palavraPos = new ArrayList<PalavraPos>();
    }

    public ArrayList<PalavraPos> extracao() throws Exception{
        lin = 1;
        while(true){
            String st = arqTxt.readLine();
            String[] palavras;
            if(st == null){
                break;
            }
            if(!(st.equals("\n")||st.equals(""))){
                palavras = st.split(("[, . ! ?()\n \n\r]+"));
                col = 0;
                for(String s : palavras){
                    if(!s.equals("")){
                        col++;
                        palavraPos.add(new PalavraPos(s, lin, col));
                    }

                }
                col = 0;
            }

            lin++;

        }
        this.fecharArquivos();
        return palavraPos;
    }
    public void fecharArquivos () throws Exception {
        this.arqTxt.close();
    }
}
