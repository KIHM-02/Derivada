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
        Lista funcion = new Lista();
        
        String elementos = "";
        int opcion = 0;
        
        while(opcion != 5)
        {
            
            System.out.println("\n===Bienvenido a derivando===\n");
            System.out.println("1) Ingrese la funcion");
            System.out.println("2) Realizar derivada de la funcion");
            System.out.println("3) Mostrar funciones");
            System.out.println("4) Eliminar ultimo elemento de la funcion");
            System.out.println("5) Salir");
            System.out.print(  "Opcion: ");
                opcion = scan.nextInt();
                scan.nextLine();                                                //Con esto borramos el \n que se queda con el nextInt()

            switch(opcion)
            {
                case 1:
                    System.out.println("\nLas operaciones deben estar separadas por espacio");
                    System.out.print("Ejemplo: 5x^2 +2x -4\nf(x) = ");

                        elementos = scan.nextLine();
                        separacion = new StringTokenizer(elementos, " ");   //separa las ecuaciones gracias a los espacios

                    while(separacion.hasMoreTokens())
                    {
                        funcion.last(separacion.nextToken());                   //guardamos 5x^2 +2x^2 etc (el simbolo debe estar pegado
                    }

                    break;

                case 2:
                    funcion.derivar_funcion();
                    System.out.println("La funcion se ha derivada\n");
                    break;

                case 3:
                    System.out.println("f(x) = "+elementos);
                    funcion.display_data();
                    break;

                case 4:
                    funcion.deleteData();
                    break;
                    
                case 5:
                    System.out.println("Adios...");
                    scan.close();
                    break;
                    
                default:
                    System.out.println("NO es una opcion ma fren");
            }
        }  
    }
    
}