import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            List<Student> students = mapper.readValue(
                    new File("students.json"),
                    new TypeReference<List<Student>>() {
                    }
            );

            System.out.println("--- Выполнение стрима ---");

            Optional<Integer> resultYear = students.stream()
                    .peek(System.out::println)
                    .map(Student::getBooks)
                    .flatMap(List::stream)
                    .sorted()
                    .distinct()
                    .filter(book -> book.getYear() > 2000)
                    .limit(3)
                    .map(Book::getYear)
                    .findFirst();

            System.out.println("\n--- Результат Optional ---");

            System.out.println(resultYear
                    .map(year -> "Найден год выпуска книги: " + year)
                    .orElse("Такая книга отсутствует"));

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}