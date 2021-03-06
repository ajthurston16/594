/**This class includes implementations of algorithms as called for in the theory part of HW1. See the zipped latex
file for the rest of the writeup.

@author Alex Thurston
*/

public class TheoryCode {

    /** This method is written as an answer to Question #1. Since the array is of size n and contains elements 0
     * to n inclusive in order, one way to find a missing element is to compare the element's index to the element's
     * value. For element i in the array, if the index i == array[i], then the missing element must be somewhere
     * between index i + 1 and n - 1 inclusive. However, if i != array[i], the missing element must exist between 0
     * and i inclusive.
     * 
     * Since the array is ordered, a binary search could find the missing value in O(log n). This implementation
     * works by keeping track of a first and last index (initially set to the first and last indices of the array.
     * it checks an index i that is halfway between first and last.  If i matches array[i], it moves the first index
     * up and repeats the process. Otherwise, it moves the last index down and repeats the process. It terminates 
     * when last and first are adjacent indices. In most cases, it returns last, which will be the index i of the
     * first element in the array for which i != array[i] (i.e. the missing value). For the edge case where the first
     * element in the array is the missing element (meaning the first index did not move), it returns first.*/
    public static int binarySearch(int[] array) {
        int first = 0;
        int last = array.length - 1;
        while(last > first + 1) { 
            int i = (first + last) / 2;
            if(array[i] == i){
                first = i;
            }
            else {
                last = i;
            }
        }
        if (first == 0){
            return first;
        }
        return last;
    }
    
    public static void main(String[] args) {
        int[] testArray = { 1, 2, 3, 4, 5, 6, 7};
        System.out.println(binarySearch(testArray));
    
    }

}
