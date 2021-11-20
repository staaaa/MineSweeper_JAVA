package MineSweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class pola{
    
    public int numer_w_tabeli;               //zmienne pola
    public int koord_x;
    public int koord_y;
    
    public int kx;
    public int ky;
    
    public int czy_odkryte;
    public int rodzaj_pola;
    
    public boolean czy_oflagowane;
    public int ilosc_flag;
    
    public boolean klik;
    
    public static boolean przegrana;
    public static boolean wygrana;
    public static int iloscBomb;
    public static int iloscPol;
    
    public JButton pole;
    
    public pola(int x, int y, int i, int czy, int rodzaj, int uu, int ee){              //konstruktor pola
        
        koord_x = x;
        koord_y = y;
        kx = uu;
        ky = ee;
        numer_w_tabeli = i;
        czy_odkryte = czy;
        rodzaj_pola = rodzaj;
        pole = new JButton();
        
        przegrana = false;
        wygrana = false;
        
        czy_oflagowane = false;
        
        try{
            BufferedImage imgFLAGA = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\pole oflagowane.png"));
            ImageIcon iconFLAGA = new ImageIcon(imgFLAGA);
            
            BufferedImage img = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\pole odkryte.png"));
            ImageIcon icon = new ImageIcon(img);
            
            BufferedImage img2 = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\pole.png"));
            ImageIcon icon2 = new ImageIcon(img2);
            
            BufferedImage img3 = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\pole z bomb¹.png"));
            ImageIcon icon3 = new ImageIcon(img3);
            
            BufferedImage img4 = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\1.png"));
            ImageIcon icon4 = new ImageIcon(img4);
            
            BufferedImage img5 = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\2.png"));
            ImageIcon icon5 = new ImageIcon(img5);
            
            BufferedImage img6 = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\3.png"));
            ImageIcon icon6 = new ImageIcon(img6);
            
            BufferedImage img7 = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\4.png"));
            ImageIcon icon7 = new ImageIcon(img7);
            
            BufferedImage img8 = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\5.png"));
            ImageIcon icon8 = new ImageIcon(img8);
            
            BufferedImage img9 = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\6.png"));
            ImageIcon icon9 = new ImageIcon(img9);
            
            BufferedImage img10 = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\7.png"));
            ImageIcon icon10 = new ImageIcon(img10);
            
            BufferedImage img11 = ImageIO.read(new File("D:\\SAPER\\grafika\\30x30\\8.png"));
            ImageIcon icon11 = new ImageIcon(img11);
            
            if(czy_odkryte == 0)
            {
                pole.setIcon(icon);
            }
            else if(czy_odkryte == 1)
            {
                pole.setIcon(icon2);
            }
            
            pole.setBounds(x,y,30,30);
            
            pole.addMouseListener(new MouseAdapter(){
                @Override
            public void mouseReleased(MouseEvent event){
                    if(event.getButton()==MouseEvent.BUTTON1 && przegrana == false && wygrana == false)
                    {
                        if(czy_oflagowane == true)
                        {
                            
                        }
                        else
                        {
                            if(rodzaj_pola == -1 && czy_odkryte == 0)
                            {
                                pole.setIcon(icon3);
                                czy_odkryte = 1;
                                przegrana = true;
                                JFrame window = new JFrame();
                                JOptionPane.showMessageDialog(window,"PRZEGRA£EŒ.");
                            }
                            else if(rodzaj_pola == 0 && czy_odkryte == 0)
                            {
                                pole.setIcon(icon2);
                                czy_odkryte = 1;
//                                Okno.odkryjObok(kx,ky);
                            }
                            else if(rodzaj_pola == 1 && czy_odkryte == 0)
                            {
                                pole.setIcon(icon4);
                                czy_odkryte = 1;
                            }
                            else if(rodzaj_pola == 2 && czy_odkryte == 0)
                            {
                                pole.setIcon(icon5);
                                czy_odkryte = 1;
                            }
                            else if(rodzaj_pola == 3 && czy_odkryte == 0)
                            {
                                pole.setIcon(icon6);
                                czy_odkryte = 1;
                            }
                            else if(rodzaj_pola == 4 && czy_odkryte == 0)
                            {
                                pole.setIcon(icon7);
                                czy_odkryte = 1;
                            }
                            else if(rodzaj_pola == 5 && czy_odkryte == 0)
                            {
                                pole.setIcon(icon8);
                                czy_odkryte = 1;
                            }
                            else if(rodzaj_pola == 6 && czy_odkryte == 0)
                            {
                                pole.setIcon(icon9);
                                czy_odkryte = 1;
                            }
                            else if(rodzaj_pola == 7 && czy_odkryte == 0)
                            {
                                pole.setIcon(icon10);
                                czy_odkryte = 1;
                            }
                            else if(rodzaj_pola == 8 && czy_odkryte == 0)
                            {
                                pole.setIcon(icon11);
                                czy_odkryte = 1;
                            }
                        }
                        klik = false;
                    }
                    else if(event.getButton()==MouseEvent.BUTTON3 && przegrana == false && wygrana == false)
                    {
                        if(czy_oflagowane == false && Okno.ilosc_flag > 0 && czy_odkryte == 0)
                        {
                            czy_oflagowane = true;
                            pole.setIcon(iconFLAGA);
                            Okno.ilosc_flag--;
                        }
                        else if(czy_oflagowane == true)
                        {
                            czy_oflagowane = false;
                            pole.setIcon(icon);
                            Okno.ilosc_flag++;
                        }
                        if(rodzaj_pola == -1){
                            Okno.liczbaOflagowanychBomb++;
                        }
                        if(Okno.liczbaOflagowanychBomb == Okno.iloscBomb)
                            {
                                wygrana = true;
                                JFrame window = new JFrame();
                                JOptionPane.showMessageDialog(window,"WYGRA£EŒ.");
                            }
                    }
                    else if(event.getButton() == MouseEvent.BUTTON2){
                        System.out.println(Okno.liczbaOflagowanychBomb);
                    }
                }
            });
        }catch(Exception e){}       
    }
}