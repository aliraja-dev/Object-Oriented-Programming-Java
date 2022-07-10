public class LargestValue {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int largest = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        System.out.println("Largest value in array is " + largest);
        int indexOfLargest = largestIndex(array);
        System.out.println("Index of largest value in array is " + indexOfLargest);

    }

    private static int largestIndex(int[] a) {
        int largestIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[largestIndex]) {
                largestIndex = i;
            }
        }

        return largestIndex;
    }
}
