package derivada;

import java.util.StringTokenizer;

/**
 *
 * @author Kevin Huerta
 */
public class Lista 
{
    Nodo inicio;
    Nodo ultimo;
    
    public Lista()
    {
        inicio = null;
    }
    
    public boolean isEmpty()
    {
        if(inicio == null)
            return true;
        return false;
    }
    
    public void begin(String dato)
    {
        Nodo nuevo;
        
        if(isEmpty())
        {
            nuevo = new Nodo(dato, null);
            inicio = nuevo;
            ultimo = inicio;
        }
        else
        {
            nuevo = new Nodo(dato, null);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }
    
    public void display_data()
    {
        Nodo temporal;
        
        if(isEmpty())
        {
            System.out.println("No hay elementos");
        }
        else
        {
            temporal = inicio;
            
            while(temporal != null)
            {
                System.out.println(" "+temporal.getDato());
                temporal = temporal.getSiguiente();
            }
        }
    }
    
    
    //operaciones de derivacion
    
    public void derivada()
    {
        StringTokenizer separador_x;
        Nodo impar = inicio;
        Nodo par = impar.getSiguiente();
        
        int iterador = 1;
        int constante, potencia, multiplicacion;
        String variable = "x";
        
        while(par != null)
        {
            if((iterador % 2) == 0)
            {
                iterador++;
                impar = impar.getSiguiente();
                par = par.getSiguiente();
            }
            else
            {
                if(impar.getDato().contains("x"))
                {
                    separador_x = new StringTokenizer(impar.getDato(), "x");
                    constante = Integer.parseInt(separador_x.nextToken());
                    potencia = Integer.parseInt(par.getDato());

                    multiplicacion = constante * potencia;

                    potencia -= 1;

                    par.setDato(String.valueOf(potencia));

                    if(potencia != 0)
                    {
                        impar.setDato(String.valueOf(multiplicacion)+variable);         //concatenamos 5 con x = 5x
                    }
                    else
                    {
                        impar.setDato(String.valueOf(multiplicacion));
                    }
                }
                else
                {
                    impar.setDato("0");
                    par.setDato("0");
                }
                
                iterador++;
                impar = impar.getSiguiente();
                par = par.getSiguiente();
            }
        }
        
    }
}
