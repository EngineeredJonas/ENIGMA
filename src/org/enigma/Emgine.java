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
//private Image backgroundImage;
    public static void main(final String[] args) throws IOException, FontFormatException {
        final EncoderDecoder encoderDecoder = new FancyDecoderEncoder();
        //backgroundImage = ImageIO.read(new File());

//        System.out.println(encoderDecoder.encode("Hello world"));
        //Fonts
        Font CENA = new Font("SansSerif", Font.BOLD, 30);
        Font Input = new Font("toll", Font.BOLD, 30);
        Font Button = new Font("Butt", Font.BOLD, 25);
        Font font = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("ChakraPetch-Light.ttf")).deriveFont(30f);

        //TODO ChakraPetch. ttf verwenden


        new JFrame() {
            {
                setTitle("Emgine");
                setFont(Font.getFont(Font.SANS_SERIF));
                setSize(1000, 500);
                setMinimumSize(new Dimension(1000, 500));
                setLocationRelativeTo(null);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setBackground(Color.cyan);
                getContentPane().setBackground(Color.CYAN);
                setLayout(null);
                setIconImage(ImageIO.read(ClassLoader.getSystemResourceAsStream("padlock.png")));
                setResizable(false);

                // TODO Backgroundimage

                JTextField inputField = new JTextField(80) {
                    {   //Eingabefeld
                        setSize(500, 50);
                        setLocation(250, 150);
                        setFont(font);
                    }
                };


                ;


                add(inputField);

                add(new JLabel("Eingabe") {
                    {  //Anzeigefeld für Input
                        setSize(100, 50);
                        setLocation(250, 80);
                        setText(" Input");
                        setFont(Input);
                    }
                });

                JTextField outputField = (new JTextField(80) {
                    {
                        //Outputfeld
                        setSize(500, 50);
                        setLocation(250, 300);
                        setFont(font);
                        setTitle("Output");
                        setEditable(false);
                    }
                });
                add(outputField);

                JButton Button1 = ((new JButton(new AbstractAction("Foobar") {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        String textFieldValue = inputField.getText();
                        System.out.println(textFieldValue);
                        if (textFieldValue.length() == 0) {
                            outputField.setText("");
                        } else {
                            String Encoded = encoderDecoder.encode(textFieldValue);
                            outputField.setText(Encoded);
                        }


                    }
                }) {
                    {   //Button
                        setSize(130, 50);
                        setLocation(777, 150);
                        setText("Encode");
                        setFont(Button);


                    }
                }));
                add(Button1);


                add(new JLabel("Ausgabe") {
                    {  //Anzeigefeld für Output
                        setSize(110, 50);
                        setLocation(250, 230);
                        setText(" Output");
                        setFont(Input);
                    }
                });

                getRootPane().setDefaultButton(Button1);


            }

            ;

        }.show();
    }
}

