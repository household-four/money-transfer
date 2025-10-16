package barr;

public aspect ServiceFeeAspect {
    
    pointcut transferExec(MoneyTransferService s, Account from, Account to, double amt) :
    execution(public void MoneyTransferService.moneyTransfer(Account, Account, double))
        && this(s) && args(from, to, amt);
    
    
    after(MoneyTransferService s, Account from, Account to, double amt) : transferExec(s, from, to, amt) {
        double fee = 1.0;
        from.withdraw(fee);
        to.withdraw(fee);
    }
}
