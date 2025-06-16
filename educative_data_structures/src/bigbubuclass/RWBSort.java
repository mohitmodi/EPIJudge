package bigbubuclass;

public class RWBSort {

    public static void main(String[] args) {
        char arr[] = new char[]{'b','r', 'w', 'b', 'b', 'w', 'r', 'w','r','r','r','b'};
        System.out.println(sort(arr));
    }

    private static char[] sort(char[] arr) {

        int end = arr.length - 1;
        while (arr[end] == 'b') {
            end = end - 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'b' && end > i) {
                char temp = arr[i];
                arr[i] = arr[end];
                arr[end] = temp;
                end = end - 1;
            }
        }
        while (arr[end] == 'w') {
            end = end - 1;
        }
        for (int i = 0; i < end; i++) {
            if (arr[i] == 'w') {
                char temp = arr[i];
                arr[i] = arr[end];
                arr[end] = temp;
                end = end - 1;
            }
        }
        return arr;
    }
}
