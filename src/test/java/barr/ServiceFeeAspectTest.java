package barr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ServiceFeeAspectTest {

    @Test
    void fixedServiceFeeCharged() {
        Account a = new Account("A", 1, 1000);
        Account b = new Account("B", 2, 0);
        MoneyTransferService svc = new MoneyTransferService();
        svc.moneyTransfer(a, b, 100.0);
        assertEquals(899.0, a.getBalance(), 0.0001);
        assertEquals(99.0, b.getBalance(), 0.0001);
    }
}
