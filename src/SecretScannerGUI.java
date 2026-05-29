import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecretScannerGUI extends JFrame {

    private JTextArea inputArea;
    private JTextArea resultArea;
    private JButton scanButton;

    public SecretScannerGUI() {

        setTitle("CF03 - Secret Key Scanner");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        inputArea = new JTextArea();
        inputArea.setFont(new Font("Arial", Font.PLAIN, 15));
        inputArea.setBorder(
                BorderFactory.createTitledBorder("Nhập source code hoặc API Key")
        );

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.BOLD, 15));
        resultArea.setForeground(Color.RED);
        resultArea.setBorder(
                BorderFactory.createTitledBorder("Kết quả quét")
        );

        scanButton = new JButton("Quét Secret Key");

        scanButton.addActionListener(e -> {

            String content = inputArea.getText();

            Pattern pattern = Pattern.compile("sk_[A-Za-z0-9_]+");

            Matcher matcher = pattern.matcher(content);

            StringBuilder result = new StringBuilder();

            boolean found = false;

            while (matcher.find()) {

                if (!found) {

                    result.append("[CẢNH BÁO] Phát hiện Secret Key!\n\n");
                    found = true;
                }

                result.append("Key tìm thấy: ")
                        .append(matcher.group())
                        .append("\n");
            }

            if (!found) {

                result.append("Không phát hiện Secret Key.");
            }

            resultArea.setText(result.toString());
        });

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(inputArea),
                new JScrollPane(resultArea)
        );

        splitPane.setDividerLocation(220);

        panel.add(splitPane, BorderLayout.CENTER);
        panel.add(scanButton, BorderLayout.SOUTH);

        add(panel);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new SecretScannerGUI().setVisible(true)
        );
    }
}