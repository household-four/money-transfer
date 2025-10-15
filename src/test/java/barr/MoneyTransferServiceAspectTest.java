package barr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTransferServiceAspectTest {

    @Test
    void moneyTransferServiceAspectTest() {
        Account from = new Account("A", 1, 1000.0);
        Account to = new Account("B", 2, 0.0);
        MoneyTransferService svc = new MoneyTransferService();

        svc.moneyTransfer(from, to, 100.0);

        assertEquals(900.0, from.getBalance(), 1e-9, "source account should be debited exactly 100");
        assertEquals(200.0, to.getBalance(), 1e-9, "destination account should receive double (200)");
    }
}
