package Sort;

import java.util.*;

public class main {

    // ----------------------- Bubble Sort -----------------------
    public static void bubbleSortSteps(int[] arr) {
        int n = arr.length;
        System.out.println("Proses Bubble Sort:");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }

    // ----------------------- Selection Sort -----------------------
    public static void selectionSortSteps(int[] arr) {
        int n = arr.length;
        System.out.println("Proses Selection Sort:");
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // tukar bila perlu
            if (minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    // ----------------------- Insertion Sort (LinkedList) -----------------------
    public static void insertionSortLinkedListSteps(LinkedList<Integer> list) {
        System.out.println("Proses Insertion Sort (LinkedList):");
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                j--;
            }
            list.remove(i);
            list.add(j + 1, key);
            System.out.println(list);
        }
    }

    // ----------------------- Helper: Generate Random Array -----------------------
    public static int[] generateRandomArray(int size, int maxVal) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(maxVal);
        }
        return arr;
    }

    // ----------------------- Helper: Convert to LinkedList -----------------------
    public static LinkedList<Integer> toLinkedList(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int x : arr) {
            list.add(x);
        }
        return list;
    }

    // ----------------------- Benchmark -----------------------
    public static void benchmarkSorting() {
        int size = 100000;
        int maxVal = 1000000;
        int[] arrOriginal = generateRandomArray(size, maxVal);

        // Bubble Sort
        int[] arr1 = Arrays.copyOf(arrOriginal, arrOriginal.length);
        long start = System.currentTimeMillis();
        bubbleSortSteps(arr1); // <- untuk 100k data akan sangat berat jika print
        long end = System.currentTimeMillis();
        System.out.println("Bubble Sort waktu: " + (end - start) + " ms");

        // Selection Sort
        int[] arr2 = Arrays.copyOf(arrOriginal, arrOriginal.length);
        start = System.currentTimeMillis();
        selectionSortSteps(arr2); // <- juga sangat berat kalau print semua
        end = System.currentTimeMillis();
        System.out.println("Selection Sort waktu: " + (end - start) + " ms");

        // Insertion Sort (LinkedList)
        LinkedList<Integer> list = toLinkedList(arrOriginal);
        start = System.currentTimeMillis();
        insertionSortLinkedListSteps(list);
        end = System.currentTimeMillis();
        System.out.println("Insertion Sort (LinkedList) waktu: " + (end - start) + " ms");
    }

    // ----------------------- Demo 10 angka -----------------------
    public static void demo10Numbers() {
        int[] arr = generateRandomArray(10, 100);
        System.out.println("Data awal (10 bilangan acak): " + Arrays.toString(arr));

        int[] arr1 = Arrays.copyOf(arr, arr.length);
        bubbleSortSteps(arr1);

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        selectionSortSteps(arr2);

        LinkedList<Integer> list = toLinkedList(arr);
        insertionSortLinkedListSteps(list);
    }

    // ----------------------- Main Menu -----------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== MENU SORTING =====");
            System.out.println("1. Demo 10 Bilangan Acak (dengan langkah)");
            System.out.println("2. Benchmark 100000 Bilangan Acak (waktu saja)");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    demo10Numbers();
                    break;
                case 2:
                    benchmarkSorting();
                    break;
                case 3:
                    System.out.println("Program selesai.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
