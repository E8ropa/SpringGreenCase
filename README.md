# Тестовое задание Java

## Задача
Необходимо создать микросервис, который может хранить в себе файлы и их аттрибуты.
Микросервис должен предоставлять HTTP API и принимать/отдавать запросы/ответы в формате JSON.
Для тестирования использовался Postman
Данные должны храниться в СУБД PostgreSQL

## Решение

В файле init.sql создаётся таблица в БД PostgreSQL.

Создан класс FileTable описывающий таблицу в БД. Поле Creation_date проставляется автоматически. ID имеет уникальный номер.

В FileController описываются методы загрузки файла, а также получения файла по id и всех файлов с сортировкой и пагинацией.

## Проверка работы

### Метод POST
Вносится файл testtext.txt
Его информация записывается в PostgreSQL, на вывод выводится File ID
![image](https://github.com/user-attachments/assets/cf0f7b5b-ce9d-47ff-bad5-4ef92e380ec0)

### Метод GET

Если не указывать ID, то выводится список всех файлов
![image](https://github.com/user-attachments/assets/dc18548d-61d8-4949-81d5-5cd714437da8)

Если указать ID, то на выводе будет файл и его аттрибуты по выбранному ID.
![image](https://github.com/user-attachments/assets/a89c6eda-191c-4e1a-b1bd-ffa1a3b13440)

## Доп материалы

Фото таблицы в pgAdmin

![image](https://github.com/user-attachments/assets/74601d23-f7a9-41b7-849e-b87b8c82e696)






