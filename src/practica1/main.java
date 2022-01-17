package practica1;

public class main {
    public static void main(String[] args) {
        Complejidad complejidad = new Complejidad(5000);
        complejidad.ejecutarAlgoritmos();
        complejidad.imprimirTiempos();
        complejidad.GuardarDatos("ArchivoVOLATILE.csv");
    }
}