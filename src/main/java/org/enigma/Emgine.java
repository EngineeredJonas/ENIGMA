package org.enigma;
//Modules

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.GeneralSecurityException;

public class Emgine {
//private Image backgroundImage;
    public static void main(final String[] args) throws Exception {
        final EncoderDecoder encoderDecoder = new AESEncoderDecoder();
        //backgroundImage = ImageIO.read(new File());

//        System.out.println(encoderDecoder.encode("Hello world"));
        //Fonts
        Font CENA = new Font("SansSerif", Font.BOLD, 30);
        Font Input = new Font("toll", Font.BOLD, 30);
        Font Button = new Font("Butt", Font.BOLD, 25);
        Font font = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("ChakraPetch-Light.ttf")).deriveFont(30f);
        Font font1 = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("BaiJamjuree-Light.ttf")).deriveFont(60f);
        Font font2 = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("Khand-Light.ttf")).deriveFont(30f);






       /*JTabbedPane Pane = new JTabbedPane();
       Pane.setSize(500, 500);
       Pane.setBackground(Color.BLACK);
       Pane.addTab("LOL", );
       Pane.setTitleAt(null, "Title");
*/





        new JFrame() {
            {
                setTitle("Emgine");
                setFont(Font.getFont(Font.SANS_SERIF));
                setSize(1000, 500);
                setMinimumSize(new Dimension(1000, 500));
                setLocationRelativeTo(null);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                //setBackground(Color.cyan);
                //getContentPane().setBackground(Color.CYAN);
                setLayout(null);
                setIconImage(ImageIO.read(ClassLoader.getSystemResourceAsStream("padlock.png")));
                setResizable(false);


                BufferedImage Background = ImageIO.read(ClassLoader.getSystemResourceAsStream("wallpapers-black-textures-hd-1024x576.jpg"));
                JLabel Label = new JLabel();
                Label.setIcon(new ImageIcon(Background));
                setContentPane(Label);

               /* BufferedImage Bild = ImageIO.read(ClassLoader.getSystemResourceAsStream("Frame 4.png"));
                JLabel Label2 = new JLabel();
                Label2.setIcon(new ImageIcon(Bild));
                setContentPane(Label2);
                setLocation(40, 50);
               */












                JLabel Hallo = (new JLabel("Nötig für Verschlüsselung"){

                    {
                        setForeground(Color.WHITE);
                        setSize(600,100);
                        setLocation(250, 350);
                        setFont(font);

                    }
                }
                );
                add(Hallo);
                JPasswordField Passwort = new JPasswordField(80) {
                    {   //Eingabefeld Passwort
                        setSize(500, 50);
                        setLocation(250, 300);
                        setFont(font);
                        setText("");


                    }
                };


                JButton Button4 = new JButton(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        String passvalue = Passwort.getText();
                        if (passvalue.length() == 0){
                            Hallo.setText("Passwort vergessen!");
                            Hallo.setForeground(Color.red);
                            return ;
                        }
                        JFileChooser Chooser = new JFileChooser();
                        Chooser.setDialogTitle("Datei auswählen");

                        int state = Chooser.showOpenDialog(null);
                        if ( state == JFileChooser.APPROVE_OPTION )

                        {
                            File file = Chooser.getSelectedFile();
                            try {

                                String result =   encoderDecoder.decode(file);
                                Desktop.getDesktop().open(new File(result).getParentFile());
                            } catch (Exception e)
                            { Hallo.setText("Erfolgreich entschlüsselt!");
                                Hallo.setForeground(Color.WHITE);
                                throw new RuntimeException(e);

                            }

                        }

                    }

                });
                Button4.setFont(font2);
                Button4.setSize(200, 40);
                Button4.setText("Datei decrypt...");
                Button4.setLocation(560,230 );
                add(Button4);

                JButton Button3 = new JButton(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                       String passvalue = Passwort.getText();
                       if (passvalue.length() == 0){
                           Hallo.setText("Passwort vergessen!");
                           Hallo.setForeground(Color.red);
                           return ;
                       }
                       encoderDecoder.passwort(passvalue);
                        JFileChooser Chooser = new JFileChooser();
                        Chooser.setDialogTitle("Datei auswählen");

                        int state = Chooser.showOpenDialog(null);
                        if ( state == JFileChooser.APPROVE_OPTION )

                        {
                            File file = Chooser.getSelectedFile();
                            try {

                             String result =   encoderDecoder.encode(file);
                             Desktop.getDesktop().open(new File(result).getParentFile());
                            } catch (Exception e)
                            { Hallo.setText("Erfolgreich verschlüsselt!");
                            Hallo.setForeground(Color.WHITE);
                                throw new RuntimeException(e);

                            }

                        }

                    }

                });
                Button3.setFont(font2);
                Button3.setSize(200, 40);
                Button3.setText("Datei encrypt...");
                Button3.setLocation(560,50 );
                add(Button3);


                JTextField inputField = new JTextField(80) {
                    {   //Eingabefeld
                        setSize(500, 50);
                        setLocation(250, 120);
                        setFont(font);
                    }
                };


                ;


                add(inputField);

                add(new JLabel("EMGINE") {
                    {  //Anzeigefeld für Input
                        setSize(600, 100);
                        setLocation(230, 10);
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


                add(new JFileChooser()
                    {

                        {


                        }
                    }

                );
                JButton Button1 = new JButton(new AbstractAction("Foobar") {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        String textFieldValue = inputField.getText();
                        String passwortfieldvalue = Passwort.getText();
                        System.out.println(textFieldValue);
                        if (textFieldValue.length() == 0) {
                            inputField.setText("");

                            Hallo.setText("Eingabe vergessen!");
                            Hallo.setForeground(Color.RED);
                        } else if (
                                passwortfieldvalue.length() == 0) {
                            Hallo.setText("Passwort vergessen!");
                            Hallo.setForeground(Color.RED);
                        } else {
                            encoderDecoder.passwort(passwortfieldvalue);
                            try {
                                String Encoded = encoderDecoder.encode(textFieldValue);
                                inputField.setText(Encoded);
                                Hallo.setText("Erfolgreich verschlüsselt!");
                                Hallo.setForeground(Color.WHITE);
                            } catch (Exception e) {
                                Hallo.setText("Fehler!");
                                Hallo.setForeground(Color.RED);
                            }
                        }
                    }
                })
                {

                    {   //Button
                        setSize(130, 50);
                        setLocation(777, 120);
                        setText("Encode");
                        setFont(font2);


                    }
                };

                add(Button1);

                JButton Button2 = new JButton(new AbstractAction("Foobar") {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        String textFieldValue = inputField.getText();
                        String passwortfieldvalue = Passwort.getText();
                        System.out.println(textFieldValue);
                        if (textFieldValue.length() == 0) {
                            inputField.setText("");
                            Hallo.setText("Eingabe vergessen!");

                        } else if (
                                passwortfieldvalue.length() == 0) {
                            Hallo.setText("Passwort vergessen!");
                            Hallo.setForeground(Color.RED);
                        } else
                            {

                            encoderDecoder.passwort(passwortfieldvalue);
                                try {
                                    String Encoded = encoderDecoder.decode(textFieldValue);
                                    inputField.setText(Encoded);
                                    Hallo.setText("Erfolgreich entschlüsselt!");
                                    Hallo.setForeground(Color.WHITE);
                                } catch (Exception e) {
                                    Hallo.setText("Etwas hat nicht geklappt :/");
                                    Hallo.setForeground(Color.RED);
                                }
                        }
                    }
                })
                {
                    {   //Button
                        setSize(130, 50);
                        setLocation(777, 300);
                        setText("Decode");
                        setFont(font2);


                    }
                };
                add(new JLabel("Passwort?"){

                    {
                        //Feld für Passwort
                        setSize(600, 100);
                        setLocation(250, 200);
                        setFont(font1);
                        setForeground(Color.WHITE);
                    }
                    }


                );

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

