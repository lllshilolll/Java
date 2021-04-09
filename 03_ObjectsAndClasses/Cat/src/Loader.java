
public class Loader
{
    public static void main(String[] args) {

         /**Cat vasya = new Cat();
        Cat musy = new Cat(1500.0);
        System.out.println("Cat has " + Cat.COUNT_EYES + " eyes.");
        System.out.println("Cat can weigh at least " + Cat.MIN_WEIGHT + " g.");
        System.out.println("Cat can weigh a maximum " + Cat.MAX_WEIGHT + " g.");
        musy.viewColorCat(Color.ORANGE_COLOR);

        Cat homa = getKitten();
        Cat barsyk = getKitten();
        Cat persyk = getKitten();
        System.out.println("Kitten Homa weight: " + homa.getWeight());
        System.out.println("Kitten Barsyk weight: " + barsyk.getWeight());
        System.out.println("Kitten Persyk weight: " + persyk.getWeight());

        murka.setColor("Orange");
        System.out.println(murka.getColor());*/

         Cat murka = new Cat();
        System.out.println(murka.getWeight());
        Cat copyCat = murka.copy();
        System.out.println(copyCat.getWeight());
    }

        private static Cat getKitten()
        {
            Cat kitten = new Cat(1100.0);
            return kitten;
        }


        /**
        System.out.println("Cats: ");
        System.out.println("Musy weight: " + musy.getWeight());
        System.out.println("Barsyk weight: " + barsyk.getWeight());
        System.out.println("Persyk weight: " + persyk.getWeight());
        System.out.println("Murka weight: " + murka.getWeight());
        System.out.println("Vasya weight: " + vasya.getWeight());
        System.out.println("==================================");

        murka.feed(5.0);
        murka.feed(4.0);
        System.out.println("Murka ate: " + murka.getFoodWeight() + " g.");
        System.out.println("==================================");
        vasya.pee();
        System.out.println("Vasya weight after a toilet: " + vasya.getWeight());*/

        /**
        double maxWeight = 9000.0;
        double minWeight = 1000.0;

        while (vasya.getWeight() > minWeight){
            vasya.meow();
        }
        System.out.println("Vasya weight after meow: " + vasya.getWeight());
        System.out.println("Vasya status: " + vasya.getStatus());*/
    }
