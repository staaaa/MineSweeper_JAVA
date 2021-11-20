package MineSweeper;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) throws IOException {
        
        JFrame window = new JFrame("Minesweeper");
        Okno okno = new Okno(100,10,10,10);
        window.add(okno);
        window.setResizable(false);
        
        
        JMenuBar menubar = new JMenuBar();              //menu
        JMenu menu = new JMenu("Nowa gra");
        JMenuItem nowagra = new JMenuItem(new AbstractAction("Rozpocznij now¹ grê"){
        @Override
            public void actionPerformed(ActionEvent e) {
                try{

                }catch(Exception exception){}try{
                    window.getContentPane().removeAll();
                    Okno okno = new Okno(100,10,10,10);
                    window.add(okno);
                    window.setVisible(true);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.pack();
                }catch(Exception exception){}
            }   
            
        });
        
        menu.add(nowagra);
        JMenu menu2 = new JMenu("POZIOMY TRUDNOSCI");
        
        
        
        JMenuItem latwy = new JMenuItem(new AbstractAction("£atwy") {
            @Override
            public void actionPerformed(ActionEvent e) {   
                    
                try{
                    window.getContentPane().removeAll();
                    Okno okno = new Okno(100,10,10,10);
                    window.add(okno);
                    window.setVisible(true);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.pack();
                }catch(Exception exception){}
            }
        });
        JMenuItem sredni = new JMenuItem(new AbstractAction("Œredni") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    window.getContentPane().removeAll();
                    Okno okno = new Okno(195,15,13,40); 
                    window.add(okno);
                    window.setVisible(true);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.pack();
                }catch(Exception exception){}
            }
        });
        JMenuItem trudny = new JMenuItem(new AbstractAction("Trudny") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    window.getContentPane().removeAll();
                    Okno okno = new Okno(480,30,16,99);                  
                    window.add(okno);
                    window.setVisible(true);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.pack();
                }catch(Exception exception){}
            }
        });
   
        menu2.add(latwy);
        menu2.add(sredni);
        menu2.add(trudny);
        
        menubar.add(menu);
        menubar.add(menu2);

        window.setJMenuBar(menubar);

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
    }
}