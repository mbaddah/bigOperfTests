# bigO perf Tests

Note: Still wip.

### Description

End points:

- localhost:8080/constant
- localhost:8080/linear/{size}
- localhost:8080/quadratic/{size}
- localhost:8080/logarithmic/{size}/{target}

### How to run

Main program:

```dtd
gradlew bootRun
```

To run Jmeter tests from CLI with html report:

```
 jmeter -n -t <test JMX file path> -l <test log file path> -e -o <Path to output folder>
 ```