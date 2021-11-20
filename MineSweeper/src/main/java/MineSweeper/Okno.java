package MineSweeper;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Okno extends JPanel {
    
    public static int x;
    public static int y;
    
    public static int numer_tablicy;
    public static int i;
    public static int j;
    
    public static int iloscPol;
    public static int rozmiarX;
    public static int rozmiarY;
    public static int iloscBomb;
    
    public static pola[][] tablica;
    
    public static int ilosc_flag;
    
    public static int liczbaOflagowanychBomb = 0;
    
    public Okno(int iP, int rX, int rY, int iB) throws IOException{
        
        iloscPol = iP;
        rozmiarX = rX;
        rozmiarY= rY;
        iloscBomb = iB;
        ilosc_flag = iloscBomb;
        tablica = new pola[rozmiarX][rozmiarY];
        

        
        x = 0;
        y = 0;
        numer_tablicy = 0;
        i = 0;
        j = 0;
        
        setLayout(null);
        
        for(i = 0; i < rozmiarY; i++){
            for(j = 0; j < rozmiarX; j++){
                tablica[j][i] = new pola(x,y,numer_tablicy,0,0,j,i);
                add(tablica[j][i].pole);
                x += 30;
                numer_tablicy++;
            }
            j = 0;
            x = 0;
            y += 30;
        }
        wylosuj_i_przydziel(iloscBomb,tablica,iloscPol);
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(rozmiarX*30,rozmiarY*30);
    }
    
    public void wylosuj_i_przydziel(int iloscBomb, pola[][] tablica, int iloscPol)
    {     
        List<Integer> pozycjeBomb = new ArrayList<Integer>();  
        
        int losowa;
        int zmienna1;
        
        boolean powtorka = false;
        
        losowa = (int)(Math.random()*iloscPol-1);
        pozycjeBomb.add(losowa);
        
        for(int inumenator = 0; inumenator < iloscBomb - 1; inumenator++)
        {
            do{
                losowa = (int)(Math.random()*iloscPol-1);
            }while(pozycjeBomb.contains(losowa));
            pozycjeBomb.add(losowa);
            System.out.println(pozycjeBomb.get(inumenator));
        }
        for(int b:pozycjeBomb)
        {
            for(int i = 0; i < rozmiarY; i++)
            {
                for(int j = 0; j < rozmiarX; j++)
                {
                    if(tablica[j][i].numer_w_tabeli == b)
                    {
                        tablica[j][i].rodzaj_pola = -1;         //TUTAJ MAJA SIE USTAWIAC CYFRY
                                                                //ZMIENIC WYSZUKIWANIA PO KOORDACH NA NUMER W TABLICY I BEDZIE GIT
                        if(tablica[j][i].kx == 0 && tablica[j][i].ky == 0)
                        {
                            if(tablica[j+1][i].rodzaj_pola != -1)
                            {
                               tablica[j+1][i].rodzaj_pola++; 
                            }
                            if(tablica[j][i+1].rodzaj_pola != -1)
                            {
                                tablica[j][i+1].rodzaj_pola++;
                            }
                            if(tablica[j+1][i+1].rodzaj_pola != -1)
                            {
                                tablica[j+1][i+1].rodzaj_pola++;
                            } 
                        }
                        else if(tablica[j][i].kx == rozmiarX && tablica[j][i].ky == 0)
                        {
                            if(tablica[j-1][i].rodzaj_pola != -1)
                            {
                                tablica[j-1][i].rodzaj_pola++;
                            }
                            if(tablica[j][i+1].rodzaj_pola != -1)
                            {
                                tablica[j][i+1].rodzaj_pola++;
                            }
                            if(tablica[j-1][i+1].rodzaj_pola != -1)
                            {
                                tablica[j-1][i+1].rodzaj_pola++;
                            }
                        }
                        else if(tablica[j][i].kx == 0 && tablica[j][i].ky == rozmiarY)
                        {
                            if(tablica[j+1][i].rodzaj_pola != -1)
                            {
                                tablica[j+1][i].rodzaj_pola++;
                            }
                            if(tablica[j][i-1].rodzaj_pola != -1)
                            {
                                tablica[j][i-1].rodzaj_pola++;
                            }
                            if(tablica[j+1][i-1].rodzaj_pola != -1)
                            {
                                tablica[j+1][i-1].rodzaj_pola++;
                            }
                        }
                        else if(tablica[j][i].kx == rozmiarX && tablica[j][i].ky == rozmiarY)
                        {
                            if(tablica[j-1][i].rodzaj_pola != -1)
                            {
                                tablica[j-1][i].rodzaj_pola++;
                            }
                            if(tablica[j][i-1].rodzaj_pola != -1)
                            {
                                tablica[j][i-1].rodzaj_pola++;
                            }
                            if(tablica[j-1][i-1].rodzaj_pola != -1)
                            {
                                tablica[j-1][i-1].rodzaj_pola++;
                            }        
                        }
                        else if(tablica[j][i].ky == 0 && tablica[j][i].kx < rozmiarX-1 && tablica[j][i].kx > 0)
                        {
                            if(tablica[j+1][i].rodzaj_pola != -1)
                            {
                                tablica[j+1][i].rodzaj_pola++;
                            }
                            if(tablica[j-1][i].rodzaj_pola != -1)
                            {
                                tablica[j-1][i].rodzaj_pola++;
                            }
                            if(tablica[j+1][i+1].rodzaj_pola != -1)
                            {
                                tablica[j+1][i+1].rodzaj_pola++;
                            }
                            if(tablica[j-1][i+1].rodzaj_pola != -1)
                            {
                                tablica[j-1][i+1].rodzaj_pola++;
                            }
                            if(tablica[j][i+1].rodzaj_pola != -1)
                            {
                                tablica[j][i+1].rodzaj_pola++;
                            }     
                        }
                        else if(tablica[j][i].ky == rozmiarY && tablica[j][i].kx < rozmiarX-1 && tablica[j][i].kx > 0)
                        {
                            if(tablica[j+1][i].rodzaj_pola != -1)
                            {
                                tablica[j+1][i].rodzaj_pola++;
                            }
                            if(tablica[j-1][i].rodzaj_pola != -1)
                            {
                                tablica[j-1][i].rodzaj_pola++;
                            }
                            if(tablica[j-1][i-1].rodzaj_pola != -1)
                            {
                                tablica[j-1][i-1].rodzaj_pola++;
                            }
                            if(tablica[j+1][i-1].rodzaj_pola != -1)
                            {
                                tablica[j+1][i-1].rodzaj_pola++;
                            }
                            if(tablica[j][i-1].rodzaj_pola != -1)
                            {
                                tablica[j][i-1].rodzaj_pola++;
                            }       
                        }
                        else if(tablica[j][i].kx == 0 && tablica[j][i].ky < rozmiarY-1 && tablica[j][i].ky > 0)
                        {
                            if(tablica[j+1][i].rodzaj_pola != -1)
                            {
                                tablica[j+1][i].rodzaj_pola++;
                            }
                            if(tablica[j][i+1].rodzaj_pola != -1)
                            {
                                tablica[j][i+1].rodzaj_pola++;
                            }
                            if(tablica[j][i-1].rodzaj_pola != -1)
                            {
                                tablica[j][i-1].rodzaj_pola++;
                            }
                            if(tablica[j+1][i+1].rodzaj_pola != -1)
                            {
                                tablica[j+1][i+1].rodzaj_pola++;
                            }
                            if(tablica[j+1][i-1].rodzaj_pola != -1)
                            {
                                tablica[j+1][i-1].rodzaj_pola++;
                            }         
                        }
                        else if(tablica[j][i].kx == rozmiarX && tablica[j][i].ky < rozmiarY-1 && tablica[j][i].ky > 0)
                        {
                            if(tablica[j-1][i].rodzaj_pola != -1)
                            {
                                tablica[j-1][i].rodzaj_pola++;
                            }
                            if( tablica[j][i+1].rodzaj_pola != -1)
                            {
                                 tablica[j][i+1].rodzaj_pola++;
                            }
                            if(tablica[j][i-1].rodzaj_pola != -1)
                            {
                                tablica[j][i-1].rodzaj_pola++;
                            }
                            if(tablica[j-1][i+1].rodzaj_pola != -1)
                            {
                                tablica[j-1][i+1].rodzaj_pola++;
                            }
                            if(tablica[j-1][i-1].rodzaj_pola != -1)
                            {
                                tablica[j-1][i-1].rodzaj_pola++;
                            }   
                        }
                        else
                        {
                            if(j < rozmiarX-1)
                            {
                                if(tablica[j+1][i].rodzaj_pola != -1 )
                                {
                                   tablica[j+1][i].rodzaj_pola++; 
                                }    
                            }
                            
                            if(j > 0)
                            {
                                if(tablica[j-1][i].rodzaj_pola != -1 )
                                {
                                   tablica[j-1][i].rodzaj_pola++; 
                                }    
                            }
                            
                            if(i < rozmiarY-1)
                            {
                                if(tablica[j][i+1].rodzaj_pola != -1 )
                                {
                                   tablica[j][i+1].rodzaj_pola++; 
                                }   
                            }
                            
                            if(i > 0)
                            {
                                if(tablica[j][i-1].rodzaj_pola != -1 )
                                {
                                   tablica[j][i-1].rodzaj_pola++; 
                                }    
                            }
                            if(j < rozmiarX-1 && i < rozmiarY-1)
                            {
                                if(tablica[j+1][i+1].rodzaj_pola != -1 )
                                {
                                   tablica[j+1][i+1].rodzaj_pola++;
                                }
                            }
                            if(j < rozmiarX-1 && i > 0)
                            {
                                if(tablica[j+1][i-1].rodzaj_pola != -1 )
                                {
                                   tablica[j+1][i-1].rodzaj_pola++; 
                                }   
                            }
                            if(j > 0 && i > 0)
                            {
                                if(tablica[j-1][i-1].rodzaj_pola != -1 )
                                {
                                   tablica[j-1][i-1].rodzaj_pola++;
                                }   
                            }
                            if(j > 0 && i < rozmiarY-1)
                            {
                                if(tablica[j-1][i+1].rodzaj_pola != -1 )
                                {
                                   tablica[j-1][i+1].rodzaj_pola++;
                                }   
                            }   
                        }  
                    }
                }
                j = 0;
            } 
        }

    }
//    public static void odkryjObok(int x, int y)
//    {
//        if(tablica[x][y].kx == 0 && tablica[x][y].ky == 0)
//        {
//            if(tablica[x+1][y].rodzaj_pola == 0)
//            {
//               tablica[x+1][y].czy_odkryte = 1; 
//            }
//            if(tablica[x][y+1].rodzaj_pola == 0)
//            {
//                tablica[x][y+1].czy_odkryte = 1;
//            }
//            if(tablica[x+1][y+1].rodzaj_pola == 0)
//            {
//                tablica[x+1][y+1].czy_odkryte = 1;
//            } 
//        }
//        else if(tablica[x][y].kx == rozmiarX && tablica[x][y].ky == 0)
//        {
//            if(tablica[x-1][y].rodzaj_pola == 0)
//            {
//                tablica[x-1][y].czy_odkryte = 1;
//            }
//            if(tablica[x][y+1].rodzaj_pola == 0)
//            {
//                tablica[x][y+1].czy_odkryte = 1;
//            }
//            if(tablica[x-1][y+1].rodzaj_pola == 0)
//            {
//                tablica[x-1][y+1].czy_odkryte = 1;
//            }
//        }
//        else if(tablica[x][y].kx == 0 && tablica[x][y].ky == rozmiarY)
//        {
//            if(tablica[x+1][y].rodzaj_pola == 0)
//            {
//                tablica[x+1][y].czy_odkryte = 1;
//            }
//            if(tablica[x][y-1].rodzaj_pola == 0)
//            {
//                tablica[x][y-1].czy_odkryte = 1;
//            }
//            if(tablica[x+1][y-1].rodzaj_pola == 0)
//            {
//                tablica[x+1][y-1].czy_odkryte = 1;
//            }
//        }
//        else if(tablica[x][y].kx == rozmiarX && tablica[x][y].ky == rozmiarY)
//        {
//            if(tablica[x-1][y].rodzaj_pola == 0)
//            {
//                tablica[x-1][y].czy_odkryte = 1;
//            }
//            if(tablica[x][y-1].rodzaj_pola == 0)
//            {
//                tablica[x][y-1].czy_odkryte = 1;
//            }
//            if(tablica[x-1][y-1].rodzaj_pola == 0)
//            {
//                tablica[x-1][y-1].czy_odkryte = 1;
//            }        
//        }
//        else if(tablica[x][y].ky == 0 && tablica[x][y].kx < rozmiarX-1 && tablica[x][y].kx > 0)
//        {
//            if(tablica[x+1][y].rodzaj_pola == 0)
//            {
//                tablica[x+1][y].czy_odkryte = 1;
//            }
//            if(tablica[x-1][y].rodzaj_pola == 0)
//            {
//                tablica[x-1][y].czy_odkryte = 1;
//            }
//            if(tablica[x+1][y+1].rodzaj_pola == 0)
//            {
//                tablica[x+1][y+1].czy_odkryte = 1;
//            }
//            if(tablica[x-1][y+1].rodzaj_pola == 0)
//            {
//                tablica[x-1][y+1].czy_odkryte = 1;
//            }
//            if(tablica[x][y+1].rodzaj_pola == 0)
//            {
//                tablica[x][y+1].czy_odkryte = 1;
//            }     
//        }
//        else if(tablica[x][y].ky == rozmiarY && tablica[x][y].kx < rozmiarX-1 && tablica[x][y].kx > 0)
//        {
//            if(tablica[x+1][y].rodzaj_pola == 0)
//            {
//                tablica[x+1][y].czy_odkryte = 1;
//            }
//            if(tablica[x-1][y].rodzaj_pola == 0)
//            {
//                tablica[x-1][y].czy_odkryte = 1;
//            }
//            if(tablica[x-1][y-1].rodzaj_pola == 0)
//            {
//                tablica[x-1][y-1].czy_odkryte = 1;
//            }
//            if(tablica[x+1][y-1].rodzaj_pola == 0)
//            {
//                tablica[x+1][y-1].czy_odkryte = 1;
//            }
//            if(tablica[x][y-1].rodzaj_pola == 0)
//            {
//                tablica[x][y-1].czy_odkryte = 1;
//            }       
//        }
//        else if(tablica[x][y].kx == 0 && tablica[x][y].ky < rozmiarY-1 && tablica[x][y].ky > 0)
//        {
//            if(tablica[x+1][y].rodzaj_pola == 0)
//            {
//                tablica[x+1][y].czy_odkryte = 1;
//            }
//            if(tablica[x][y+1].rodzaj_pola == 0)
//            {
//                tablica[x][y+1].czy_odkryte = 1;
//            }
//            if(tablica[x][y-1].rodzaj_pola == 0)
//            {
//                tablica[x][y-1].czy_odkryte = 1;
//            }
//            if(tablica[x+1][y+1].rodzaj_pola == 0)
//            {
//                tablica[x+1][y+1].czy_odkryte = 1;
//            }
//            if(tablica[x+1][y-1].rodzaj_pola == 0)
//            {
//                tablica[x+1][y-1].czy_odkryte = 1;
//            }         
//        }
//        else if(tablica[x][y].kx == rozmiarX && tablica[x][y].ky < rozmiarY-1 && tablica[x][y].ky > 0)
//        {
//            if(tablica[x-1][y].rodzaj_pola == 0)
//            {
//                tablica[x-1][y].czy_odkryte = 1;
//            }
//            if( tablica[x][y+1].rodzaj_pola == 0)
//            {
//                 tablica[x][y+1].czy_odkryte = 1;
//            }
//            if(tablica[x][y-1].rodzaj_pola == 0)
//            {
//                tablica[x][y-1].czy_odkryte = 1;
//            }
//            if(tablica[x-1][y+1].rodzaj_pola == 0)
//            {
//                tablica[x-1][y+1].czy_odkryte = 1;
//            }
//            if(tablica[x-1][y-1].rodzaj_pola == 0)
//            {
//                tablica[x-1][y-1].czy_odkryte = 1;
//            }   
//        }
//        else
//        {
//            if(x < rozmiarX-1)
//            {
//                if(tablica[x+1][y].rodzaj_pola == 0 )
//                {
//                   tablica[x+1][y].czy_odkryte = 1; 
//                }    
//            }
//
//            if(x > 0)
//            {
//                if(tablica[x-1][y].rodzaj_pola == 0 )
//                {
//                   tablica[x-1][y].czy_odkryte = 1; 
//                }    
//            }
//
//            if(y< rozmiarY-1)
//            {
//                if(tablica[x][y+1].rodzaj_pola == 0 )
//                {
//                   tablica[x][y+1].czy_odkryte = 1; 
//                }   
//            }
//
//            if(y> 0)
//            {
//                if(tablica[x][y-1].rodzaj_pola == 0 )
//                {
//                   tablica[x][y-1].czy_odkryte = 1; 
//                }    
//            }
//            if(x < rozmiarX-1 && y< rozmiarY-1)
//            {
//                if(tablica[x+1][y+1].rodzaj_pola == 0 )
//                {
//                   tablica[x+1][y+1].czy_odkryte = 1;
//                }
//            }
//            if(x < rozmiarX-1 && y> 0)
//            {
//                if(tablica[x+1][y-1].rodzaj_pola == 0 )
//                {
//                   tablica[x+1][y-1].czy_odkryte = 1; 
//                }   
//            }
//            if(x > 0 && y> 0)
//            {
//                if(tablica[x-1][y-1].rodzaj_pola == 0 )
//                {
//                   tablica[x-1][y-1].czy_odkryte = 1;
//                }   
//            }
//            if(x > 0 && y< rozmiarY-1)
//            {
//                if(tablica[x-1][y+1].rodzaj_pola == 0 )
//                {
//                   tablica[x-1][y+1].czy_odkryte = 1;
//                }   
//            }   
//        }
//        
//    }
    
}