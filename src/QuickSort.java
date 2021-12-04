public class QuickSort
{
    public int counter = 0;
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int low, int high)
    {

        int temp2 = arr[low];
        arr[low] = arr[(high+low)/2];
        arr[(high+low)/2] = temp2;

        int pivot = arr[low];
        int j = (low); // index of smaller element
        for (int i=low+1; i<=high; i++)
        {
            // If current element is smaller than or
            // equal to pivot
            counter++;
            if (arr[i] <= pivot)
            {
                j++;

                // swap arr[i] and arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        return j;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {

        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {1,2,3,4,5,1,2,3,4};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
        System.out.println(ob.counter);
    }
}