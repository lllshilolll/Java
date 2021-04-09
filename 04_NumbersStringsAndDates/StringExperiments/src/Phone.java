import java.util.Scanner;

public class Phone {
    public static void main(String[] args) {
        Scanner phone = new Scanner (System.in);
        String phoneNumber = phone.nextLine();
        phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
        if (phoneNumber.charAt(0) == '7' && phoneNumber.length() == 11 ){
            System.out.println(phoneNumber);
            }
        else if (phoneNumber.charAt(0) == '8' && phoneNumber.length() == 11){
            phoneNumber = phoneNumber.replace(phoneNumber.charAt(0), '7');
            System.out.println(phoneNumber); }
        else if(phoneNumber.charAt(0) == '9' && phoneNumber.length() == 10){
            phoneNumber = '7' + phoneNumber;
            System.out.println(phoneNumber);}
        else{
            System.out.println("Формат номера неверный!");
        }
    }}

