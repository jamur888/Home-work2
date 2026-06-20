import java.util.List;

class Student {
    private String name;
    private List<Book> books;

    public Student() {
    }

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }


    @Override
    public String toString() {
        return "Студент: " + name + ", Книг в наличии: " + (books != null ? books.size() : 0);
    }
}