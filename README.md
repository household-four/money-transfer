# About
Author: Christen Barringer

Uses Maven profiles to test individual AspectJ aspects. 

# Issue
The following command runs the MoneyTransferServiceAspectTest using the `money-transfer-service` profile from pom.xml. 

```
mvn -P money-transfer-service -Dtest=MoneyTransferServiceAspectTest test
```

The profile points to `src/test/resources/money-transfer-service/aop.xml` to get the weaver information. This tells it to use barr.MoneyTransferServiceAspect

When the test runs, this is in the terminal

```
[AppClassLoader@5a07e868] error The specified aspect 'barr.MoneyTransferServiceAspect' cannot be found
```

The aspect cannot be found, so it does not get woven in. This causes the test to fail. 

# Repo Files

| File | Credit |
| --- | --- |
| Account.java | Provided |
| AroundAdviceAspect.java | Provided | 
| Client.java | Provided |
| MoneyTransferService.java | Provided |
| MoneyTransferServiceAspect.java | Provided | 
| --- | --- | 
| DoubleDepositByParamASpect.java | Mine | 

All tests are mine.  

# Aspects and Tests
| Assignment Item | Aspect | Test | Command | 
| ----- | ----- | ----- | --- |
| None | AroundAdviceAspect | AroundAdviceAspectTest | `mvn -P around-advice -Dtest=AroundAdviceAspectTest test` |
| None | MoneyTransferServiceAspect | MoneyTransferServiceAspectTest | `mvn -P money-transfer-service -Dtest=MoneyTransferServiceAspectTest test` |
| None | DoubleDepositByParamAspect | DoubleDepositByParamAspectTest | `mvn -P double-param -Dtest=DoubleDepositByParamAspectTest test` |

# Credits
Credit to Tingshuo Miao for helping me fix my Maven profiles build issue.
