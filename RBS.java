// Rotated binary search - Google & Amazon interview question.
public class RBS{
    public static void main(String[] args){
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findPivot(arr));
    }
    
    static int search(int[] nums, int target){
        int pivot = findPivot(nums);
        // if we did not find the pivot , that means the array is not rotated.
        if(pivot == -1){
            //just do a normal binary search
            return binarySearch(nums , target , 0 , nums.length - 1); 
        }
        
        // if pivot is found , you have two ascending sorted arrays
        // case 1 : pivot element is equal to target
        if(nums[pivot] == target){
            return pivot; 
        }
        // case 2 : target > start element , search space will be (start, pivot - 1); why ? --> because all the elements after pivot are less than start.
        if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot-1);
        }
        // case 3 : target < start element. i.e we know that all elements from (start,pivot) are going to be bigger than target. {4,5,6,7,0,1,2} for ex : if we want to search 1 then 4 is the start and 7 is the pivot , all the elements from start till pivot is greater than 1. search space is now (pivot + 1 , end). 
        return binarySearch(nums, target, pivot + 1 , nums.length - 1); 
    }
    
    static int binarySearch(int[] arr, int target, int start , int end){
        while(start <= end){
            //find the middle element
            int mid = start + (end - start) / 2 ; 
            
            if(target < arr[mid]){
                end = mid - 1; 
            }else if(target > arr[mid]){
                start = mid + 1; 
            }else {
                // ans found
                return mid; 
            }
        }
        
        return -1; 
    }
    
    
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
    
}