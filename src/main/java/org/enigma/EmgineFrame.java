package org.enigma;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
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
        setSize(1200, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(ImageIO.read(ClassLoader.getSystemResourceAsStream("padlock.png")));
        add(new JPanel() {
            {
                setLayout(new FlowLayout());
                add(new JLabel("Passwort:") {
                    {
                        setFont(font);

                    }
                });
                add(new JPasswordField(30) {
                    {
                        setFont(getFont().deriveFont(30f));
                    }
                });

                add(new JButton("Encode") {
                    {
                        setFont(font1);
                    }
                });
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
                            setPreferredSize(new Dimension(0, 20));
                        }
                    }, BorderLayout.NORTH);
                    add(new JPanel() {
                        {
                            add(new JLabel("Eingabe...") {
                                {
                                    setFont(font);
                                }
                            });
                            add(new JTextField(30) {
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
