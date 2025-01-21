import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FileReversalTest {

    private FileReversal fileReversal;
    private BufferedReader mockReader;
    private BufferedWriter mockWriter;

    @BeforeEach
    void setUp() {
        fileReversal = new FileReversal();
    }

    @Test
    void testReverseFileContent() throws IOException {
        // Create mock BufferedReader and BufferedWriter
        mockReader = mock(BufferedReader.class);
        mockWriter = mock(BufferedWriter.class);

        // Input data and expected reversed content
        String inputContent = "Hello, world!";
        String reversedContent = "!dlrow ,olleH";

        // Mock the behavior of the BufferedReader to return the input data
        when(mockReader.readLine()).thenReturn(inputContent);

        // Call the method to reverse content (using mocked reader and writer)
        fileReversal.reverseFileContent(mockReader, mockWriter);

        // Verify that the content was reversed correctly
        verify(mockWriter).write(reversedContent);
        verify(mockWriter).newLine();
        verify(mockReader).close();
        verify(mockWriter).close();
    }

    @Test
    void testReverseFileContentNoSpace() throws IOException {
        // Create mock BufferedReader and BufferedWriter
        mockReader = mock(BufferedReader.class);
        mockWriter = mock(BufferedWriter.class);

        // Input data and expected reversed content
        String inputContent = "Python";
        String reversedContent = "nohtyP";

        // Mock the behavior of the BufferedReader to return the input data
        when(mockReader.readLine()).thenReturn(inputContent);

        // Call the method to reverse content (using mocked reader and writer)
        fileReversal.reverseFileContent(mockReader, mockWriter);

        // Verify that the content was reversed correctly
        verify(mockWriter).write(reversedContent);
        verify(mockWriter).newLine();
        verify(mockReader).close();
        verify(mockWriter).close();
    }
}
