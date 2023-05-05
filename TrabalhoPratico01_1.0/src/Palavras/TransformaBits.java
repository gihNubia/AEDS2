package Palavras;

public  class TransformaBits {

    private static String i;

    private static String j;

    private static int aux;
    public static String charPbits(char c){
        i = new String();
        i = Integer.toBinaryString(c);

        return i;
    }

    public static String stringPbits(String s){
        i = new String();

        for(int j = 0; j < s.length(); j++){
            i = String.join("",i, charPbits(s.charAt(j)));
        }
        if(i.length() < 16*8){
            j = new String();
            aux = i.length();
            while(aux != 16*8){
                j = String.join("",j, "0");
                aux++;
            }
            i = String.join("",j, i);
        }
        return i;
    }
}
