package barr;


public aspect ReduceThirdTransferAspect {
    public int MoneyTransferService.__transferCount = 0;
    
    pointcut transferExec(MoneyTransferService s, Account from, Account to, double amt) :
    execution(public void MoneyTransferService.moneyTransfer(Account, Account, double))
        && this(s) 
            && args(from, to, amt);
    
    
    before(MoneyTransferService s, Account from, Account to, double amt) : transferExec(s, from, to, amt) {
        s.__transferCount++;
    }
    
    pointcut withdrawInTransfer(MoneyTransferService s, Account from, double amt) :
    call(public void Account.withdraw(double)) && target(from) && args(amt)
        && cflow(transferExec(s, Account, Account, double));

    void around(MoneyTransferService s, Account from, double amt) : withdrawInTransfer(s, from, amt) {
        if (s.__transferCount % 3 == 0) {
            proceed(s, from, amt * 0.5d);
        } else {
            proceed(s, from, amt);
        }
    }
}
