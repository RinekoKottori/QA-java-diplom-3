# QA-java-diplom-3


| Dependencies      | Version     |
|-------------------|-------------|
| Java              | 11.0.24_8   |
| JUnit             | 4.13.1      |
| JDK               | 11.0.24     |
| Maven             | 11          |
| Allure            | 2.29.0      |
| Aspectj           | 4.13.1      |
| Rest-assured      | 5.5.0       |
| Gson              | 2.11.0      |
| Webdriver manager | 5.9.2       |


| Plugin         | Version  | configuration |
|----------------|----------|---------------|
| Maven-surefire | 3.5.0    |               |
| Allure-maven   | 2.12.0   | 2.30.0        | 

# Running default tests  
`mvn clean test`

## Запуск для chrome browser
```bash
mvn clean test -Dbrowser=chrome
```

## Запуск для yandex browser
```bash
изменить путь до yandex.exe в классе DriverRule в методе initYandex, строка 53
mvn clean test -Dbrowser=yandex

альтернативный вариант:
перейти в cmd ввести: cd путь до проекта
mvn clean test -Dbrowser=yandex -Ddriver.version=126.0.6478.182 -Dwebdriver.yandex.bin= путь до /yandex.exe
```

## Запуск для firefox browser
```bash
mvn clean test -Dbrowser=firefox
```

