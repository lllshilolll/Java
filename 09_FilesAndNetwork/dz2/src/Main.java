import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //ввод адреса в консоль
        //1
        Scanner in = new Scanner(System.in);
        System.out.print("Введите путь до папки: ");
        String mainFolder = in.nextLine();
        //2
        Scanner in2 = new Scanner(System.in);
        System.out.print("Введите путь до копируемой папки: ");
        String copyFolder = in.nextLine();

        File sourceFile = new File(String.valueOf(Paths.get(copyFolder)));
        File destFile = new File(String.valueOf(Paths.get(mainFolder)));
        //Если путь к кпируемой папке не существует
        if (!sourceFile.exists()) {
            //Каталог не существует.
            System.out.println("Directory does not exist.");
            System.exit(0);
        //иначе
        } else {

            try {
                copyFolder(sourceFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }

        System.out.println("Done");
    }

    public static void copyFolder(File src, File dest)
            throws IOException {
        //если копируемая папка = папка
        if (src.isDirectory()) {

            //если конечная папка не существует
            if (!dest.exists()) {
                //создать эту папку
                dest.mkdir();
                System.out.println("Directory copied from "
                        + src + "  to " + dest);
            }

            //перечислить все содержимое копируемой папки
            String files[] = src.list();

            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                copyFolder(srcFile, destFile);
            }
        //иначе
        } else {
            //если копируется не папка, а файл
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }
    }
}
/**
 * Files.walk(sourcepath)
 * .forEach(source -> {
 * try {
 * copy(source, destinationepath.resolve(sourcepath.relativize(source)));
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * });
 * }
 * static void copy(Path source, Path dest) throws Exception {
 * Files.copy(source, dest, StandardCopyOption.COPY_ATTRIBUTES);
 * <p>
 * }
 * }
 * План:
 * 1. Ввод папки в которую копируется папка
 * 2. Ввод копируемой папки
 * 3. Клонирование папки и ее файлов и папок
 */
/**
 * План:
 * 1. Ввод папки в которую копируется папка
 * 2. Ввод копируемой папки
 * 3. Клонирование папки и ее файлов и папок
 */


