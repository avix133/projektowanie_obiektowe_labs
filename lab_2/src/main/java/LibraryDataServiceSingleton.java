import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 * Description of class:
 * <p>
 * Created on 24 Oct 2018 (19:33)
 *
 * @author dawid
 */
class LibraryDataServiceSingleton {
    private static LibraryDataServiceSingleton instance;
    private List<Book> bookList;
    private List<User> userList;
    private static final String BOOKS_CSV = "./data/books.csv";
    private static final String USERS_CSV = "./data/users.csv";

    private LibraryDataServiceSingleton() {
        loadBooks();
        loadUsers();

    }

    static LibraryDataServiceSingleton getInstance() {
        if (instance == null) {
            instance = new LibraryDataServiceSingleton();
        }

        return instance;
    }

    void displayUsers() {
        userList.forEach(System.out::println);
    }

    void displayBooks() {
        bookList.forEach(System.out::println);
    }

    boolean displayUser(int id) {
        Optional<User> user = findUser(id);
        System.out.println(user.isPresent() ? user.toString() : "There is no such user!");
        return user.isPresent();
    }

    boolean displayBook(int id) {
        Optional<Book> book = findBook(id);
        System.out.println(book.isPresent() ? book.toString() : "There is no such book!");
        return book.isPresent();
    }

    int addUser(String name, String surname, int year, int fine) {
        Optional<User> latestUser = userList.stream().max(Comparator.comparing(User::getId));
        int newUserId = latestUser.map(user -> user.getId() + 1).orElse(1);
        userList.add(new User(newUserId, name, surname, year, fine));
        this.saveUsers();

        return newUserId;
    }

    void rentBook(String title, String author, int userId) {
        Optional<Book> latestBook = bookList.stream().max(Comparator.comparing(Book::getId));
        int newBookId = latestBook.map(user -> user.getId() + 1).orElse(1);
        Optional<User> user = findUser(userId);
        if (user.isPresent()) {
            bookList.add(new Book(newBookId, title, author, userId));
            System.out.print("Book with id " + newBookId + " created successfully.");
            this.saveBooks();
        }
        else {
            System.out.println("There is no such user!");
        }
    }

    void removeUser(int id) {
        Optional<User> user = findUser(id);
        if (user.isPresent()) {
            userList.remove(user.get());
            this.saveUsers();
            System.out.println("User removed successfully!");
        } else {
            System.out.println("There is no such user");
        }

    }

    void removeBook(int id) {
        Optional<Book> book = findBook(id);
        if (book.isPresent()) {
            bookList.remove(book.get());
            this.saveBooks();
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("There is no such book");
        }
    }

    void updateUser(int id, String name, String surname, int year, int fine) {
        Optional<User> user = findUser(id);
        if (user.isPresent()) {
            User u = user.get();
            u.setName(name);
            u.setSurname(surname);
            u.setYear(year);
            u.setFine(fine);
            this.saveUsers();
            System.out.println("User updated successfully!");
        } else {
            System.out.println("There is no such user");
        }
    }

    void updateBook(int id, String title, String author, int userId) {
        Optional<Book> book = findBook(id);
        if (book.isPresent()) {
            Book b = book.get();
            b.setTitle(title);
            b.setAuthor(author);
            b.setUserId(userId);
            this.saveBooks();
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("There is no such book");
        }
    }

    private void loadBooks() {
        bookList = new ArrayList<>();
        for (CSVRecord csvRecord : loadCsvFile(BOOKS_CSV)) {
            int id = Integer.parseInt(csvRecord.get(0));
            String title = csvRecord.get(1);
            String author = csvRecord.get(2);
            int userId = Integer.parseInt(csvRecord.get(3));
            bookList.add(new Book(id, title, author, userId));
        }
    }

    private void loadUsers() {
        userList = new ArrayList<>();
        for (CSVRecord csvRecord : loadCsvFile(USERS_CSV)) {
            int id = Integer.parseInt(csvRecord.get(0));
            String name = csvRecord.get(1);
            String surname = csvRecord.get(2);
            int year = Integer.parseInt(csvRecord.get(3));
            int fine = Integer.parseInt(csvRecord.get(4));
            userList.add(new User(id, name, surname, year, fine));
        }
    }


    private void saveBooks() {
        CSVPrinter csvPrinter = saveCsvFile(BOOKS_CSV);
        for (Book book : bookList) {
            try {
                csvPrinter.printRecord(book.getId(), book.getTitle(), book.getAuthor(), book.getUserId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        CSVPrinter csvPrinter = saveCsvFile(USERS_CSV);
        for (User user : userList) {
            try {
                csvPrinter.printRecord(user.getId(), user.getName(), user.getSurname(), user.getYear(), user.getFine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Optional<User> findUser(int id) {
        return userList.stream().filter(item -> item.getId() == id).findFirst();
    }

    private Optional<Book> findBook(int id) {
        return bookList.stream().filter(item -> item.getId() == id).findFirst();
    }

    private CSVParser loadCsvFile(String filePath) {
        Reader reader = null;
        CSVParser csvParser = null;
        try {
            reader = Files.newBufferedReader(Paths.get(filePath));
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvParser;
    }

    private CSVPrinter saveCsvFile(String filePath) {
        CSVPrinter csvPrinter = null;
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
            csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return csvPrinter;
    }

}
