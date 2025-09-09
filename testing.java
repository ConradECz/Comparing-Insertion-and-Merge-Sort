import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class testing{
    public static void main(String[] args){

        Random random = new Random();



        //
        //INSERTION SORT SECTION
        //



        //insertion sort of 100
        int[] insArray1 = new int[100];

        for(int i=0; i < insArray1.length; i++){
            insArray1[i] = random.nextInt(100);
        }
        long start = System.currentTimeMillis();
        insertionSort(insArray1);
        long end = System.currentTimeMillis();
        writeToFile(insArray1, "insertionSize100.txt", end-start);



        //insertion sort of 1,000
        int[] insArray2 = new int[1000];

        for(int i=0; i < insArray2.length; i++){
            insArray2[i] = random.nextInt(1000);
        }
        start = System.currentTimeMillis();
        insertionSort(insArray2);
        end = System.currentTimeMillis();
        writeToFile(insArray2, "insertionSize1000.txt", end-start);



        //insertion sort of 10,000
        int[] insArray3 = new int[10000];

        for(int i=0; i < insArray3.length; i++){
            insArray3[i] = random.nextInt(10000);
        }
        start = System.currentTimeMillis();
        insertionSort(insArray3);
        end = System.currentTimeMillis();
        writeToFile(insArray3, "insertionSize10000.txt", end-start);



        //insertion sort of 100,000
        int[] insArray4 = new int[100000];

        for(int i=0; i < insArray4.length; i++){
            insArray4[i] = random.nextInt(100000);
        }
        start = System.currentTimeMillis();
        insertionSort(insArray4);
        end = System.currentTimeMillis();
        writeToFile(insArray4, "insertionSize100000.txt", end-start);



        //
        //MERGE SORT SECTION
        //



        //merge sort of 100
        int[] mergeArray1 = new int[100];

        for(int i=0; i < mergeArray1.length; i++){
            mergeArray1[i] = random.nextInt(100);
        }
        start = System.currentTimeMillis();
        mergeSort(mergeArray1);
        end = System.currentTimeMillis();
        writeToFile(mergeArray1, "mergeSize100.txt", end-start);



        //merge sort of 1,000
         int[] mergeArray2 = new int[1000];

        for(int i=0; i < mergeArray2.length; i++){
            mergeArray2[i] = random.nextInt(1000);
        }
        start = System.currentTimeMillis();
        mergeSort(mergeArray2);
        end = System.currentTimeMillis();
        writeToFile(mergeArray2, "mergeSize1000.txt", end-start);



        //merge sort of 10,000
         int[] mergeArray3 = new int[10000];

        for(int i=0; i < mergeArray3.length; i++){
            mergeArray3[i] = random.nextInt(10000);
        }
        start = System.currentTimeMillis();
        mergeSort(mergeArray3);
        end = System.currentTimeMillis();
        writeToFile(mergeArray3, "mergeSize10000.txt", end-start);



        //merge sort of 100,000
         int[] mergeArray4 = new int[100000];

        for(int i=0; i < mergeArray4.length; i++){
            mergeArray4[i] = random.nextInt(100000);
        }
        start = System.currentTimeMillis();
        mergeSort(mergeArray4);
        end = System.currentTimeMillis();
        writeToFile(mergeArray4, "mergeSize100000.txt", end-start);


        System.out.println("All sorted arrays written to text files.");
    }


    //declaring the insertionSort function
    private static void insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int temp = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > temp){
                array[j + 1]= array[j];
                j--;
            }

            array[j + 1] = temp;

        }
    }

    //declaring the mergeSort function
    private static void mergeSort(int[] array) {
		
		int length = array.length;
		if (length <= 1) return; //base case
		
		int middle = length / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];
		
		int i = 0; //left-most side of the array
		int j = 0; //right-most side of the array
		
		for(; i < length; i++) {
			if(i < middle) {
				leftArray[i] = array[i];
			}
			else {
				rightArray[j] = array[i];
				j++;
			}
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, array);
	}
	
	private static void merge(int[] leftArray, int[] rightArray, int[] array) {
		
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
		int i = 0, l = 0, r = 0; //indices
		
		//conditions for merging
		while(l < leftSize && r < rightSize) {
			if(leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				i++;
				l++;
			}
			else {
				array[i] = rightArray[r];
				i++;
				r++;
			}
		}
		while(l < leftSize) {
			array[i] = leftArray[l];
			i++;
			l++;
		}
		while(r < rightSize) {
			array[i] = rightArray[r];
			i++;
			r++;
		}
	}

    //fuction in order to separate each array size into their own text file with runtime
    private static void writeToFile(int[] array, String filename, long runtimeMs) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Runtime: " + runtimeMs + " ms\n");
            for (int num : array) {
                writer.write(num + "\n");
            }
            System.out.println(filename + " (runtime: " + runtimeMs + " ms)");
        } catch (IOException e) {
            System.out.println("Error writing to " + filename + ": " + e.getMessage());
        }
    }
}