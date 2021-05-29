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
                File Info= new File("guategrafo.txt");
                Scanner readFile= new Scanner(Info);
                while(readFile.hasNextLine()){
                    String Lineas = readFile.nextLine();
                    String[] Separa = Lineas.split(" ");   
                    grafo.agregar(Separa[0], Separa[1], Separa[2]);
                }  
            }catch(Exception e){
               v.ErrorF();
            }

            // 
            v.Welcome();
            while (salir==false){
                grafo.Shorter_rute(); 
                menusito= v.menu1();
                if(menusito==1){
                    // Distancia entre ciudades 
                    v.Departure();
                    Csalida=scan.nextLine();
                    v.Arrive();
                    Cdestino=scan.nextLine();
                    if (grafo.existe(Csalida,Cdestino)){
                        v.rute();
                        grafo.cerca(Csalida, Cdestino);
                        System.out.println( "La distancia recorrida fue de: " + grafo.recorrido(Csalida, Cdestino));
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
                            // Retornar menu inicial 
                            v.back();
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