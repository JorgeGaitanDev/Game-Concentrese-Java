
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge Gaitan
 */
public class Index {
    
    static String nom;
    
    public Index()
    {
        nom=JOptionPane.showInputDialog("Type Name");
        Tablero2 t = new Tablero2();        
        t.setVisible(true);
       
        
    }
    
}
