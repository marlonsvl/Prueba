/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package countinversions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author mipro
 */
public class QuickSort {
    public static long totalcomparations = 0;
    public int[] obtenerArreglo(){
        FileReader fr;
        int[] lista = new int[10000];
        try {
            fr = new FileReader("/home/mipro/QuickSort.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            int cont = 0;
            while((linea = br.readLine()) != null){
                int aux = Integer.parseInt(linea);
                lista[cont] = aux;
                cont++;
            }
            System.out.println(cont);
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
                
        }
        return lista;
    }
    
    public int partition(int[] a, int right, int left, int pivotIndex){
        int pivotValue = a[pivotIndex];
        //intercamibamos el pivote a la ultima posicion
        int tmp = a[right];
        a[right] = pivotValue;
        a[pivotIndex] = tmp;
        int storeIndex = left;
        
        for (int i = left; i <= right; i++) {
            if(a[i] < pivotValue){
                int aux = a[i];
                a[i] = a[storeIndex];
                a[storeIndex] = aux;
                storeIndex++;
            }
        }
        tmp = a[storeIndex];
        a[storeIndex] = a[right];
        a[right] = tmp;
        return storeIndex;
    }
    
//    public int partition(int[] a, int right, int left, int pivotIndex){
//        int pivotValue = a[pivotIndex];
//        //intercamibamos el pivote a la ultima posicion
//        int tmp = a[right];
//        a[right] = pivotValue;
//        a[pivotIndex] = tmp;
//        int storeIndex = left +1;
//        
//        for (int i = left+1; i <= right; i++) {
//            if(a[i] < pivotValue){
//                int aux = a[i];
//                a[i] = a[storeIndex];
//                a[storeIndex] = aux;
//                storeIndex++;
//            }
//        }
//        tmp = a[left];
//        a[left] = a[storeIndex-1];
//        a[storeIndex-1] = tmp;
//        return storeIndex;
//    }
    
    public void quicksort(int[] a, int left, int right){
        if(left < right){
            //int pivotIndex = (int)Math.round(Math.random()*(a.length-1));
            //int pivotIndex = left;
            //int pivotIndex = right;
            int pivotIndex = (left+right)/2;
            int pivotNewIndex = partition(a, right, left, pivotIndex);
            
            quicksort(a, left, pivotNewIndex-1);
            totalcomparations = totalcomparations + ((pivotNewIndex-left)-1);
            quicksort(a, pivotNewIndex+1, right);
            totalcomparations = totalcomparations + ((right-pivotNewIndex)-1);
        }
    }
    
//    public int partition(int[]a, int l, int r){
//        int valor_pivote = a[l];
//        int pivote = l+1;
//        int aux = 0;
//        totalcomparations = totalcomparations + ((r-l)-1);
//        for (int j = l+1; j <= r; j++) {
//            if(a[j] < valor_pivote){
//                aux = a[j];
//                a[j] = a[pivote];
//                a[pivote] = aux;
//                pivote = pivote + 1;
//            }
//        }
//        aux = a[l];
//        a[l] = a[pivote-1];
//        a[pivote-1] = aux;
//        return pivote;
//    }
    
//    public void quicksort(int [] a, int l, int r){
//        int pivote;
//        
//        if(l < r){
//            //pivote = (int)Math.round(Math.random()*a.length);
//            pivote = partition(a, l, r);
//            quicksort(a, l, pivote-1);
//            quicksort(a, pivote+1, r);
//        }
//        
//    }
    
    public static void main(String [] args){
        //int [] arr = {5,2,9,4,7,10,20,3,1,6,8,11};
        QuickSort q = new QuickSort();
        int [] arr = q.obtenerArreglo();
        q.quicksort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            System.out.println(j);
            
        }
        
        System.out.println("total: "+totalcomparations);
    }
}
