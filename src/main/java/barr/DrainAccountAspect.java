package barr;

public aspect DrainAccountAspect {

    pointcut depositInTransfer(Account to, double amt) :
    withincode(public void MoneyTransferService.moneyTransfer(Account, Account, double)) &&
        call(public void Account.deposit(double)) &&
        target(to) && args(amt);

    pointcut withdrawInTransfer(Account from, double amt) :
    withincode(public void MoneyTransferService.moneyTransfer(Account, Account, double)) &&
        call(public void Account.withdraw(double)) &&
        target(from) && args(amt);

    void around(Account to, double amt) : depositInTransfer(to, amt) {
        double newAmt = to.getBalance() - 1.0;
        proceed(to, newAmt);
    }

    void around(Account from, double amt) : withdrawInTransfer(from, amt) {
        double newAmt = from.getBalance() - 1.0;
        proceed(from, newAmt);
    }
}
