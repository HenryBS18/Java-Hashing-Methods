import java.security.MessageDigest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256_Method {
    public static void main(String[] args) {
        String input = "Henry";

        Scanner scan = new Scanner(System.in);

        try {
            try {
                // You can use MD5 (32), SHA-1 (40), SHA-256 (64), SHA-384 (96), or SHA-512 (128).
                MessageDigest digest = MessageDigest.getInstance("SHA-384");
                byte[] hash = digest.digest(input.getBytes("UTF-8"));

                String pass;

                StringBuilder hexString = new StringBuilder();

                for (byte b : hash) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1)
                        hexString.append('0');
                    hexString.append(hex);
                }

                do {
                    System.out.print("Enter Password : ");
                    pass = scan.nextLine();

                    MessageDigest digest2 = MessageDigest.getInstance("SHA-256");
                    byte[] hash2 = digest2.digest(pass.getBytes("UTF-8"));

                    StringBuilder hexString2 = new StringBuilder();

                    for (byte b : hash2) {
                        String hex = Integer.toHexString(0xff & b);
                        if (hex.length() == 1)
                            hexString2.append('0');
                        hexString2.append(hex);
                    }

                    if (hexString2.toString().equals(hexString.toString())) {
                        System.out.println("Password Correct");
                        return;
                    } else {
                        System.out.println("Password Incorrect");
                    }

                    System.out.println("Hash: " + hexString.toString());
                    System.out.println("Length: " + hexString.length());
                    System.out.println();
                } while (!pass.equals(hexString.toString()));
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } finally {
            scan.close();
        }
    }
}
