/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package countinversions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author mipro
 */
public class CountInversions {

    /**
     * @param args the command line arguments
     */
    public int[] obtenerArreglo(){
        FileReader fr;
        int[] lista = new int[100000];
        try {
            fr = new FileReader("/home/mipro/Dropbox/seam/IntegerArray.txt");
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
    
    public long mezclarYContar(int[] izq, int[] der, int[] result){
        int i = 0;
        int j = 0;
        int k = 0;
        long numeroInversiones = 0;
        while( i < izq.length && j < der.length){
            if(der[j] < izq[i]){
                numeroInversiones += izq.length - i;
                result[k++] = der[j];
                j++;
            }else if(izq[i] < der[j]){
                result[k++] = izq[i];
                i++;
            }  
        }
        //System.out.println("k: "+k+" i: "+i+" j: "+j);
        if(i == izq.length ){
            for (int l = j; l < der.length; l++) 
                result[k++] = der[l];
        }else if(j == der.length ){
            for (int l = i; l < izq.length; l++) 
                result[k++] = izq[l];
        }
        //System.out.println(numeroInversiones);
        return numeroInversiones;
    }
    public long ordenarYContar(int[] arr){
        
        System.out.println("arr: "+arr.length);
        if(arr.length < 2){
            return 0;
        }else{
            int mitad = (arr.length )/2;
            int[] x = Arrays.copyOfRange(arr, 0, mitad);
            int[] y = Arrays.copyOfRange(arr, mitad, arr.length);
            return ordenarYContar(x) + ordenarYContar(y) + mezclarYContar(x,y,arr);
        }
        
        
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = new int[6];
        arr[0] = 6;
        arr[1] = 5;
        arr[2] = 4;
        arr[3] = 3;
        arr[4] = 2;
        arr[5] = 1;
//        arr[0] = 1;
//        arr[1] = 5;
//        arr[2] = 4;
//        arr[3] = 8;
//        arr[4] = 10;
//        arr[5] = 2;
//        arr[6] = 6;
//        arr[7] = 9;
//        arr[8] = 12;
//        arr[9] = 11;
//        arr[10] = 3;
//        arr[11] = 7;
        
        CountInversions c = new CountInversions();
        
        System.out.println("numero de inversiones: "+c.ordenarYContar(c.obtenerArreglo()));
        //System.out.println(c.ordenarYContar(arr));
        
        
    }
}
