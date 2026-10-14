import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import student.TestCase;

public class MainTest extends TestCase {
    public void testMainStartsAndExits() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream("4\n9\n".getBytes()));
            System.setOut(new PrintStream(output));
            Main.main(new String[0]);
        }
        finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
        assertTrue(output.toString().contains("Nude"));
        assertTrue(output.toString().contains("Teardrop"));
        assertTrue(output.toString().contains("Goodbye."));
    }
    /** An invalid option is rejected and the program can still exit. */
    public void testMainRejectsInvalidOptionAndExits() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream("invalid\n99\n9\n".getBytes()));
            System.setOut(new PrintStream(output));
            Main.main(new String[0]);
        }
        finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
        assertTrue(output.toString().contains("Invalid option."));
        assertTrue(output.toString().contains("Goodbye."));
    }


}
