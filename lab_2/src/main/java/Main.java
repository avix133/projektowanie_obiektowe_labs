import java.util.Scanner;

/**
 * Description of class:
 * <p>
 * Created on 24 Oct 2018 (19:12)
 *
 * @author dawid
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int menuItem = menu();
        while (menuItem != 0) {
            switch (menuItem) {
                case 1:
                    LibraryDataServiceSingleton.getInstance().displayBooks();
                    break;
                case 2:
                    LibraryDataServiceSingleton.getInstance().displayUsers();
                    break;
                case 3:
                    System.out.print("User name: ");
                    String name = in.nextLine();
                    System.out.print("User surname: ");
                    String surname = in.nextLine();
                    System.out.print("Year: ");
                    int year = in.nextInt();
                    System.out.print("Fine: ");
                    int fine = in.nextInt();
                    int id = LibraryDataServiceSingleton.getInstance().addUser(name, surname, year, fine);
                    System.out.print("User with id " + id + " created successfully.");
                    break;
                case 4:
                    System.out.print("User id: ");
                    LibraryDataServiceSingleton.getInstance().removeUser(in.nextInt());
                    break;
                case 5:
                    System.out.print("User id: ");
                    int updateUserId = in.nextInt();
                    if (LibraryDataServiceSingleton.getInstance().displayUser(updateUserId)) {
                        System.out.print("User name: ");
                        in.nextLine();
                        String updateUserName = in.nextLine();
                        System.out.print("User surname: ");
                        String updateUserSurname = in.nextLine();
                        System.out.print("Year: ");
                        int updateUserYear = in.nextInt();
                        System.out.print("Fine: ");
                        int updateUserFine = in.nextInt();
                        LibraryDataServiceSingleton.getInstance().
                                updateUser(updateUserId, updateUserName, updateUserSurname, updateUserYear, updateUserFine);
                    }
                    break;
                case 6:
                    System.out.print("Book title: ");
                    String title = in.nextLine();
                    System.out.print("Book author: ");
                    String author = in.nextLine();
                    System.out.print("User id: ");
                    int userId = in.nextInt();
                    LibraryDataServiceSingleton.getInstance().rentBook(title, author, userId);

                    break;

                case 7:
                    System.out.print("Book id: ");
                    int updateBookId = in.nextInt();
                    if (LibraryDataServiceSingleton.getInstance().displayBook(updateBookId)) {
                        System.out.print("Title: ");
                        in.nextLine();
                        String updateBookTitle = in.next();
                        System.out.print("Author: ");
                        String updateBookAuthor = in.next();
                        System.out.print("User id: ");
                        int updateBookUserId = in.nextInt();
                        LibraryDataServiceSingleton.getInstance().
                                updateBook(updateBookId, updateBookTitle, updateBookAuthor, updateBookUserId);
                    }
                    break;
                case 8:
                    System.out.print("Book id: ");
                    int returnBookId = in.nextInt();
                    LibraryDataServiceSingleton.getInstance().removeBook(returnBookId);
                    break;
            }

            menuItem = menu();
        }
    }

    private static int menu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Display books.");
        System.out.println("     2. Display users.");
        System.out.println("     3. Add user.");
        System.out.println("     4. Delete user.");
        System.out.println("     5. Modify user.");
        System.out.println("     6. Rent book.");
        System.out.println("     7. Modify book.");
        System.out.println("     8. Return book.");
        System.out.println("     0. Exit.");

        Scanner in = new Scanner(System.in);

        return in.nextInt();
    }
}
