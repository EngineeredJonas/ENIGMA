package org.enigma;
//Modules
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Emgine {

    public static void main(final String[] args) throws IOException {
//        final EncoderDecoder encoderDecoder = new FancyDecoderEncoder();
//
//        System.out.println(encoderDecoder.encode("Hello world"));
        //Fonts
        Font CENA = new Font("SansSerif", Font.BOLD, 30);
        Font Input = new Font("toll", Font.BOLD, 30);
        Font Button = new Font("Butt", Font.BOLD, 25);
        //File font_file = new File("ChakraPetch-Light.ttf");
        //Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
        //TODO ChakraPetch. ttf verwenden



        new JFrame() {
            {
                setTitle("Emgine");
                setFont(Font.getFont(Font.SANS_SERIF));
                setSize(1000, 500);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setBackground(Color.cyan);
                getContentPane().setBackground(Color.CYAN);
                setLayout(null);
                setIconImage(ImageIO.read(ClassLoader.getSystemResourceAsStream("padlock.png")));

                // TODO Backgroundimage

                add(new JButton(new AbstractAction("Foobar") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("button funktioniert");


                    }
                }) {
                    {   //Button
                        setSize(130, 50);
                        setLocation(777, 150);
                        setText("Encode");
                        setFont(Button);



                    }
                });


                //TODO TextFeld variable !
                add(new JTextField(80) {
                        {   //Eingabefeld
                            setSize(500, 50);
                            setLocation(250, 150);
                            setFont(CENA);
                            //Nur Buchstaben und Nummern
                            //String text = "axc";
                            //boolean match = text.matches("[a-zA-Z0-9]+");






                        }
                    });

                add(new JTextField(80) {
                    {  //Anzeigefeld für Input
                       setSize(100, 50);
                       setLocation(250,80);
                       setEditable(false);
                       setText(" Input");
                       setFont(Input);
                    }
                });


            };
        }.show();
    }
}

