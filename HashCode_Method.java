import java.util.Scanner;

public class HashCode_Method {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputPass;
        String pass = "Henry";
        int hashedPass = pass.hashCode();

        try {
            do {
                System.out.print("pass: ");
                inputPass = scan.nextLine();

                if (inputPass.hashCode() == hashedPass) {
                    System.out.println("Password Correct");
                } else {
                    System.out.println("Password Incorrect");
                }

                System.out.println("Hashed pass is " + hashedPass);
            } while (inputPass.hashCode() != hashedPass);
        } finally {
            scan.close();
        }
    }
}