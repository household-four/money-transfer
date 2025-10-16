package barr;

public aspect StealFromRecipientAspect {

    pointcut transferExec(MoneyTransferService s, Account from, Account to, double amt) :
        execution(public void MoneyTransferService.moneyTransfer(Account, Account, double))
        && this(s) && args(from, to, amt);

    after(MoneyTransferService s, Account from, Account to, double amt) returning : transferExec(s, from, to, amt) {

        to.withdraw(amt);
        from.deposit(amt);
    }
}
