import java.io.File;
import java.util.Objects;

public class Main {
    private static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\Mariya\\Desktop\\src";
        String dstFolder = "C:\\Users\\Mariya\\Desktop\\dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();
        //listFiles - Возвращает массив абстрактных путей, обозначающих файлы в каталоге,
        // обозначенном этим абстрактным путем.
        File[] files = srcDir.listFiles();
        //availableProcessors - Возвращает количество процессоров, доступных виртуальной машине Java.
        int step =  Runtime.getRuntime().availableProcessors();
        if (step >= files.length)
        {
            for (File file : files) {
                File[] f = new File[1];
                f[0] = file;
                ImageResizer resizer = new ImageResizer(f, newWidth, dstFolder, start);
                new Thread(resizer).start();
            }
            return;
        }
        int fileInStep = files.length / step;
        for (int i = 0; i < step - 1; i++)
        {
            File[] f = new File[fileInStep];
            System.arraycopy(files, i * fileInStep, f, 0, f.length);
            new ImageResizer(f, newWidth, dstFolder, start).start();
        }
        int remainder = files.length - (step - 1) * fileInStep;
        File[] f = new File[remainder];
        System.arraycopy(files, files.length - remainder, f, 0, f.length);
        new ImageResizer(f, newWidth, dstFolder, start).start();

/**
        int middle = files.length / 2;
        File[] files1 = new File[middle];
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
        new Thread(resizer1).start();
        File[] files2 = new File[files.length - middle];
        System.arraycopy(files, middle, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
        new Thread(resizer2).start();
*/
    }
}
