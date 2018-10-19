package org.enigma;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Emgine {

    public static void main(final String[] args) throws IOException {
//        final EncoderDecoder encoderDecoder = new FancyDecoderEncoder();
//
//        System.out.println(encoderDecoder.encode("Hello world"));

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
                setIconImage(ImageIO.read(ClassLoader.getSystemResourceAsStream("envelope.png")));

                add(new JButton(new AbstractAction("Foobar") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Hallo");
                    }
                }) {
                    {
                        setSize(80, 70);
                        setLocation(500, 400);
                        setText("Hallo");



                    }
                });

            }
        }.show();
    }
}

