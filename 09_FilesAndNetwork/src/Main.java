import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите путь до папки: ");
        String way = in.nextLine();
        File folder = new File(way);

        //long sizeByte = getFolderSize(folder);
        //определение единицы измерения, через округлние  десятичного логорифма
        String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        long sizeByte = Files.walk(Paths.get(way))
                .map(Path::toFile)
                .filter(File::isFile)
                .mapToLong(File::length)
                .sum();
        int unitIndex = (int) (Math.log10(sizeByte) / 3);
        double readableSize = 0;
        //если число меньше 1024: представляем в байтач
        if (sizeByte < 1024) {
            readableSize = sizeByte;//б
        }
        //если  от деления меньше 1024: представляем в кб
        else if (sizeByte / 1024 <= 1024) {
            readableSize = (double) sizeByte / 1024;//кб
            //если  от деления меньше 1024*1024: представляем в мб
        } else if (sizeByte / (1024 * 1024) <= 1024) {
            readableSize = (double) sizeByte / (1024 * 1024);//мб
            //если  от деления меньше 1024*1024*1024: представляем в гб
        } else if (sizeByte / (1024 * 1024 * 1024) <= 1024) {
            readableSize = (double) sizeByte / (1024 * 1024 * 1024);//гб
        }
        System.out.println(String.format("%.1f", readableSize) + units[unitIndex]);
    }

    /**public static long getFolderSize(File folder) {
     long sum = 0;
     File files[] = folder.listFiles();
     //кол-во файлов в указанной папке
     int sizeFolder = files.length;
     for (int i = 0; i < sizeFolder; i++) {
     //если внутри указанной папки попался файл - считать его размер
     if (files[i].isFile()) {
     sum += files[i].length();
     }
     //иначе внутри указана папка, надо посчитать ее размер
     else {
     sum += getFolderSize(files[i]);
     }
     }
     return sum;
     }*/
}