import java.util.Vector;

/*  Universidad del Valle de Guatemala 
    Estructura de datos 
    Gabriela Paola Contreras Guerra
    Carné: 20213*/

    import java.util.*;
public class Floyd {
    
    private Vector<String> Ubicacion;
    private int[][] distancia;
    private int[][] ruta;

    public Floyd(){
        Ubicacion= new  Vector<String>();
        distancia= new int [50][50];
        ruta= new int [50][50];

        for (int i =0; i<50; i++){
            for (int j =0; j<50; j++){
               
                ruta [i][j]=1000;
               
                if (i==j){
                    distancia[i][j]=0;
                }else{
                    distancia [i][j]=1000;
                }
            }
        }

    }

    public void center(){
        int mayor;
        Vector<Integer> centro= new  Vector<Integer>();
        for (int i =0; i<Ubicacion.size();i++){
            mayor = 0;
            for (int j =0; j<Ubicacion.size();j++){
                if(mayor < distancia[i][j]){
                    mayor = distancia[i][j];
                }
            }
            centro.add(mayor);
        }

        int o = Collections.min(centro);
        int idex =centro.indexOf(o);
        System.out.println("\n-La excentridad minima es de: "+ o );
        System.out.println("-El centro del grafo es" + Ubicacion.elementAt(idex));
    }

    public void Shorter_rute(){
        for (int i=0; i<Ubicacion.size();i++){
               for (int j = 0; j<Ubicacion.size(); j++){
                   for (int k = 0; k<Ubicacion.size(); k++){
                    if (distancia[j][i]==1000 || distancia[i][k]==100)
                    continue; // label that skips the remaining statements in the loop and proceeds to the next
                    if (distancia[j][i] + distancia[i][k]<distancia[j][k]){
                        distancia[j][k]=distancia[j][i] + distancia[i][k];
                        ruta[j][k]= ruta [j][i];
                    }
                }
            }
        }

    }
    
}
