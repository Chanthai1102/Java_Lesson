package GUIScanner;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;

public class ScannerFile {
    private JFrame frame;
    private JTextArea textArea;
    private JDialog loadingDialog;
    private JProgressBar progressBar;
    private File outputDirectory;

    public ScannerFile() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame("File Scanner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null); // Center the frame

        JPanel mainPanel = new JPanel(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10)); // Add padding

        JButton browseButton = new JButton("Browse");
        browseButton.addActionListener(e -> browseDirectory());
        buttonPanel.add(browseButton);

        JButton scanButton = new JButton("Scan Files");
        scanButton.addActionListener(e -> scanFiles());
        buttonPanel.add(scanButton);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void browseDirectory() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int option = fileChooser.showOpenDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            textArea.setText("Selected Directory: " + selectedDirectory.getAbsolutePath());
        }
    }

    private void scanFiles() {
        String directoryPath = textArea.getText().replace("Selected Directory: ", "");
        if (!directoryPath.isEmpty()) {
            File mainDirectory = new File(directoryPath);

            if (mainDirectory.isDirectory()) {
                textArea.append("\n\nScanning...\n"); // Add a separator and status message

                loadingDialog = new JDialog(frame, "Scanning", Dialog.ModalityType.APPLICATION_MODAL);
                loadingDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                loadingDialog.setLayout(new BorderLayout());

                progressBar = new JProgressBar();
                progressBar.setStringPainted(true);
                loadingDialog.add(progressBar, BorderLayout.CENTER);

                loadingDialog.setSize(300, 100);
                loadingDialog.setLocationRelativeTo(frame);

                SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        File[] files = mainDirectory.listFiles();
                        int totalFiles = files != null ? files.length : 0;

                        for (int i = 0; i < totalFiles; i++) {
                            // Simulate scanning by sleeping for a short duration
                            Thread.sleep(100);
                            int progress = (int) ((i / (float) totalFiles) * 100);
                            publish(progress);
                        }
                        return null;
                    }

                    @Override
                    protected void process(List<Integer> chunks) {
                        if (!chunks.isEmpty()) {
                            int progress = chunks.get(chunks.size() - 1);
                            progressBar.setValue(progress);
                            progressBar.setString(progress + "%");
                        }
                    }

                    @Override
                    protected void done() {
                        loadingDialog.dispose();
                    }
                };
                worker.execute();

                loadingDialog.setVisible(true);
            } else {
                textArea.setText("Not a directory or directory does not exist: " + directoryPath);
            }
        } else {
            textArea.setText("Please select a directory first using the Browse button.");
        }
    }

    private void saveFilePaths(File directory) {
        File outputFile = new File("file_paths.txt");

        try (FileWriter writer = new FileWriter(outputFile)) {
            listFiles(directory, writer);
            textArea.append("File paths saved to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            textArea.append("Error occurred while saving file paths.");
        }
    }

    private void listFiles(File directory, FileWriter writer) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    writer.write(file.getAbsolutePath() + "\n");
                } else if (file.isDirectory()) {
                    listFiles(file, writer);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScannerFile::new);
    }
}
