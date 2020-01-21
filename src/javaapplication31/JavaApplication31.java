package javaapplication31;
import java.util.Scanner;

public class JavaApplication31 {
    static int q=0;

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ievadiet kvadrata lielumu : ");
        int garums=in.nextInt();
        int rūtiņas=garums*garums;
        
        
        
        for(int iekrāsotas=garums;iekrāsotas<rūtiņas;iekrāsotas++){
            varianti(rūtiņas,iekrāsotas,q);
        }
        
     
      
    }
     public static final void varianti(final int rūtiņas, final int iekrāsotas,int skaits) {
        int[] rezultāti = new int[iekrāsotas];
        int[] līnija = new int[rūtiņas];
        int garums =(int)Math.sqrt(rūtiņas);
        int[][] kvadrāts=new int[garums][garums];
        for (int i = 0; i < rezultāti.length; i++) {
            rezultāti[i] = i + 1;
        }
        boolean pabeigts = false;
        while (!pabeigts) {
           
            for(int x=0;x<iekrāsotas;x++){
                līnija[rezultāti[x]-1]=1;
            }
            int count=0;
            for(int x=0;x<rūtiņas;x++){
                if(x!=0&&x%garums==0){
                    count++;
                    kvadrāts[count][x%garums]=līnija[x];
                }
                else{
                    kvadrāts[count][x%garums]=līnija[x];
                }
            }
            int flag1=pārbaude(kvadrāts, garums);
            int flag3=-1;
            if(flag1==0){
               for(int x=0;x<garums;x++){
                   for(int y=0;y<garums;y++){
                       if(kvadrāts[x][y]==0){
                           kvadrāts[x][y]=1;
                           int flag2=pārbaude(kvadrāts,garums);
                           if(flag2!=1){
                               flag3=1;
                           }
                           kvadrāts[x][y]=0;
                       }
                   }
               }
               if(flag3==-1){
                   int num=0;
                   
                    for(int x=0;x<garums;x++){
                        for(int y=0;y<garums;y++){
                            System.out.print(kvadrāts[x][y]+" ");
                            if(kvadrāts[x][y]==1){
                                num++;
                            }
                        }
                        System.out.println(" ");
                    }
                    
                    System.out.println(num+" iekrasoti laucini");
                    System.out.println(" ");
                    skaits++;
                    q=skaits;
                    System.out.println(skaits+". variants");
                    System.out.println(" ");
                   
               }
           }
            for(int x=0;x<rūtiņas;x++){
                līnija[x]=0;
            }
            
            pabeigts = viss(rezultāti, rūtiņas, iekrāsotas);
           
        }
    }

   
     
     public static int pārbaude(int variants[][], int n){
        int rinda=0;
        int kolonna=0;
        int[][] kvadrāts=new int[2][2];
        int q=0;
        do{
            do{
                kvadrāts[0][0]=variants[rinda][kolonna];
                kolonna++;
                kvadrāts[0][1]=variants[rinda][kolonna];
                kolonna--;
                rinda++;
                kvadrāts[1][0]=variants[rinda][kolonna];
                kolonna++;
                kvadrāts[1][1]=variants[rinda][kolonna];
                kolonna--;
                
                int f=0;
                
                for(int x=0;x<2;x++){
                    for(int y=0;y<2;y++){
                        if(kvadrāts[x][y]==1){
                            f++;
                        }
                    }
                }
                if(f>=3){
                    q=1;
                }

            }while(rinda<n-1);
            rinda=0;
            kolonna++;
            
        }while(kolonna<n-1);
        return q;
    }
     
     
     
     
    

    public static final boolean viss(final int[] rezultāti, final int rūtiņas, final int iekrāsotas) {
        int x = iekrāsotas - 1;
        rezultāti[x]++;
        if (rezultāti[x] > ((rūtiņas - (iekrāsotas - x)) + 1)) {
            
            while (rezultāti[x] > ((rūtiņas - (iekrāsotas - x)))) {
                x--;
                if (x < 0) {
                    break;
                }
            }
            if (x < 0) {
                return true;
            }
            rezultāti[x]++;
            for (int i = x + 1; i < rezultāti.length; i++) {
                rezultāti[i] = rezultāti[i - 1] + 1;
            }
        }
        return false;
    }
    
    
}