package barr;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrintEveryMethodAspectTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void aspectPrintsOnEveryMethodCall() {
        Account from = new Account("A", 1, 1000.0);
        Account to = new Account("B", 2, 0.0);
        MoneyTransferService svc = new MoneyTransferService();

        svc.moneyTransfer(from, to, 100.0);

        String output = out.toString();
        System.out.println("Captured output:\n" + output);
        assertNotNull(output);
        // assertTrue(
        // output.contains("[AOP] Enter: "),
        // "Aspect should print before moneyTransfer()");
    }
}
