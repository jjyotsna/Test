import java.io.*;

public class FileReversal {

    // Method to reverse file content
    public void reverseFileContents(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String reversedLine = new StringBuilder(line).reverse().toString();
            writer.write(reversedLine);
            writer.newLine();
        }

        // Close resources
        reader.close();
        writer.close();
    }

    public void processFiles(String inputFilePath, String outputFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            reverseFileContents(reader, writer);
        }
    }

}
