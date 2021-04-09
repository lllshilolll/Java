import java.util.Scanner;
public class Distributor {
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите количество количество ящиков");
            int box = scanner.nextInt();

            Truck truck = new Truck(box);
            truck.result();
            System.out.println("Необходимо: ");
            System.out.println("грузовиков -  " + truck.getTruck() + " шт.");
            System.out.println("контейнеров - " + truck.getContainer() + " шт.");
        }
    }


    class Truck
    {
        private int truck;//грузовие
        private int container;//контейнер
        private int box;//ящик

        public Truck (int box)
        {
            this.box = box;
            if (box != 0) //если кол-во ящиков не равно 0:
            {
                container = box % 27 == 0 ? box / 27 : box / 27 + 1;
            }
            if (container != 0) //если кол-во контейнеров не равно 0:
            {
                truck = container % 12 == 0 ? container / 12 : container / 12 + 1;
            }
        }
        public int getTruck()//геттер грузовиков
        {
            return truck;
        }
        public int getContainer()//геттер контейнеров
        {
            return container;
        }
        public void result()
        {
            int b = 1;
            int c = 1;
            for (int i = 1; i <= truck; i++)// с 1 по кол-во грузовиков:
            {
                System.out.println("Грузовик " + i + ":");
                int j = 0;
                while (j < 12 && c <= container)//пока кол-во контейнеров меньше 12 и контейнеры еще не закончились
                {
                    System.out.println("Контейнер " + c + ":");
                    int k = 0;
                    while (k < 27 && b <= box)//пока кол-во ящиков меньше 27 и ящики еще не ззакончились
                    {
                        System.out.println("    Ящик" + b);
                        k++;
                        b++;
                    }
                    j++;
                    c++;
                    System.out.println();
                }
            }
        }
    }
