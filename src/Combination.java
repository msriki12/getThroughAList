package anonimizacion;

/**
 * @author 	ricmart
 * @email	ricardomarsanc@gmail.com
 */
  
class Combination { 
  
	/**
	 * This function prints/stores all combinations of n numbers from (0,0,....,0) to (x,y,...,n).
	 * Array length must be at least 2, from n and also each value can goes from 0 to n.
	 * @param arr 			Array containing (x,y,...,n) like max values of our combination.
	 * @param aux 			Array starting at (0,0,...,0) and growing to reach (x,y,...,n).
	 * @param currentVal 	Index that stores actual value out of the aux Array, it is used only for
	 * 					 	stop the first while of this function and add 1 to the actual value until 
	 * 					 	reach max value.
	 * @param firstVal		Index that points the first element of an Array.
	 * @param actualVal		Index that stores actual value into the while of this function, it moves from
	 * 						0 to currentValue printing/storing all combinations remaining.
	 */
    static void combinationUtil(int arr[], int aux[], int currentVal, int firstVal, int actualVal){
    	      	
    	while(actualVal > currentVal){
			
			for(int i = 0; i < aux.length; i++) { //Print this combination
	       		System.out.print(aux[i]+ ",");
	       	}
			System.out.println("\n");
									
			aux[actualVal]++;
			
			if(aux[actualVal] > arr[actualVal]) {
				
				aux[actualVal] = 0;
				actualVal--;
				
				for(int i = actualVal; i > currentVal; i--) {
					if(aux[actualVal] == arr[actualVal]) {
						aux[actualVal] = 0;
						actualVal--;
					}
				}
				
				if(actualVal != currentVal && aux[actualVal] < arr[actualVal]) {
					aux[actualVal]++;
					actualVal = arr.length - 1;
				}
			}
   		}
    	
    	
   		if(currentVal == firstVal && aux[currentVal] >= arr[currentVal]) {
   			System.out.println("Terminadas todas las combinaciones.");
   		}else{
   			if(aux[currentVal] < arr[currentVal]) {
   				aux[currentVal]++;
   			}else {
   				aux[currentVal] = 0;
   				currentVal--;
   	   			aux[currentVal]++;
   			}
   			actualVal = arr.length - 1; //Recolocamos el puntero para hacer la siguiente serie
   	       	combinationUtil(arr, aux, currentVal, firstVal, actualVal);
   		}
   	}
    
    /**
     * Print an Array
     * @param arr
     */
    static void printVec(int arr[]) {
    	System.out.print("[");
    	for(int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i] + ",");
   		}
    	System.out.print("]\n");
    }
    
    /**
     * Caller to print/store all combinations of an Array
     * @param arr Array to be printed/stored
     */
    
    static void printCombination(int arr[]){
    	
    	int arrLength = arr.length;
        int aux[] = new int[arrLength]; 
                
        for(int i = 0; i < arr.length; i++) { //Filling the aux Array with 0's
        	aux[i] = 0;
        }
          
        combinationUtil(arr, aux, arr.length - 2, 0, arr.length - 1);
    }
}