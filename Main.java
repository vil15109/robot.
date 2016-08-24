import java.awt.Point;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Maze  miMaze = new Mazes () ;
        Metodo miMetodo = new Metodo ();
        Point puntoInicial = new Point( 0, 2 );
        char [][] maze = miMaze.Maze();
        Metodo.recorrer(laber, puntoInicial);
        
    } 
}