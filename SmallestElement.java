public class SmallestElement{
    public static void main(String[] args){
        int[] arr = {12, 5, 7, 2, 18 , 19}; 
        int smallest = arr[0];//assume first element is smallest.
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < smallest){
                smallest = arr[i]; // update the element
            }
        }
        
        System.out.println("The smallest element in the array is : " + smallest); 
    }
}