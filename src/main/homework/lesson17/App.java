package main.homework.lesson17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import main.homework.lesson17.dom.XMLParserDom;
import main.homework.lesson17.sax.XMLParserSAX;

// Написать программу для парсинга xml документа. Необходимо распарсить xml документ и
// содержимое тегов line записать в другой документ. Название файла для записи должно
// состоять из значений тегов и имеет вид: <firstName>_<lastName>_<title>.txt
// Дополнительно реализовать следующий функционал: если с консоли введено значение 1
// - распарсить документ с помощью SAX, если с консоли введено значение 2 - распарсить
// документ с помощью DOM.

public class App {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        // Задача1 + Задача*
        String[] array = new String[] { "lastName", "firstName", "title" };
        String forWriteFile = "line";
        List<String> listForNameFile = new ArrayList<>();
        List<String> listForWriteFile = new ArrayList<>();
        // получение номера работы
        int numWork = Entrance.enter.get();

        // получение номера для выбора парсера
        if (numWork == 1) {
            for (String str : array) {
                listForNameFile.addAll(new XMLParserSAX().parser("src/main/homework/lesson17/xml.xml", str)); 
            }
            listForWriteFile.addAll(new XMLParserSAX().parser("src/main/homework/lesson17/xml.xml", forWriteFile));

        } else if (numWork == 2) {
            for (String str : array) {
                listForNameFile.addAll(XMLParserDom.parser("src/main/homework/lesson17/xml.xml", str));
            }
            listForWriteFile.addAll(XMLParserDom.parser("2src/main/homework/lesson17/xml.xml", forWriteFile));
        } else {
            return;
        }
        // Запись в файл
        WorkWichFiles.writeFile(listForNameFile, listForWriteFile);

    }

}
