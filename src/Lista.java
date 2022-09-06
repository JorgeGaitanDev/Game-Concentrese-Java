
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge Gaitan
 */
public class Lista extends JFrame{
    
    JList lista;
    JScrollPane scrool;
    JLabel tit;
    static DefaultListModel dl;
    FileReader fw;
    BufferedReader br;
    
    public Lista()
    {
        this.setLayout(null);
        this.setBounds(50, 100, 185, 190);
        this.setLocationRelativeTo(null);
        dl = new DefaultListModel();
        tit = new JLabel("Score / Name");
        tit.setLocation(30, 0);
        tit.setSize(250, 20);
        lista = new JList(dl);
        scrool = new JScrollPane(lista);       
        scrool.setBounds(20, 20, 125, 85);
        this.add(tit);
        this.add(scrool);
        this.setVisible(true);
    }
    
}
