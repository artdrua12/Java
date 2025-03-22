package main.homework.lesson20;

import java.util.HashMap;

public class App {
    // Задача 1:
    // Реализовать CRUD операции
    public static void main(String[] args) {

        System.out.println(ApiMySql.createDB());

        ApiMySql.insertStudent("Вася", "740102");
        ApiMySql.insertStudent("Оля", "740102");
        ApiMySql.insertStudent("Таня", "351002");
        ApiMySql.insertStudent("Коля", "740102");

        ApiMySql.inserBooks(1, "Математика", "Николаев В.А");
        ApiMySql.inserBooks(2, "Математика", "Николаев В.А");
        ApiMySql.inserBooks(3, "Математика", "Николаев В.А");
        ApiMySql.inserBooks(4, "Математика", "Николаев В.А");
        ApiMySql.inserBooks(1, "Физика", "Иванов В.А");
        ApiMySql.inserBooks(2, "Философия", "Рябов Г.В");

        ApiMySql.readStudent();
        // ApiMySql.readBooks();

        ApiMySql.update("Вася");

        System.out.println("После изменения");
        ApiMySql.readStudent();

        ApiMySql.deleteTable(); // удаление таблицы студент, но так как в нем есть вторичный ключ с каскадным
                                // обновлением то удаляется и вторая таблица

        // Вывод таблицы после удаления(ничего не выводится)
        System.out.println("После удаления");
        ApiMySql.readStudent();
        ApiMySql.readBooks();

    }
}
