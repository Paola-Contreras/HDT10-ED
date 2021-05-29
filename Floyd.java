/*  Universidad del Valle de Guatemala 
    Estructura de datos 
    Gabriela Paola Contreras Guerra
    Carné: 20213*/

    import java.util.*;
    import java.util.Vector;

public class Floyd {
    
    private Vector<String> Ubicacion;
    private int[][] distancia;
    private int[][] ruta;

    public Floyd(){
        Ubicacion= new  Vector<String>();
        distancia= new int [35][35];
        ruta= new int [35][35];

        for (int i =0; i<35; i++){
            for (int j =0; j<35; j++){
               
                ruta [i][j]=100;
               
                if (i==j){
                    distancia[i][j]=0;
                }else{
                    distancia [i][j]=100;
                }
            }
        }

    }
    public void agregar(String s, String a, String d){
        int kms;
        int kma;
        if (!Ubicacion.contains(s) || !Ubicacion.contains(a)){
            Ubicacion.add(s);
            Ubicacion.add(a);
        }

        kms=Ubicacion.indexOf(s);
        kma=Ubicacion.indexOf(a);
        distancia[kms][kma]= Integer.parseInt(d);
        if (d=="100"){
            ruta[kms][kma]=100;
        }else{
            ruta[kms][kma]= kma;
        }
    }

    public boolean existe(String s,String a){
        boolean esta= false; 
        if(Ubicacion.contains(s) && Ubicacion.contains(a)){
            esta=true;
        }
        return esta;
    }

    public void Shorter_rute(){
        for (int i=0; i<Ubicacion.size();i++){
               for (int j = 0; j<Ubicacion.size(); j++){
                   for (int k = 0; k<Ubicacion.size(); k++){
                    if (distancia[j][i]==100 || distancia[i][k]==100)
                    continue; // label that skips the remaining statements in the loop and proceeds to the next
                    if (distancia[j][i] + distancia[i][k]<distancia[j][k]){
                        distancia[j][k]=distancia[j][i] + distancia[i][k];
                        ruta[j][k]= ruta [j][i];
                    }
                }
            }
        }

    }


    public void center(){
        int max=0;
        Vector<Integer> centro = new  Vector<Integer>();
        
        for (int i =0; i<Ubicacion.size();i++){
            for (int j =0; j<Ubicacion.size();j++){
                if( distancia[i][j]>0){
                    max = distancia[i][j];
                }
            }
        centro.add(max);
        }
        
        int o = Collections.min(centro);
        int ub= centro.indexOf(o);
        String ub2= Ubicacion.get(ub);
        System.out.println("\n-La excentridad minima es de: "+ o );
        System.out.println("El centro del grafo es: " + ub2);
    }

 
    public int recorrido(String s, String a){
        int recorrio= distancia[Ubicacion.indexOf(s)][Ubicacion.indexOf(a)];
        return recorrio;
    }

    public void cerca(String s, String a){
        int u1= Ubicacion.indexOf(s);
        int u2= Ubicacion.indexOf(a);
        print(u1, u2);
    }


    private void print (int k, int m){
        Vector<String> camino = new Vector<String>();
        camino.add(" -"+Ubicacion.get(k));

        if (distancia[k][m] == 100 || distancia[k][m] == 0){
            System.out.println("No existe una conección entre ciudades\n"); 
        }else{
            while (k!= m){
                k = ruta[k][m];
                camino.add(Ubicacion.get(k));
            }
        }

        int tamano = camino.size();
        for(int i = 0; i < tamano - 1; i++)
        System.out.print(camino.get(i) + " \n - ");
        System.out.print(camino.get(tamano - 1) + "\n");
    }
}
