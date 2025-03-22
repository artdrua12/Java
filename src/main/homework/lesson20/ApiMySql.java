package main.homework.lesson20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApiMySql {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/operation";
    private static final String user = "root";
    private static final String password = "1234567";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    public static void deleteTable() {
        String query = "DELETE FROM lesson20.student";
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public static void update(String person) {
        String query = "UPDATE lesson20.student SET grupa = 100001 where person = (?)";
        try {
            con = DriverManager.getConnection(url, user, password);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, person);
            pstmt.executeUpdate();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public static String createDB() {
        String crtDB = "CREATE SCHEMA IF NOT EXISTS `lesson20` DEFAULT CHARACTER SET utf8 ;";
        String crtStudent = "CREATE TABLE IF NOT EXISTS `lesson20`.`student` (\n" + //
                "  `id` INT AUTO_INCREMENT,\n" + //
                "  `person` VARCHAR(45) NULL,\n" + //
                "  `grupa` VARCHAR(45) NULL,\n" + //
                "  PRIMARY KEY (`id`))\n" + //
                "ENGINE = InnoDB;";

        String crtBooks = "CREATE TABLE IF NOT EXISTS `lesson20`.`Books` (\n" + //
                "  `idBooks` INT NOT NULL AUTO_INCREMENT,\n" + //
                " `idStudent` INT NULL,\n" + //
                " `nameBook` VARCHAR(45) NULL,\n" + //
                "  `autor` VARCHAR(45) NULL,\n" + //
                " PRIMARY KEY (`idBooks`),\n" + //
                " INDEX `idStudent_idx` (`idStudent` ASC) VISIBLE,\n" + //
                " CONSTRAINT `idStudent`\n" + //
                "   FOREIGN KEY (`idStudent`)\n" + //
                "   REFERENCES `lesson20`.`student` (`id`)\n" + //
                "   ON DELETE CASCADE\n" + //
                "  ON UPDATE CASCADE)\n" + //
                "  ENGINE = InnoDB;";

        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            con.setAutoCommit(false); // атомарная операция
            stmt.executeUpdate(crtDB);
            stmt.executeUpdate(crtStudent);
            stmt.executeUpdate(crtBooks);
            con.commit(); // подтверждение операции
            con.setAutoCommit(true); // атомарная операция конец
            return "База с таблицами создана";
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return "Ошибка в создании БД";
        }
    }

    public static void insertStudent(String name, String grupa) {
        String query = "INSERT INTO lesson20.student (person, grupa) VALUES (?, ?)";
        try {
            con = DriverManager.getConnection(url, user, password);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, grupa);
            pstmt.executeUpdate();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public static void inserBooks(int idStudent, String nameBook, String autor) {
        String query = "INSERT INTO lesson20.books (idStudent, nameBook, autor ) VALUES (?,?,?)";
        try {
            con = DriverManager.getConnection(url, user, password);
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, idStudent);
            pstmt.setString(2, nameBook);
            pstmt.setString(3, autor);
            pstmt.executeUpdate();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }

    public static void readStudent() {

        String query = "select * from lesson20.student;";
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(1);
                String person = rs.getString(2);
                String grupa = rs.getString(3);
                System.out.printf("id: %d, person: %s , grupa: %s %n", id, person, grupa);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            rs.close();
        } catch (SQLException se) {
        }
    }

    public static void readBooks() {

        String query = "select * from lesson20.books;";
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(1);
                int idStudent = rs.getInt(2);
                String nameBook = rs.getString(3);
                String autor = rs.getString(4);
                System.out.printf("id: %d, idStudent: %d, nameBook: %s, autor: %s %n", id, idStudent, nameBook, autor);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            rs.close();
        } catch (SQLException se) {
        }
    }
}
