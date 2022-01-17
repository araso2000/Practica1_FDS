package practica1;

public class VectorOrdenable {
    private int numeroDeElementos;
    private volatile int[] vector;
    
    public VectorOrdenable(int num){
        this.numeroDeElementos=num;
        vector = new int[this.numeroDeElementos];
    }
    
    public void Borrardo(){
        this.numeroDeElementos=0;
        this.vector=null;
    }
    
    public void rellenaVectorEnOrden(){
        for(int i=0;i<this.numeroDeElementos;i++){
            this.vector[i]=i+1;
        }
    }
    
    public void rellenaVectorEnOrdenInverso(){
        int temp=this.numeroDeElementos;
        for(int i=0;i<this.numeroDeElementos;i++){
            this.vector[i]=temp;
            temp--;
        }
    }
    
    public void rellenaVectorAleatoriamente(){
        for(int i=0;i<this.numeroDeElementos;i++){
            this.vector[i]=(int)(Math.random()*200000);
        }
    }
    
    public void imprimeVector(){
        for(int ii=0;ii<this.numeroDeElementos;ii++){
            System.out.println(this.vector[ii] + "\n");
        }
    }
    
    public long ordenaPorBurbuja(){
        long tiempo;
        long comienzo = System.nanoTime();
        for (int i = 0; i < this.numeroDeElementos-1; i++){
            for (int j = 0; j < this.numeroDeElementos-i-1; j++){
                if (this.vector[j] > this.vector[j+1]){ 
                    int temp = this.vector[j]; 
                    this.vector[j] = this.vector[j+1]; 
                    this.vector[j+1] = temp; 
                } 
            }
        }
        tiempo = System.nanoTime() - comienzo;
        return(tiempo);
    }
    
    public long ordenaPorSeleccionDirecta(){
        long tiempo;
        long comienzo = System.nanoTime();
        for (int i = 0; i < this.numeroDeElementos-1; i++){ 
            int minimo = i; 
            for (int j = i+1; j < this.numeroDeElementos; j++){
                if (this.vector[j] < this.vector[minimo]){ 
                    minimo = j; 
                }
                int temp = this.vector[minimo]; 
                this.vector[minimo] = this.vector[i]; 
                this.vector[i] = temp; 
            } 
        }
        tiempo = System.nanoTime() - comienzo;
        return(tiempo);
    }
    
    public long ordenaPorMezcla(){
        long tiempo;
        long comienzo = System.nanoTime();
        sort(vector,0,vector.length-1);
        tiempo = System.nanoTime() - comienzo;
        return(tiempo);
    }
    
    public void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i){
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j){
            R[j] = arr[m + 1 + j];
        }
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    public void sort(int arr[], int l, int r){
        if (l < r) {
            int m =l+ (r-l)/2;
 
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            merge(arr, l, m, r);
        }
    }
}