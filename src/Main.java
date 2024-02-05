import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select One Option:\n1.Message Encryption\n2.Message Decryption");
        boolean istrue=false;
        while (!istrue){
            int Option=scanner.nextInt();
            switch (Option) {
                case 1 -> {
                    encryption();
                    istrue = true;
                }
                case 2 -> {
                    decryption();
                    istrue = true;
                }
                default -> System.out.println("Please Enter The Right Option");
            }
        }

        }
    private static void encryption() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a message to encrypt: ");
        String message=scanner.nextLine();

        System.out.print("Enter the key value for the message: ");

        int key=scanner.nextInt();
        message=message.toLowerCase();
        for (int i = 0; i < message.length(); i++) {
            char c=message.charAt(i);
            if (Character.isLetter(c)){
                c= (char) ((c-'a' + key + 26) % 26 + 'a');
                System.out.print(c);
            }

        }

    }

    private static void decryption() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a message to decrypt: ");
        String message=scanner.nextLine();

        System.out.print("Enter the key value for the message: ");
        int key=scanner.nextInt();
        message=message.toLowerCase();
        for (int i = 0; i < message.length(); i++) {
            char c=message.charAt(i);
            if (Character.isLetter(c)){
                c=(char) ((c - 'a' - key + 26) % 26 + 'a');
                System.out.print(c);
            }

        }
    }


}
