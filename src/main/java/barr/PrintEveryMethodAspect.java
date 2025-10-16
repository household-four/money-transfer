package barr;

public aspect PrintEveryMethodAspect {
    pointcut anyMethod() :
    execution(* MoneyTransfer..*(..)) && !within(MoneyTransfer..*Aspect);
    
    
    before() : anyMethod() {
        String sig = thisJoinPointStaticPart.getSignature().toShortString();
        System.out.println("[AOP] Enter: " + sig);
    }
}
