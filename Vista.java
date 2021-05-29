

 import java.util.Scanner;
public class Vista {
        Scanner scan;
    
    public Vista(){
        scan = new Scanner(System.in);
    }
    
    public int menu1(){
        int op = 4;
        String ops = "";
        boolean validar = true;
        System.out.println("\n----MENU----\n");
            System.out.println("1.Buscar ruta más corta entre dos ciudades");
            System.out.println("2.Mostrar el centro del grafo");
            System.out.println("3.Modificar grafo");
            System.out.println("4.Salir\n");

        while(validar == true){
            System.out.println("Ingrese su opcion:  ");
            ops = scan.next();
            op = validarNum(ops);
            if(op != -1){
                validar = false;
            } else {}
        } return op;
    }

    public int menu2(){
        int op = 3;
        String ops = "";
        boolean validar = true;
        System.out.println("\n----MODIFICAR GRAFO----\n");
            System.out.println("1.Interrupción de trafico");
            System.out.println("2.Conección entre ciudades");
            System.out.println("3.Salir\n");

        while(validar == true){
            System.out.println("Ingrese su opcion:  ");
            ops = scan.next();
            op = validarNum(ops);
            if(op != -1){
                validar = false;
            } else {}
        } return op;
    }


    public int validarNum (String rawNumero) {
        int numInt = -1;
        try {
            numInt = Integer.parseInt(rawNumero);
        }catch (NumberFormatException e){
           System.out.println( "\n*** Ingrese un numero valido porfa ***" );
        }
        return numInt;
      }


// ----------------------------------------- MESSAGE AREA ----------------------------------------------
    public void Welcome(){
        System.out.println("\nBienvenido al sistema Floyd");
    }

      public void despedida(){
        System.out.println("Se ha cerrado el programa");
    }
    public void Departure(){
        System.out.println("Ingrese el nombre de la ciudad de salida");
    }
    public void Arrive(){
        System.out.println("\nIngrese el nombre de la ciudad de destino");
    }
    public void distance(){
        System.out.println("\nIngrese la distancia entre las ciudades en km");
    }
   
    public void Cg(){
        System.out.println("Mostrando informacion del grafo.....");
    } 
    public void Error(){
        System.out.println("\n*** Ha ocurrido un error intentelo nuevamente ***\n");
    }
    public void ErrorF(){
        System.out.println("No se ha encontrado el archivo");
    }
    public void exito(){
        System.out.println("\n** El grafo se ha modificado con exito ** ");
        System.out.println("\nLos datos modificados fueron los siguientes: ");
    }
    public void rute(){
        System.out.println("Las ciudades por las cuales se pasaron fueron: ");
    }
    public void back(){
        System.out.println("Regresando a menu principal.... ");
    }
}