import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String originalMessage = scanner.nextLine();

        System.out.print("Enter the shift value: ");
        int shift = scanner.nextInt();

        System.out.print("Choose an operation (1 for encryption, 2 for decryption): ");
        int operation = scanner.nextInt();

        String resultMessage;

        switch (operation) {
            case 1 -> {
                resultMessage = encrypt(originalMessage, shift);
                System.out.println("Encrypted message: " + resultMessage);
            }
            case 2 -> {
                resultMessage = decrypt(originalMessage, shift);
                System.out.println("Decrypted message: " + resultMessage);
            }
            default -> System.out.println("Invalid operation. Please choose 1 for encryption or 2 for decryption.");
        }

        scanner.close();
    }

    public static String encrypt(String message, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';

                int relativePosition = character - base;
                int shiftedPosition = relativePosition + shift + 26;
                int positionShift = shiftedPosition % 26;

                char newCharacter = (char) (base + positionShift);

                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static String decrypt(String encryptedMessage, int shift) {
        return encrypt(encryptedMessage, -shift);
    }
}
