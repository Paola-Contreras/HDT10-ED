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
            boolean salir  = false;
            boolean salir1 = false;
            String Csalida  = "";
            String Cdestino = "";
            String caminokm = "";

        // Try & Catch that reads the dictionary and save it on an array separate by , 
            try{
                File info= new File("guategrafo.txt");
            }catch(Exception e){
                System.out.println("No se ha encontrado el archivo");
            }

            // 
            while (salir==false){
                grafo.Shorter_rute(); 
                v.Welcome();
                menusito= v.menu1();
                if(menusito==1){
                    // Distancia entre ciudades 
                    v.Departure();
                    Csalida=scan.nextLine();
                    v.Arrive();
                    Cdestino=scan.nextLine();
                    if (grafo.existe(Csalida,Cdestino)){
                        System.out.println("Las ciudades por las cuales se pasaron fueron: ");
                        grafo.cerca(Csalida, Cdestino);
                        System.out.println( "La distancia recorrida fue: " + grafo.recorrido(Csalida, Cdestino));
                    }else{
                        v.Error();
                    }

                }if (menusito==2){
                    // Mostrar el centro del grafo 
                    v.Cg();
                    grafo.center();

                }if(menusito==3){
                    // Modificar un grafo 
                   while(salir1==false){
                        menusito2=v.menu2();
                        if(menusito2==1){
                            v.Departure();
                            Csalida=scan.nextLine();
                            v.Arrive();
                            Cdestino=scan.nextLine();
                            if (grafo.existe(Csalida, Cdestino)){
                                grafo.agregar(Csalida,Cdestino,"100");
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
                            }else{
                                v.Error();
                            }

                        }if (menusito2==3){
                            // Retornar menu inicial 
                            salir1 =true;
                        }
                    }
                }if (menusito==4){
                    // Cerrar programa
                    salir=true;
                    v.despedida();

                }
            }
        }
    }