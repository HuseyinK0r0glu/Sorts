import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = createArray();

        int[] helper = new int[array.length];

        mergeSort(array,helper,0,array.length-1);
        //bubbleSort(array);
        //insertionSort(array);
        //selectionSort(array);
        writeArray(array);

        //System.out.println(binarySearch(array,234));

    }

    public static void writeArray(int[] array){
        System.out.println(Arrays.toString(array));;
    }

    public static int[] createArray(){
        int[] array = new int[1000];
        Random random = new Random();
        for(int i = 1;i<1000;i++){
            array[i] = random.nextInt(10000);
        }
        return array;
    }

    public static void selectionSort(int[] array){
        for(int i = 0;i<array.length;i++){
            int min = i;
            for(int j = i+1;j<array.length;j++){
                if(less(array,j,min)){
                    min = j;
                }
            }
            exchange(array,i,min);
        }
    }

    public static void insertionSort(int[] array){
        for(int i = 1;i<array.length;i++){
            for(int j = i;j>0;j--){
                if(less(array,j,j-1)){
                    exchange(array,j,j-1);
                }
            }
        }
    }

    public static void bubbleSort(int[] array){
        for(int i = 0;i<array.length-1;i++){
            boolean swapped = false;
            for(int j = 0;j<array.length-i-1;j++){

                if(less(array,j+1,j)){
                    exchange(array,j,j+1);
                    swapped = true;
                }

            }
            if(!swapped){
                break;
            }
        }
    }

    public static void mergeSort(int[] array,int[] helper,int low,int high){
        if(low < high){
            int middle = (low + high)/2;
            mergeSort(array,helper,low,middle); // for the left part
            mergeSort(array,helper,middle + 1,high); // for the right part
            merge(array,helper,low,middle,high);
        }
    }

    public static void merge(int[] array,int[] helper,int low,int middle,int high){
        for(int i = 0;i<array.length;i++){
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;

        while(helperLeft <= middle && helperRight <=high){
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] =  helper[helperLeft];
                helperLeft++;
            }else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        // there is equal sign before the remaining because we should add the middle one too
        for(int i = 0;i<=remaining;i++){
            array[current + i] = helper[helperLeft + i];
        }
    }

    public static void quickSort(int[] array,int left,int right){
        //?????????????
    }

    public static boolean less(int[] array,int i ,int j){
        if(array[i] < array[j]){
            return true;
        }
        return false;
    }

    public static void exchange(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Search
    // Binary Search

    public static int binarySearch(int[] array,int value){

        int low = 0;
        int high = array.length - 1;
        int mid;

        while(low <= high){
            mid = (low + high) / 2;
            if(array[mid] > value){
                high = mid-1;
            }else if(array[mid] < value){
                low = mid+1;
            }else{
                return mid;
            }
        }

        return -1; // if there is error
    }

}