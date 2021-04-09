import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //универсальный способ реверса массива
        String text = "Каждый охотник желает знать, где сидит фазан.";
        String[] array = text.replaceAll("[,.]", "").split(" ");
        int size = array.length;
        for (int i = 0; i < size / 2; i++) {
            String  temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
