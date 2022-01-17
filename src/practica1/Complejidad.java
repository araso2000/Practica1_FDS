package practica1;

public class Complejidad {
    
    int iteraciones;
    private VectorOrdenable vectorParaBurbujaMejorCaso;
    private VectorOrdenable vectorParaBurbujaPeorCaso;
    private VectorOrdenable vectorParaBurbujaValoresAleatorios;

    private VectorOrdenable vectorParaSeleccionMejorCaso;
    private VectorOrdenable vectorParaSeleccionPeorCaso;
    private VectorOrdenable vectorParaSeleccionValoresAleatorios;
    
    private VectorOrdenable vectorParaMezclaOrdenAleatorio;
    private VectorOrdenable vectorParaMezclaMejorCaso;
    private VectorOrdenable vectorParaMezclaPeorCaso;
    private String[] titulos = {"BurbujaMejorCaso","BurbujaPeorCaso","BurbujaValoresAleatorios","SeleccionMejorCaso","SeleccionPeorCaso","SeleccionValoresAleatorios","MezclaMejorCaso","MezclaPeorCaso","MezclaValoresAleatorio"};
    private MatrizDeTiempos m1;
    
    
    public Complejidad(int n){
        this.iteraciones=n;
    }
    
    public void ejecutarAlgoritmos(){
        
        m1 = new MatrizDeTiempos(this.titulos.length, this.iteraciones,titulos);
        
        for(int j=0; j<this.titulos.length; j++){
            int ii=1;
        for(int i=0; i<this.iteraciones; i++){
            switch(j){
                case 0:
                    vectorParaBurbujaMejorCaso = new VectorOrdenable(ii);
                    vectorParaBurbujaMejorCaso.rellenaVectorEnOrden();
                    m1.asignaValor(j, i, vectorParaBurbujaMejorCaso.ordenaPorBurbuja());
                    vectorParaBurbujaMejorCaso.Borrardo();
                    
                break;
                case 1:
                    vectorParaBurbujaPeorCaso = new VectorOrdenable(ii);
                    vectorParaBurbujaPeorCaso.rellenaVectorEnOrdenInverso();
                    m1.asignaValor(j, i, vectorParaBurbujaPeorCaso.ordenaPorBurbuja());
                    vectorParaBurbujaPeorCaso.Borrardo();
                break;
                case 2:
                    vectorParaBurbujaValoresAleatorios = new VectorOrdenable(ii);
                    vectorParaBurbujaValoresAleatorios.rellenaVectorAleatoriamente();
                    m1.asignaValor(j, i, vectorParaBurbujaValoresAleatorios.ordenaPorBurbuja());
                    vectorParaBurbujaValoresAleatorios.Borrardo();
                break;
                case 3:
                    vectorParaSeleccionMejorCaso = new VectorOrdenable(ii);
                    vectorParaSeleccionMejorCaso.rellenaVectorEnOrden();
                    m1.asignaValor(j, i, vectorParaSeleccionMejorCaso.ordenaPorSeleccionDirecta());
                    vectorParaSeleccionMejorCaso.Borrardo();
                break;
                case 4:
                    vectorParaSeleccionPeorCaso = new VectorOrdenable(ii);
                    vectorParaSeleccionPeorCaso.rellenaVectorEnOrdenInverso();
                    m1.asignaValor(j, i, vectorParaSeleccionPeorCaso.ordenaPorSeleccionDirecta());
                    vectorParaSeleccionPeorCaso.Borrardo();
                break;
                case 5:
                    vectorParaSeleccionValoresAleatorios = new VectorOrdenable(ii);
                    vectorParaSeleccionValoresAleatorios.rellenaVectorAleatoriamente();
                    m1.asignaValor(j, i, vectorParaSeleccionValoresAleatorios.ordenaPorSeleccionDirecta());
                    vectorParaSeleccionValoresAleatorios.Borrardo();
                break;
                case 6:
                    vectorParaMezclaMejorCaso = new VectorOrdenable(ii);
                    vectorParaMezclaMejorCaso.rellenaVectorEnOrden();
                    m1.asignaValor(j, i, vectorParaMezclaMejorCaso.ordenaPorMezcla());
                    vectorParaMezclaMejorCaso.Borrardo();
                break;
                case 7:
                    vectorParaMezclaPeorCaso = new VectorOrdenable(ii);
                    vectorParaMezclaPeorCaso.rellenaVectorEnOrdenInverso();
                    m1.asignaValor(j, i, vectorParaMezclaPeorCaso.ordenaPorMezcla());
                    vectorParaMezclaPeorCaso.Borrardo();
                break;
                case 8:
                    vectorParaMezclaOrdenAleatorio = new VectorOrdenable(ii);
                    vectorParaMezclaOrdenAleatorio.rellenaVectorAleatoriamente();
                    m1.asignaValor(j, i, vectorParaMezclaOrdenAleatorio.ordenaPorMezcla());
                    vectorParaMezclaOrdenAleatorio.Borrardo();
                break;
            }
            ii = ii + 1;
            }
        }
    }
    
    public void GuardarDatos(String tit){
        m1.guardaTiempo(tit);
    }
    
    public void imprimirTiempos(){
        m1.imprimeTiempos();
    }
}
