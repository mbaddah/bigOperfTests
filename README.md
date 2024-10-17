# bigO perf Tests

Note: Still wip.

### Description

End points:

| Notation / Time Complexity | Path                                       |
|----------------------------|--------------------------------------------|
| Constant O(1)              | localhost:8080/constant                    |
| Linear O(n)                | localhost:8080/linear/{size}               |
| Quadratic O(n^{2})         | localhost:8080/quadratic/{size}            |
| Logarithmic O(log n)       | localhost:8080/logarithmic/{size}/{target} |
| linearithmic O(n log n)    | localhost:8080/heapSort/{size}             |


### How to run

Main program:

```dtd
gradlew bootRun
```

To run Jmeter tests from CLI with html report:

```
 jmeter -n -t <test JMX file path> -l <test log file path> -e -o <Path to output folder>
 ```

Set the heap size according to your memory, e.g:

```declarative
set HEAP=-Xms4g -Xmx8g -XX:MaxMetaspaceSize=256m
```
You can do this directly in the Jmeter.bat file or in env variables.