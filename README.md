# QA-java-diplom-3


| Dependencies | Version   |
|--------------|-----------|
| Java         | 11.0.24_8 |
| JUnit        | 4.13.1    |
| JDK          | 11.0.24   |
| Maven        | 11        |
| Allure       | 2.29.0    |
| Aspectj      | 4.13.1    |
| Rest-assured | 5.5.0     |
| Gson         | 2.11.0    |


| Plugin         | Version  | configuration |
|----------------|----------|---------------|
| Maven-surefire | 3.5.0    |               |
| Allure-maven   | 2.12.0   | 2.30.0        | 

# Running the test in default browser
`mvn clean test`

## Запуск для chrome browser
```bash
mvn clean test -Dbrowser=chrome
```

## Запуск для yandex browser
```bash
mvn clean test -Dbrowser=yandex
```