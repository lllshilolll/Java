import java.util.Scanner;

public class Сross {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер крестика");
        int size = scanner.nextInt();
        String [][] x = new String[size][size];

 for (int i = 0; i < x.length; i++){
     for (int j = 0; j< x[i].length; j++){
         if (j == i || j+i == size - 1){
             x [i][j] = "X";}
         else {
             x[i][j] = " ";
             }
         }
     }
        for (int i = 0; i < x.length; i++){
        for (int j = 0; j< x[i].length; j++){
            System.out.print(x[i][j] );
        }
        System.out.println();
    }

    }
}
