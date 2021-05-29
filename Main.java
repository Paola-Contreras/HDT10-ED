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
            
            //Attributes 
            Vista v = new Vista();
            Floyd grafo = new Floyd();
            Scanner scan = new Scanner(System.in);
            int menusito  = 0;
            int menusito2 = 0;
            int menusito3 = 0;
            boolean salir  = false;
            boolean salir1 = false;
            boolean salir2 = false;
            String Csalida  = "";
            String Cdestino = "";
            String caminokm = "";

        // Try & Catch that reads the txt file  and save it on an matrix separate by a space 
            try{
                File Info= new File("guategrafo.txt"); // file that want to be open 
                Scanner readFile= new Scanner(Info);

                // Loop that reads if the document still have lines 
                while(readFile.hasNextLine()){
                    String Lineas = readFile.nextLine(); 
                    String[] Separa = Lineas.split(" "); // Splits the document by space    
                    grafo.agregar(Separa[0], Separa[1], Separa[2]); // Save the data into the matrix
                }  
            }catch(Exception e){
               v.ErrorF();
            }

            // The program starts 
            v.Welcome();
            grafo.Shorter_rute(); // organize the matrix using the Floyd method
           // loop that allows the program to always be running 
            while (salir==false){
                menusito= v.menu1(); // Main menu is shown 
                if(menusito==1){
                    // Distancia entre ciudades 
                    while(salir2==false){
                        menusito3=v.menu3(); // Sub menu to search again another rute 
                        if(menusito3==1){
                            // option that shows the shorter rute 
                            v.Departure(); // Ask for the first city 
                            Csalida=scan.nextLine();

                            v.Arrive(); // Ask for the second city 
                            Cdestino=scan.nextLine();
                            // If that checks if both cities exist 
                            if (grafo.existe(Csalida,Cdestino)){
                                v.rute();
                                grafo.cerca(Csalida, Cdestino); // Check the cities that arr coloser 
                                int gg = grafo.recorrido(Csalida, Cdestino); // shows the amount of km that were used 
                                System.out.println( "La distancia recorrida fue de: " + gg);
                            }else{
                                v.Error();
                            }
                        }if (menusito3==2){
                            // Return main menu  
                            v.back();
                            salir2 =true;
                        }
                    }

                }if (menusito==2){
                    // Mostrar el centro del grafo 
                    v.Cg();
                    grafo.center();

                }if(menusito==3){
                    // Modificar un grafo 
                   while(salir1==false){
                        menusito2=v.menu2(); // Sub menu to modify a graph 
                        // 
                        if(menusito2==1){
                            v.Departure();
                            Csalida=scan.nextLine();
                            v.Arrive();
                            Cdestino=scan.nextLine();
                            if (grafo.existe(Csalida, Cdestino)){
                                grafo.agregar(Csalida,Cdestino,"100");
                                v.exito();
                                System.out.println("Ciudades Modificadas: " +"\n-"+ Csalida + "\n-"+ Cdestino);
                            }else{
                                v.Error();
                            }
                        }if(menusito2==2){
                            v.Departure();
                            Csalida=scan.nextLine();
                            v.Arrive();
                            Cdestino=scan.nextLine();
                            v.distance();
                            caminokm=scan.nextLine();
                            if (grafo.existe(Csalida, Cdestino)){
                                grafo.agregar(Csalida,Cdestino,caminokm);
                                v.exito();
                                System.out.println("Ciudades Modificadas: " +"\n-"+ Csalida + "\n-"+ Cdestino );
                                System.out.println("La nueva distancia entre ciudades es de: "+caminokm);
                            }else{
                                v.Error();
                            }

                        }if (menusito2==3){
                            // Return to main menu  
                            v.back();
                            salir1 =true;
                        }
                    }
                }if (menusito==4){
                    // Break the cycle and close the program 
                    salir=true;
                    v.despedida();
                }
            }
        }
    }