import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecretScanner {

    public static void scanFile(String filename) {

        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = br.readLine()) != null) {

                content.append(line).append("\n");
            }

        } catch (IOException e) {

            System.out.println("Không thể đọc file.");
            return;
        }

        Pattern pattern = Pattern.compile("sk_[A-Za-z0-9_]+");

        Matcher matcher = pattern.matcher(content.toString());

        boolean found = false;

        while (matcher.find()) {

            if (!found) {

                System.out.println("\n[CẢNH BÁO] Phát hiện Secret Key!");
                found = true;
            }

            System.out.println("Key tìm thấy: " + matcher.group());
        }

        if (!found) {

            System.out.println("\nKhông phát hiện Secret Key.");
        }
    }
}