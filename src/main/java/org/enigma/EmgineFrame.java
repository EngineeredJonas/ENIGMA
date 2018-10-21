package org.enigma;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EmgineFrame extends JFrame {


    public EmgineFrame() throws IOException, FontFormatException {

        //Fonts
        Font CENA = new Font("SansSerif", Font.BOLD, 30);
        Font Input = new Font("toll", Font.BOLD, 30);
        Font Button = new Font("Butt", Font.BOLD, 25);
        Font font = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("ChakraPetch-Light.ttf")).deriveFont(30f);
        Font font1 = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("BaiJamjuree-Light.ttf")).deriveFont(30f);
        Font font2 = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("Khand-Light.ttf")).deriveFont(30f);


        setTitle("Emgine");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(ImageIO.read(ClassLoader.getSystemResourceAsStream("padlock.png")));
        //BufferedImage Background = ImageIO.read(ClassLoader.getSystemResourceAsStream("wallpapers-black-textures-hd-1024x576.jpg"));
        //JLabel Label = new JLabel();
        //Label.setIcon(new ImageIcon(Background));
        //setContentPane(Label);

        add(new JPanel() {
            {
                setLayout(new FlowLayout());
                add(new JLabel("Passwort:") {
                    {
                        setFont(font);

                    }
                });
                JPasswordField passfield = new JPasswordField(30) {
                    {
                        setFont(getFont().deriveFont(30f));
                    }
                };
                add(passfield);


                JButton Button1 = new JButton(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent ea) {
                        //String valueA = Textfield.getText();
                        //String valueB = passfield.getText();
                        //if (valueA.length() == 0) {


                        }



                    }
                })
                 {
                    {
                        setFont(font1);


                    }
                };
                add(Button1);

                add(new JButton("Decode") {
                    {
                        setFont(font1);
                    }
                });
            }
        }, BorderLayout.NORTH);

        add(new JTabbedPane() {
            {
                addTab("Text", new JPanel() {{
                    setLayout(new BorderLayout());
                    add(new JPanel() {
                        {
                            setPreferredSize(new Dimension(0, 50));
                        }
                    }, BorderLayout.NORTH);
                    add(new JPanel() {
                        {    JTextField Textfield = new JTextField(30) {
                            {
                                setFont(font);

                            }

                        };
                            add(Textfield);
                            add(new JLabel("Eingabe...") {
                                {
                                    setFont(font);
                                }
                            });

                        }
                    });

                }});
                addTab("Datei", new JPanel() {{
                    add(new JButton(new AbstractAction("Datei auswählen") {

                        @Override
                        public void actionPerformed(final ActionEvent e) {

                        }

                    }));
                }});
            }
        }, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(final String[] args) throws IOException, FontFormatException {
        new EmgineFrame();
    }

}
