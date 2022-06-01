# Задание
Написание автоматизированных тестов для [https://edujira.ifellow.ru/](https://edujira.ifellow.ru/)

Применены JUnit, Selenide, Maven, Allure

# Описание и ссылки на основные классы
1. [class AuthorizationTest](src/test/java/AuthorizationTest.java) - класс с тестами для проверки авторизации
2. [class JiraTest](src/test/java/JiraTest.java) - класс с тестами для проверки функций сайта

# Запуск тестов
mvn clean test

# Построение локально отчетов
mvn allure:serve

# Входные данные
задаются в файле [application.properties](src/test/resources/application.properties)
