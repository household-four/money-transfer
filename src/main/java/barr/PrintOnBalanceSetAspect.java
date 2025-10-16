package barr;

public aspect PrintOnBalanceSetAspect {

    pointcut deltaChange(Account acc, double val) :
    (call(public void Account.deposit(double)) || call(public void Account.withdraw(double)))
        && target(acc) 
            && args(val);
    
    
    after(Account acc, double val) : deltaChange(acc, val) {
        System.out.println("[AOP] Balance changed by " + val + " on acc " + acc.getAccNumber()
        + ", new bal=" + acc.getBalance());
    }
}
