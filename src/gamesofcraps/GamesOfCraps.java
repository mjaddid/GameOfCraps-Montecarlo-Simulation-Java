/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesofcraps;

import java.util.stream.IntStream;

/**
 *
 * @author jegichan
 */
public class GamesOfCraps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N=19; //jumlah permainan
        int menang=0,kalah=0,jmlMain=0,lempar=2;
        int jmlLempar []=new int [20];//menyimpan data jml lemparan
        
        while (jmlMain<=N)  
        {
            int dadu1=(int)(Math.random() * 5 + 1);
            int dadu2=(int)(Math.random() * 5 + 1);
            int jmlDadu=dadu1+dadu2;
            if ((jmlDadu==7)||(jmlDadu==11))//kondisi langsung menang
            {
                jmlLempar[jmlMain]=1;
                menang++;
            }
            else if((jmlDadu==2)||(jmlDadu==3)||(jmlDadu==12))//kondisi langsung kalah
            {
                jmlLempar[jmlMain]=1;
                kalah++;
            }
            else//kondisi lainnya
            {
                int dadu1l=(int)(Math.random() * 5 + 1);
                int dadu2l=(int)(Math.random() * 5 + 1);
                int jmlDadu2=dadu1l+dadu2l;
                if(jmlDadu==jmlDadu2)//kondisi ketika lemparan kedua sudah sama dengan lemparan pertama
                {
                    jmlLempar[jmlMain]=2;
                    menang++;
                }
                else if (jmlDadu2==7)//kondisi ketika lemparan kedua kalah (mendapat 7)
                {
                    jmlLempar[jmlMain]=2;
                    kalah++;                                        
                }
                else //kondisi lainnya
                {
                    while ((jmlDadu!=jmlDadu2)&&(jmlDadu2!=7))//untuk mendapatkan jumlah dadu sama seperti jumlah dadu awal
                    {
                        dadu1l=(int)(Math.random() * 5 + 1);
                        dadu2l=(int)(Math.random() * 5 + 1);
                        jmlDadu2=dadu1l+dadu2l;
                        lempar++;
                    } 
                    if(jmlDadu2!=7) // kondisi menang
                    {
                        jmlLempar[jmlMain]=lempar;
                        menang++;
                    }
                    else // kondisi kalah
                    {
                        jmlLempar[jmlMain]=lempar;
                        kalah++;    
                    }
                }   
            }
            jmlMain++;
        }
        int jml = IntStream.of(jmlLempar).sum();//menjumlah jumlah lemparan dadu
        double rLempar=jml/20;
        System.out.println("Jumlah Permainan        = "+(N+1));
        System.out.println("Jumlah Menang           = "+menang);
        System.out.println("Jumlah Kalah            = "+kalah);
        System.out.println("Jumlah Lemparan Dadu    = "+jml);
        System.out.println("Rata-Rata Lemparan Dadu = "+rLempar);
        int i=1;
        for (int element: jmlLempar) {
            System.out.println("Game ke-"+i+" = "+element+" lemparan dadu");
            i++;
        }
    }
    
}
