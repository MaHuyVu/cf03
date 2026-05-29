import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, String> loadEnv(String filename) {

        Map<String, String> env = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = br.readLine()) != null) {

                if (line.contains("=")) {

                    String[] parts = line.split("=", 2);
                    env.put(parts[0], parts[1]);
                }
            }

        } catch (IOException e) {

            System.out.println("Lỗi đọc file .env");
        }

        return env;
    }

    public static void main(String[] args) {

        System.out.println("=== DEMO LỘ API KEY ===");

        String hardcodedKey = "sk_live_SECRET_123456";

        System.out.println("\n[!] API Key bị hardcode:");
        System.out.println(hardcodedKey);

        Map<String, String> env = loadEnv(".env");

        String secureKey = env.get("API_KEY");

        System.out.println("\n[+] API Key an toàn từ file .env:");
        System.out.println(secureKey);

        System.out.println("\n=== ĐANG CHẠY SECRET SCANNER ===");

        SecretScanner.scanFile("src/Main.java");
    }
}