package barr;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrintOnBalanceSetAspectTest {
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
    void printsOnDeposit() {
        Account acc = new Account("ABC123", 1, 100.0);
        acc.deposit(50.0);

        String printed = out.toString();
        assertTrue(
                printed.contains("[AOP] Balance changed by 50.0 on acc 1, new bal=150.0"),
                "Expected AOP print after deposit, but got: " + printed);
    }

    @Test
    void printsOnWithdraw() {
        Account acc = new Account("ABC123", 2, 200.0);
        acc.withdraw(30.0);

        String printed = out.toString();
        assertTrue(
                printed.contains("[AOP] Balance changed by 30.0 on acc 2, new bal=170.0"),
                "Expected AOP print after withdraw, but got: " + printed);
    }
}
