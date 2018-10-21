package org.enigma;

public class FancyDecoderEncoder implements EncoderDecoder {
    @Override
    public String encode(String input) {


        StringBuilder output = new StringBuilder();

        for (int i= 0; i<input.length(); i++) {
                char  original = input.charAt(i);
                char encoded = (char)(original + 2);
                output.append(encoded);
        }

        return output.toString();
        /*
        char c = 'A';
        int i = (int) c;
        int t = i + 23;
        while (i == t) {
            switch (i = +1);
        }
        if(i == t){
        System.out.println("Alles gut gegangen");
        }else if (i != t);
        System.out.println("Fehler der Syntax ");

        char r = 'i';
        char d = (char) r;
        char rr=  (char) d;
        System.out.println("Dies ist ihre Variable:"d)

          return null;*/
    }

    @Override
    public String decode(String input) {

        StringBuilder Stringbuilder2 = new StringBuilder();

        for (int i= 0; i<input.length(); i++) {
            char  original = input.charAt(i);
            char decode = (char)(original - 2);
            Stringbuilder2.append(decode);
        }

        return Stringbuilder2.toString();

        /*
            char c = 'X';
            int i = (int) c;
            int t = i - 23;
            while (i == t) {
                switch (i = -1);
            }
            if(i == t){
                System.out.println("Fehler der Berechnung");
            }else if (i != t);
            System.out.println("Fehler der Syntax ");

            char r = 'i';
            char d = (char) r;
            char rr=  (char) d;*/
            //return null;

        }

}
