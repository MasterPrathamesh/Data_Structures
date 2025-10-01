public class LargestElement{
    public static void main(String[] args){
        int[] arr = {12, 5, 7, 2, 18, 9}; 
        
        int largest = arr[0]; // assume the first element is the largest. 
        
        for(int i=1; i < arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i]; 
            }
        }
        
        System.out.println("The largest element in the array is: " + largest); 
    }
}