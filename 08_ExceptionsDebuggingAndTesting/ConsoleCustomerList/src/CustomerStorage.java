import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws WrongFormat {
        String[] components = data.split("\\s+");
        if (components.length != 4) throw new WrongFormat("Wrong format. Correct format: " +
                "add Василий Петров vasily.petrov@gmail.com +79215637722", data);
        String name = components[0] + " " + components[1];
        Pattern pattern = Pattern.compile("^([+]*[0-9]*)$");
        Matcher matcher = pattern.matcher(components[3]);
        if (!((matcher.find()) && (components[3].charAt(0) == '8' && components[3].length() == 11
                || components[3].charAt(0) == '+' && components[3].charAt(1) == '7' && components[3].length() == 12)))
            throw new WrongFormat("Wrong format telephone number. Correct format: \n" +
                    "89658561222 or +79658561222", data);
        Pattern pattern1 = Pattern.compile("^(.*@.*\\..*)$");
        Matcher matcher1 = pattern1.matcher(components[2]);
        if (!(matcher1.find())) throw new WrongFormat("Wrong format email. Correct format:" +
                "vasily.petrov@gmail.com", data);
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}

class WrongFormat extends Exception {
    private String d;
    public String getD() {return d;}

    public WrongFormat(String massage, String data) {
        super(massage);
        d = data;
    }
}