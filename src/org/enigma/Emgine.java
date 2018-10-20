package org.enigma;
//Modules

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
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
        Font font1 = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("BaiJamjuree-Light.ttf")).deriveFont(60f);
        Font font2 = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("Khand-Light.ttf")).deriveFont(30f);





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
                BufferedImage Background = ImageIO.read(ClassLoader.getSystemResourceAsStream("wallpapers-black-textures-hd-1024x576.jpg"));

                JLabel Label = new JLabel();
                Label.setIcon(new ImageIcon(Background));
                setContentPane(Label);





                // TODO Backgroundimage

                JTextField inputField = new JTextField(80) {
                    {   //Eingabefeld
                        setSize(500, 50);
                        setLocation(250, 220);
                        setFont(font);
                    }
                };


                ;


                add(inputField);

                add(new JLabel("EMGINE") {
                    {  //Anzeigefeld für Input
                        setSize(600, 100);
                        setLocation(230, 80);
                        setText(" Eingabe...");
                        setFont(font1);
                        setForeground(Color.WHITE);
                    }
                });

                /*   JTextField outputField = (new JTextField(80) {
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
*/
                JButton Button1 = ((new JButton(new AbstractAction("Foobar") {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        String textFieldValue = inputField.getText();
                        System.out.println(textFieldValue);
                        if (textFieldValue.length() == 0) {
                            inputField.setText("");
                        } else {
                            String Encoded = encoderDecoder.encode(textFieldValue);
                            inputField.setText(Encoded);
                        }


                    }
                }) {
                    {   //Button
                        setSize(130, 50);
                        setLocation(777, 150);
                        setText("Encode");
                        setFont(font2);


                    }
                }));
                add(Button1);

                JButton Button2 = ((new JButton(new AbstractAction("Foobar") {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        String textField = inputField.getText();
                        System.out.println(textField);
                        if (textField.length() == 0) {
                            inputField.setText("");
                        } else {
                            String Encoded = encoderDecoder.decode(textField);
                            inputField.setText(Encoded);
                        }


                    }
                }) {
                    {   //Button
                        setSize(130, 50);
                        setLocation(777, 300);
                        setText("Decode");
                        setFont(font2);


                    }
                }));
                add(new JLabel("Passwort?"){

                    {
                        //Feld für Passwort
                        setSize(600, 100);
                        setLocation(250, 280);
                        setFont(font1);
                        setForeground(Color.WHITE);
                    }
                    }


                );
                JTextField Passwort = new JTextField(80) {
                    {   //Eingabefeld Passwort
                        setSize(500, 50);
                        setLocation(250, 400);
                        setFont(font);
                        setText("Passwort");


                    }
                };
                add(Passwort);




                add(Button2);


               // add(new JLabel("Ausgabe") {
                 //   {  //Anzeigefeld für Output
                   //     setSize(110, 50);
                     //   setLocation(250, 230);
                       // setText(" Output");
                        //setFont(Input);
                   // }
                //});

                getRootPane().setDefaultButton(Button1);


            }

            ;

        }.show();
    }
}

