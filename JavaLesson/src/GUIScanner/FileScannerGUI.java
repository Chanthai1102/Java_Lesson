package GUIScanner;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileScannerGUI {
    private JFrame frame;
    private JTextArea textArea;
    private JDialog loadingDialog;
    private File outputDirectory;

    public FileScannerGUI() {
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

        JButton outputButton = new JButton("Choose Output Directory");
        outputButton.addActionListener(e -> chooseOutputDirectory());
        buttonPanel.add(outputButton);


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

                JLabel loadingLabel = new JLabel("Scanning files, please wait...", SwingConstants.CENTER);
                loadingDialog.add(loadingLabel);
                loadingDialog.setSize(300, 100);
                loadingDialog.setLocationRelativeTo(frame);

                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        saveFilePaths(mainDirectory);
                        return null;
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

    private void chooseOutputDirectory() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int option = fileChooser.showSaveDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            outputDirectory = fileChooser.getSelectedFile();
            textArea.append("\nOutput Directory: " + outputDirectory.getAbsolutePath());
        }
    }

    private void saveFilePaths(File directory) {
        if (outputDirectory == null) {
            textArea.append("\nPlease choose an output directory before scanning.");
            return;
        }

        File outputFile = new File(outputDirectory, "file_paths.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            listFiles(directory, writer);
            textArea.append("\nFile paths saved to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            textArea.append("\nError occurred while saving file paths: " + e.getMessage());
        }
    }

    private void listFiles(File directory, PrintWriter writer) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    writer.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    listFiles(file, writer);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileScannerGUI::new);
    }
}

