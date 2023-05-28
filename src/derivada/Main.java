package derivada;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Kevin Huerta 2P 22310411
 */
public class Main 
{
    public static void main(String[] args) 
    {
        StringTokenizer separacion;
        
        Scanner scan = new Scanner(System.in);
        Lista lista = new Lista();
        
        String elementos;
     
        System.out.print("Derivadas....\nInserte la funcion\nf(x) = ");
            elementos = scan.nextLine();
            
        separacion = new StringTokenizer(elementos, " ");               //separa las ecuaciones gracias a los espacios
        
        while(separacion.hasMoreTokens())
        {
            lista.last(separacion.nextToken());                             // guardamos 5x^2 +2x^2 etc (el simbolo debe estar pegado
        }
        
        lista.derivada();
        lista.display_data();
    }
    
}