import java.util.Random;

public class QuickSort {

    //    make an array called sample of type int
    int[] samples;
    //    make a variable called dataSize array size
    int dataSize;

    // Constructor initializes all the global variables
    public QuickSort() {
//        variable for maximum data size for array
        int dataMaxSize = 25;
//        variable for minimum data size for array
        int dataMinSize = 15;

//        make a new Random object
        Random random = new Random();
//        get a random integer between the min and max numbers and put the number into dataSize
        dataSize = random.nextInt(dataMaxSize - dataMinSize) + dataMinSize;

//        set array size to dataSize
        samples = new int[dataSize];
    }

    //    make a method to fill the empty array with numbers
    private void fillArray() {
//        integer variable that sets the upper and lower limits for the random numbers to be generated
        int lowerLim = 10;
        int upperLim = 99;

//        for loop to loop through the array and fill it with random numbers
        for (int i = 0; i < samples.length; i++) {
//            make a new Random object
            Random random = new Random();
//            insert new random number into each array position
//            generate the new random number in each iteration considering the upper and lower limit
            samples[i] = random.nextInt(upperLim - lowerLim) + lowerLim;
        }
    }

    //    method to print every position in the array in a single line
    private void printArray() {
//        loop through the array
        for (int sample : samples) {
//            print out each array position with a space after it
            System.out.print(sample + " ");
        }
//        after the loop is done then print out a empty return for the next print out statement to start on a new line
        System.out.print("\n");
    }

    //    method to call the other methods and print out each part
    private void printAnswers() {
//        prints out the sample size length
        System.out.println("Sample Size: " + samples.length);
        System.out.print("\n");
        System.out.println("Array elements:");
//        calls printArray to print out the entire array in one line with a return after it
        printArray();

        System.out.print("\n");

        System.out.println("Sorting ...");

//        call quickSort method
        quickSort(samples, 0, samples.length - 1);


        System.out.println(" ");
        System.out.println("Sorted:");
//        print out the new array and show that it is sorted
        printArray();
    }


    //    one method to swap
    private void swap(int[] samples, int leftIndex, int last) {
//        make a temporary variable to store the leftIndex position of sample array
        int temp = samples[leftIndex];

//        make the position of array leftIndex be equal to the value stored in array position last
        samples[leftIndex] = samples[last];
//        make array sample in position last be set to the value of temp
        samples[last] = temp;
    }


    // to split the array into partitions
    private int partition(int[] sample, int first, int last) {
        int pivot = sample[last];
        int leftIndex = (first); // index of smaller element

        for (int j = first; j <= last; j++) {
            // If current element is smaller than the pivot
            if (sample[j] < pivot) {
//                calls swap with array, leftIndex, j
                swap(sample, leftIndex, j);
//                increment leftIndex
                leftIndex++;

            }
        }

        // swap left and arr[high] (or pivot)
        swap(sample, leftIndex, last);

        return leftIndex;
    }


    /* The main function that implements quickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private void quickSort(int[] samples, int first, int last) {

        if (first < last) {
            /* pivot is partitioning index, sample[pivot] is
              now at right place */
            int pivot = partition(samples, first, last);


//            print the array after
            printPartition(samples, pivot, first, last);


            // Recursively sort elements before
            // partition and after partition
            quickSort(samples, first, pivot - 1);
            quickSort(samples, pivot + 1, last);
        }

    }

    // to print sorting process
    public static void printPartition(int[] samples, int pivot, int first, int last) {
        for (int i = first; i <= last; i++) {
            if (i == pivot) {
                System.out.print("(" + samples[i] + ") ");

            } else {
                System.out.print(samples[i] + " ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // prints the beginning of the project //
        System.out.println("Martin Hauck - Project 6: Quick Sort");
        System.out.print("\n");

//        make a new object of type HauckMProj6COMP110110 call it quickSort
        QuickSort quickSort = new QuickSort();

//        call method to fill the array with random numbers
        quickSort.fillArray();


//        call method to call the other methods to print the answers needed
        quickSort.printAnswers();


        //printing of the end of the project
        System.out.println("quick Sort");
    }
}

