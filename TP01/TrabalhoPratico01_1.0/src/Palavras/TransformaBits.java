package Palavras;

public  class TransformaBits {

    private static String i;
    public static String charPbits(char c){
        i = new String();
        i = Integer.toBinaryString(c);

        return i;
    }

    public static String stingPbits(String s){
        i = new String();

        for(int j = 0; j < s.length() ; j++){
            i = String.join("",i, charPbits(s.charAt(j)));
        }
        return i;
    }
}
