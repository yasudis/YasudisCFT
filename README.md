# YasudisCFT
## Тестовое задание 
## Курс JAVA.
В Описание задачи
Написать программу сортировки слиянием нескольких файлов.
Входные файлы содержат данные одного из двух видов: целые числа или строки. Данные записаны
в столбик (каждая строка файла – новый элемент). Строки могут содержать любые не пробельные
символы, строки с пробелами считаются ошибочными. Также считается, что файлы предварительно
отсортированы.
Результатом работы программы должен являться новый файл с объединенным содержимым
входных файлов, отсортированным по возрастанию или убыванию путем сортировки слиянием.
Если содержимое исходных файлов не позволяет произвести сортировку слиянием (например,
нарушен порядок сортировки), производится частичная сортировка (насколько возможно для этого
алгоритма, как именно обрабатывать поврежденный файл – на усмотрение разработчика).
Выходной файл должен содержать отсортированные данные даже в случае ошибок, однако
возможна потеря ошибочных данных.
Необходимо самостоятельно реализовать алгоритм сортировки методом слияния и использовать
его для сортировки содержимого файлов. Не использовать библиотечные функции сортировки.
Алгоритм должен быть устойчив к большим файлам, не помещающимся целиком в оперативную
память.
Все возможные виды ошибок должны быть обработаны. Программа не должна «падать». Если
после ошибки продолжить выполнение невозможно, программа должна сообщить об этом
пользователю с указанием причины неудачи. Частичная обработка при наличии ошибок более
предпочтительна чем останов программы. Код программы должен быть «чистым».
Для реализации необходимо использовать язык программирования Java, допустимо использовать
стандартные системы сборки проекта (Maven, Gradle)
Решение принимается в виде исходного кода проекта.
Параметры программы задаются при запуске через аргументы командной строки, по порядку:
1) режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
2) тип данных (-s или -i), обязательный;
3) имя выходного файла, обязательное;
4) остальные параметры – имена входных файлов, не менее одного.
## Примеры запуска из командной строки для Windows:
* sort-it.exe -i -a out.txt in.txt (для целых чисел по возрастанию)
* sort-it.exe -s out.txt in1.txt in2.txt in3.txt (для строк по возрастанию)
* sort-it.exe -d -s out.txt in1.txt in2.txt (для строк по убыванию)

## Инструкция по запуску
В директории с проектом написать в командную строку:

* mvn compile
* mvn package
* cd target
* java -jar YasudisCFT-1.0-SNAPSHOT.jar [-a|-d] {-i|-s} out.txt in1.txt [in2.txt...]

# Описание параметров:
* -a - соритровка по возрастанию (необязательный, по умолчанию)
* -d - сортировка по убыванию (необязательный)
* -i - сортировка целых чисел (обязательный)
* -s - сортировка строк (обязательный)
* out.txt - название выходного файла
* in1.txt - название входного файла (не менее одного)
* Входные и выходные файлы должны лежать в папке target(либо в одной папке с YasudisCFT-1.0-SNAPSHOT.jar )

## Версия Java
# Java 19.0.2

## Система сборки
# Apache Maven 3.9.4
