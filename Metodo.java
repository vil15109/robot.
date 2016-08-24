import java.awt.Point;

public class Metodo { 

    private static int direccioninicial= 1;
    private static String[] direcciones = {"North", "West", "South", "East" };

    private static String direc = direcciones[direccioninicial];

    public void imprimir (char[][] matriz)
    {
        for(int y = 0; y < 12; y++)
        {
            for(int x = 0; x < 12; x++)
            {
                System.out.print(" " + matriz[y][x]);
            }
            System.out.println();
        }
    }
        private static void der()
    {
        direccioninicial = (direccioninicial + 1) % 4;
        direc = direcciones[direccioninicial];
    }
    private static void izq()
    {
        direccioninicial = (direccioninicial + 3) % 4;
        direc = direcciones[direccioninicial];
    }
    private static char right(char [][] laber, Point p)
    {
        if ( direc.equals("North") )          
            return laber[p.y][p.x+1];
        else if ( direc.equals("East") )
            return laber[p.y+1][p.x];
        else if ( direc.equals("South") )
            return laber[p.y][p.x-1];
        else 
            return laber[p.y-1][p.x];
    }

    private static char left(char [][] laber, Point p)
    {
        if ( direc.equals("North") )          
            return laber[p.y][p.x-1];
        else if ( direc.equals("East") )
            return laber[p.y-1][p.x];
        else if ( direc.equals("South") )
            return laber[p.y][p.x+1];
        else 
            return laber[p.y+1][p.x];
    }
    
    private static char front(char [][] laber,Point p)
    {
        if ( direc.equals("North") )          
            return laber[p.y-1][p.x];
        else if ( direc.equals("East") )
            return laber[p.y][p.x+1];
        else if ( direc.equals("South") )
            return laber[p.y+1][p.x];
        else
            return laber[p.y][p.x-1];
    }
    
    private static void move(char [][] laber, Point p)
    {
        laber[p.y][p.x] = 'x'; 
        
        if ( direc.equals("North") )          
            p.y--; 
        else if ( direc.equals("East") )
            p.x++;
        else if ( direc.equals("South") )
            p.y++;
        else 
            p.x--;
    }

    private static boolean Salida( Point p )
    {

        if ( direc.equals("North") && p.y == 0 )          
            return true;
        else if ( direc.equals("East") && p.x == 11 )
            return true;
        else if ( direc.equals("South") && p.y == 11 )
            return true;
        else if ( direc.equals("West") && p.x == 0 )
            return true;
        else
            return false;
    }   
}
    public void recorrer(char [][] laber, Point p)
    {
        laber[p.y][p.x] = 'X';
        
        try {
            Thread.sleep(150);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 20; ++i) System.out.println(); // Limpia Consola
        
        
        if (Salida(p) ) { 
            laber[p.y][p.x] = ''; 
            imprimir(laber);
            System.out.println("Posicion actual: " + direc );

          
        }
        else {
            imprimir(laber);
            
            System.out.println("Poscion actual: " + direc);
            
            if (right(laber,p) != 'O' ) { 
                der();
                move(laber,p);
                recorrer(laber,p);
            }
            else if ( front(laber,p) != 'O' ) { 
                move(laber,p);
                recorrer(laber,p);
            }
            else if ( left(laber,p) != 'O' ) {
                izq();
                move(laber,p);
                recorrer(laber,p); 
            }
            else { // Realiza Giro si no encontro salida
                der();
                der();
                move(laber,p);
                recorrer(laber,p);
            }
                
        }
    }
    
