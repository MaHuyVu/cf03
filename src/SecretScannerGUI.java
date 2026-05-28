import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        // Ô nhập dữ liệu
        inputArea = new JTextArea();
        inputArea.setFont(new Font("Arial", Font.PLAIN, 16));
        inputArea.setBorder(
                BorderFactory.createTitledBorder("Nhập source code hoặc API Key")
        );

        // Ô kết quả
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.BOLD, 16));
        resultArea.setForeground(Color.RED);
        resultArea.setBorder(
                BorderFactory.createTitledBorder("Kết quả quét")
        );

        // Nút quét
        scanButton = new JButton("Quét Secret Key");
        scanButton.setFont(new Font("Arial", Font.BOLD, 16));

        scanButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String content = inputArea.getText();

                // Regex tìm secret key
                Pattern pattern = Pattern.compile("sk_[A-Za-z0-9_]+");

                Matcher matcher = pattern.matcher(content);

                boolean found = false;

                StringBuilder result = new StringBuilder();

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

                    result.append("Không phát hiện secret.");
                }

                resultArea.setText(result.toString());
            }
        });

        // Chia giao diện trên/dưới
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

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new SecretScannerGUI().setVisible(true);
            }
        });
    }
}