package derivada;

import java.util.StringTokenizer;

/**
 *
 * @author Kevin Huerta 22310411
 */
public class Lista 
{
    Nodo inicio;
    Nodo ultimo;
    
    public Lista()
    {
        inicio = null;
        ultimo = null;
    }
    
    public boolean isEmpty()
    {
        if(inicio == null)
            return true;
        return false;
    }
    
    public void last(String dato)
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
    
    public void deleteData()
    {
        Nodo temporal;
        
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
        }
        else
        {
            temporal = inicio;
            
            if(temporal == ultimo)
            {
                inicio = null;
                ultimo = null;
            }
            else
            {
                while(temporal.getSiguiente() != ultimo)
                {
                    temporal = temporal.getSiguiente();
                }
                
                temporal.setSiguiente(null);
                ultimo = temporal;
                System.out.println("Se ha borrado el ultimo elemento");
            }
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
            System.out.print("f'(x) =");
            while(temporal != null)
            {
                System.out.print(" "+temporal.getDato());
                temporal = temporal.getSiguiente();
            }
        }
    }
     
    //operaciones de derivacion
    
    public void derivar_funcion()
    {
        Nodo funcion;
        
        int constante, potencia;
        String ecuacion;
        
        funcion = inicio;
        
        while(funcion != null)
        {
            //simbolo = obtener_simbolo(funcion);
            constante = obtener_constante(funcion);
            potencia = obtener_potencia(funcion);
            ecuacion = evaluar(constante, potencia);
            
            funcion.setDato(ecuacion);
            funcion = funcion.getSiguiente();
        }

    }
    
    public int obtener_constante(Nodo funcion)                                  //-5x^2
    {
        StringTokenizer constante;
        int valor;
        
        if(funcion.getDato().contains("x"))
        {
            constante = new StringTokenizer(funcion.getDato(), "x");
            valor = Integer.parseInt(constante.nextToken());                  //aqui solo me regresa el -5
        }
        else
        {
            valor = 0;                                                          //regresa un 0 porque es una constante
        }
        return valor;
    }
    
    public int obtener_potencia(Nodo funcion)                                   //-5x^2
    {
        StringTokenizer potencia;
        String cadena = funcion.getDato();
        int valor;
        String pot = "";
        
        if(cadena.contains("^"))
        {   
            potencia = new StringTokenizer(cadena, "^");
            while(potencia.hasMoreTokens())
            {
                pot = potencia.nextToken();                                     //guardo lo que sigue de ^2 ...-> 2
            }            
            valor = Integer.parseInt(pot);
        }
        else
        {
            valor = 1;                                                          //tiene potencia a la 1  como 5x
        }
        
        return valor;
    }
    
    public String evaluar(int constante, int potencia)
    {
        int resultado;
        int potenciaTotal;
        String ecuacion;
        
        if(constante == 0)
        {
            ecuacion = "0";                                                     //aqui mando a 0 porque es una constante
        }
        else
        {
            potenciaTotal = potencia-1;
            
            if(potenciaTotal < 0 || potenciaTotal > 1)
            {
                resultado = constante * potencia;
                ecuacion = String.valueOf(resultado)+"x^"+String.valueOf(potenciaTotal);
            }
            else if (potenciaTotal == 1)
            {
                resultado = constante * potencia;
                ecuacion = String.valueOf(resultado)+"x";
            }
            else
            {
                resultado = constante * potencia;
                ecuacion = String.valueOf(resultado);
            }
        }
        
        return ecuacion;
    }
}
