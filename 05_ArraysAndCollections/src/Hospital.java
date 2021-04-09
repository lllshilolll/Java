public class Hospital {
    public static void main(String[] args) {
        final int PEOPLE = 30;
        final float MAX_TEMP = 40.0F;
        final float MIN_TEMP = 32.0F;
        final float MAX_HEALTHY_TEMP = 36.9F;
        final float MIN_HEALTHY_TEMP = 36.2F;
        /**
         количество здоровых пациентов (с температурой от 36,2 до 36,9), а также температуры всех пациентов.*/
        //массив с температурами 30 пациентов (от 32 до 40 градусов).
        float [] temperature = new float[PEOPLE];
        float sum =0;
        for (int i = 0; i < temperature.length; i++){
            temperature[i] =  (float) Math.random() * (MAX_TEMP - MIN_TEMP) + MIN_TEMP;
            sum += temperature[i]; }
        //средняя температура по больнице
        float average_temp = sum / PEOPLE;
        System.out.println("Средняя температура по больнице: " + average_temp);
        //количество здоровых пациентов (с температурой от 36,2 до 36,9)
        int numberHealthyPeople = 0;
        for (int i = 0; i< temperature.length; i++){
            if (temperature[i] >= MIN_HEALTHY_TEMP && temperature[i] <= MAX_HEALTHY_TEMP){
                numberHealthyPeople += 1;
            }
        }
        System.out.println("Количество здоровых пациентов: " + numberHealthyPeople);
        System.out.println("Температура " + PEOPLE + " пациентов по больнице равна: ");
        for (float patients : temperature){
            System.out.print(patients + " ");
        }

    }

}
