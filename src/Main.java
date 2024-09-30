import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = createArray();

        selectionSort(array);

        writeArray(array);
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


}