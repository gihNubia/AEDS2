package Palavras;

public class PalavraPos {

    private String palavra;
    private int lin, col;

    public PalavraPos(String palavra, int lin, int col){
        this.palavra = palavra;
        this.lin = lin;
        this.col = col;
    }

    public void Print(){
        System.out.println(palavra + ": " + "(" + lin + ", " + col + ")");
    }

    public String getPalavra() {
        return palavra;
    }

    public int getLin() {
        return lin;
    }

    public int getCol() {
        return col;
    }
}
