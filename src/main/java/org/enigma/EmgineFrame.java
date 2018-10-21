package org.enigma;

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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

public class EmgineFrame extends JFrame {

    public EmgineFrame() {
        setTitle("Emgine");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new JPanel() {
            {
                setLayout(new FlowLayout());
                add(new JLabel("Passwort:"));
                add(new JPasswordField(30));
                add(new JButton("Encode"));
                add(new JButton("Decode"));
            }
        }, BorderLayout.NORTH);
        add(new JTabbedPane() {
            {
                addTab("Text", new JPanel() {{
                    add(new JLabel("Text"));
                    add(new JTextField(30));
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

    public static void main(final String[] args) {
        new EmgineFrame();
    }

}
