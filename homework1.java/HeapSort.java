//Сортировка кучей, пирамидальная сортировка

public class HeapSort {

    public static void main(String[] args) {
    int[] array = {22, 5, 1, -4, 0, 43, 15};

    sort(array);

    for (int i = 0; i < array.length; i++)
      System.out.print(array[i] + " ");
  }

    public static void sort(int[] array) {
        //Cоздаём дерево, построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--)
        heapify(array, array.length, i);

        //Делаем сортировку массива, уже отсортированного дерева
        //Извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        } 
    }

    private static void  heapify(int[] array, int size, int rootIndex) {
        int max = rootIndex;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        //Если левый элемент больше max
        if (left < size && array[left] > array[max])
            max = left;

        //Если правый элемент больше max на данный момент
        if (right < size && array[right] > array[max])
            max = right;

        //Если max не самый большой элемент
        if (max != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[max];
            array[max] = temp;

            heapify(array, size, max);
        }   
    } 
}