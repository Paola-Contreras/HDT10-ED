/*  Universidad del Valle de Guatemala 
    Estructura de datos 
    Gabriela Paola Contreras Guerra
    Carné: 20213*/

    //Imports
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

    public class Main{
        public static void main(String[] args) throws FileNotFoundException{ 
            Floyd grafo = new Floyd();
            Scanner scan = new Scanner(System.in);
        // Try & Catch that reads the dictionary and save it on an array separate by , 
        try{
            File info= new File("guategrafo.txt");
        }catch(Exception e){
            System.out.println("No se ha encontrado el archivo");
        }
        }
    }