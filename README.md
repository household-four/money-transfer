# About
Author: Christen Barringer

Uses Maven profiles to test individual AspectJ aspects. 

This is an example of the command I am using. This example should test the AroundAdviceAspect: 

```
mvn -P around-advice -Dtest=AroundAdviceAspectTest test
```

# Aspects and Tests
| Assignment Item | Aspect | Test | Command | 
| ----- | ----- | ----- | --- |
| None | AroundAdviceAspect | AroundAdviceAspectTest | `mvn -P around-advice -Dtest=AroundAdviceAspectTest test` |
| None | MoneyTransferServiceAspect | MoneyTransferServiceAspectTest | `mvn -P money-transfer-service -Dtest=MoneyTransferServiceAspectTest test` |

# Credits
Credit to Tingshuo Miao for helping me fix my Maven profiles build issue.
