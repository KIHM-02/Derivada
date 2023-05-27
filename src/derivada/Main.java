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
        Scanner scan = new Scanner(System.in);
        Lista lista = new Lista();
        
        StringTokenizer cadena, separador_Potencia;
        
        String elementos, espacio;
        String delimOperador = "+- ";
        String delimPotencia = "^";
        
        System.out.print("Derivadas....\nInserte la funcion\nf(x) = ");
            elementos = scan.nextLine();
            
        espacio = elementos.replaceAll(" +", "").trim();                        // " +" elimina todo espacio,      por ejemplo...
    
        cadena = new StringTokenizer(espacio, delimOperador);
        
        while(cadena.hasMoreTokens())
        {
            separador_Potencia = new StringTokenizer(cadena.nextToken(), delimPotencia);
            
            while(separador_Potencia.hasMoreTokens())
            {
                  lista.begin(separador_Potencia.nextToken());
            }
        }
        
        lista.display_data();
        System.out.println("Derivando.....");
        lista.derivada();
        lista.display_data();
        
    }
    
}
