# Test Examination

## Getting started
#### Prerequisites
* Java 8+
* Gradle 6.0.1+
* Python

#### Build
```
./scripts/build.sh
```

#### Run from terminal
* Run the application:
```
java -jar core/build/libs/core-main.jar
```

#### Integration Tests
* The CLI integration tests can be run from maven using:
```
cd int-tests
mvn -P cli-test integration-test
```
