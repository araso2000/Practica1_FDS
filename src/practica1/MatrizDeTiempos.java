package practica1;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MatrizDeTiempos {
    int numFilas;
    int numColum;
    long[][] datos;
    String[] titulos;
    
    public MatrizDeTiempos(int fil,int col,String[] array){
        this.numColum=col;
        this.numFilas=fil;
        this.titulos=array;
        this.datos = new long[this.numFilas][this.numColum];
    }
    
    public void asignaValor(int fil,int col,long dato){
        this.datos[fil][col] = dato;
    }
    
    public void imprimeTiempos(){
        for(int ii=0;ii<this.numFilas;ii++){
            for(int jj=0;jj<this.numColum;jj++){
                System.out.print(this.datos[ii][jj] + " ");
            }
            System.out.println();
        }
    }
   
    public void guardaTiempo(String titulo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(titulo))) {
            for(int i=0;i<this.numFilas;i++){
                String fila = "";
                fila += this.titulos[i] + ";";
                for(int j=0;j<this.numColum;j++){
                    fila += this.datos[i][j] + ";";
                }
                fila += "\n";
                writer.write(fila);
            }
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}