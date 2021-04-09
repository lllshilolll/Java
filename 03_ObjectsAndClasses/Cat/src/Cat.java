
public class Cat {
    //«количество глаз», «минимальный вес», «максимальный вес».
    public static final int COUNT_EYES = 2;
    public static final int MIN_WEIGHT = 1000;
    public static final int MAX_WEIGHT = 9000;

    public static int count;
    private double originWeight;
    private double weight;
    private String color;
    private String name;
    private double minWeight;
    private double maxWeight;
    private double foodWeight;
    public boolean isAlive;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Deep Copy

    public Cat copy() {
        Cat cat = new Cat();
        cat.weight = this.weight;
        cat.name = this.name;
        cat.foodWeight = this.foodWeight;
        cat.originWeight = this.originWeight;
        return cat;
    }

    public void setColor(String color) {
        this.color = color;
    }
        public String getColor(){
        return color;
    }

    public void viewColorCat(Color type){}

    public boolean isWeightNormal() {
        return (getWeight()> MIN_WEIGHT && getWeight() <MAX_WEIGHT);
    }

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        foodWeight = 0.0;
        isAlive = true;
        count++;
    }
    public Cat (double weight)
    {
        this.weight = weight;
    }

    public static int getCount(){
        return count;
    }

    public void pee(){
        if (isAlive)
            weight = weight - 2;
            System.out.println("Clean up after me!! ");
    }
    public void meow()
    {
        if (isAlive){
            weight = weight - 1;
            System.out.println("Meow");
            if (isWeightNormal()){
                isAlive = true;}
            else {
                isAlive = false;
                count--;
            }
        }
        else {
            System.out.println("Котик не может мяукать :( ");
        }
    }

    public void feed(Double amount)
    {
        if (isAlive)
        {
            foodWeight += amount;
            weight = weight + amount;
            if (isWeightNormal()){
                isAlive = true;}
            else {
                isAlive = false;
                count--;
            }
        }
        else{
            System.out.println("Котик не может кушать :( ");
            }
    }
    public Double getFoodWeight() {return foodWeight;}

    public void drink(Double amount) {
        if (isAlive){
            weight = weight + amount;
            if (isWeightNormal()){
                isAlive = true;}
            else {
                isAlive = false;
                count--;
            }
        }
        else{
            System.out.println("Котик не может пить :( ");
        }

    }

    public Double getWeight() { return weight; }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}
