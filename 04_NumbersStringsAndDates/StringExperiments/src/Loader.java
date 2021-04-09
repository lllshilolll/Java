import java.lang.*;
public class Loader
{
    public static void main(String[] args) {
        //indexOf() - индекс символа или подстроки,
        // lastIndexOf() -  индекс последнего вхождения,
        // substring() - извлечение символа и подстроки,
        // trim() - строка без начальных и конечных пробелов.

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        String[] a = text.split(",");//разбиваем друзей на элементы массива
        String[] b = new String[a.length];//создаем пустой массив
        int j = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++){//a.length - кол-во элементов массива
            b[j] = a[i].replaceAll("[^0-9]", "");//у каждого элемента оставляем только цифры
            sum = sum + Integer.parseInt (b[j]);//переводим строки в числа и суммируем
            j++;
            }
        System.out.println(sum);
        }
        }


    /**System.out.println(text);

        String firstStr = text.substring(text.indexOf("Вася заработал")+14, text.indexOf("руб")).trim();
        String lastStr = text.substring(text.indexOf("Маша") +6, text.lastIndexOf("руб")).trim();
        String middleStr = text.substring(text.indexOf(", Петя")+7, text.lastIndexOf("рубля, a")).trim();
        //String a = middleStr.substring(0, middleStr.lastIndexOf("руб")).trim();
        System.out.println(middleStr);
       int sum = Integer.parseInt(firstStr) + Integer.parseInt(lastStr);// + Integer.parseInt(middleStr);
       System.out.println(sum);*/
