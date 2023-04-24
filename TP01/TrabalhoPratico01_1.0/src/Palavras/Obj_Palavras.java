package Palavras;

public class Obj_Palavras {
    private int linha;
    private int coluna;
    private String chave;
    private String palavra;

    public Obj_Palavras(String palavra, int linha, int coluna){
        palavra = this.palavra;
        linha = this.linha;
        coluna = this.coluna;
        chave =  TransformaBits.stingPbits(palavra);
    }

}
