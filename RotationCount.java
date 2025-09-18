// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(countRotations(arr));
    }
    
    static int countRotations(int[] arr){
        int pivot = findPivot(arr);
        
        return pivot + 1;
    }
    
    // use this when array will not contain duplicates
    static int findPivot(int[] arr){
        int start = 0; 
        int end = arr.length -1 ; 
        
        // do simple binary search
        while(start <= end){
            // finding the middle element
            int mid = start + (end - start) / 2 ; 
            // 4 cases over here 
            // case 1: 
            if(mid < end && arr[mid] > arr[mid + 1]){
                 // that means we've found our answer
                return mid; 
            }
            // case 2: what if our mid is at the last index and when mid + 1 happens it will throw an exception : array index out of bound. so , we've to make a check for it that mid should always be less than end. 
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid -1; 
            }
            // case 3: ignore the smaller elements by end = mid - 1;
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else{
                start = mid + 1; 
            }
        }
        
        return -1; 
    }
    
    // this will work for duplicates. 
    static int findPivotWithDuplicates(int[] arr){
        int start = 0; 
        int end = arr.length -1 ; 
        
        // do simple binary search
        while(start <= end){
            // finding the middle element
            int mid = start + (end - start) / 2 ; 
            // 4 cases over here 
            // case 1: 
            if(mid < end && arr[mid] > arr[mid + 1]){
                 // that means we've found our answer
                return mid; 
            }
            // case 2: what if our mid is at the last index and when mid + 1 happens it will throw an exception : array index out of bound. so , we've to make a check for it that mid should always be less than end. 
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid -1; 
            }
            
            // if elements at the start , end , middle are equal then just skip the duplicates.
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                //skip the duplicates
                
                // NOTE : what if this elements at the  start and end were the pivots??
                // check if start is pivot
                if(arr[start] > arr[start + 1]){
                    return start; 
                }
                start++;
                
                // what if end is pivot
                if(arr[end] < arr[end - 1]){
                    return end - 1; 
                }
                end--;
            }
            
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        
        
        return -1; 
    }
}