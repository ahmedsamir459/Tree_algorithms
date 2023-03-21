import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of the backend tree of the dictionary :");
        System.out.print("\u001B[33m1)AVL Tree\n2)Red Black Tree\u001B[0m\nAnswer >> ");
        String D_type;
        Dictionary d;
        D_type = scanner.next();
        while (true) {
            try {
                if (Integer.valueOf(D_type) == 1 || Integer.valueOf(D_type) == 2) {
                    break;
                } else {
                    System.out.print("\u001B[31mError,Please choose a right answer\n\u001B[0mAnswer >> ");
                    D_type = scanner.next();
                }

            } catch (Exception e) {
                System.out.print("\u001B[31mError,Please choose a right answer\n\u001B[0mAnswer >> ");
                D_type = scanner.next();
            }
        }
        d = new Dictionary(Integer.valueOf(D_type));

        options(d);
    }

    static void options(Dictionary d) {
        while (true) {
            System.out.println("\u001B[33m" +
                    "-------------------------------------------------------------" +
                    "\nDictionary options\u001B[0m");
            System.out.println("\u001B[32m1)Show dictionary\u001B[0m");
            System.out.println("\u001B[32m2)Insert word\u001B[0m");
            System.out.println("\u001B[32m3)Insert batch\u001B[0m");
            System.out.println("\u001B[32m4)Delete word\u001B[0m");
            System.out.println("\u001B[32m5)Delete batch\u001B[0m");
            System.out.println("\u001B[32m6)Search word\u001B[0m");
            System.out.println("\u001B[32m7)Get size of dictionary\u001B[0m");
            System.out.println("\u001B[32m8)Get height of the tree\u001B[0m");
            System.out.print("Choose option>> ");
            Scanner scanner = new Scanner(System.in);
            try {
                int option = scanner.nextInt();
                if (option <= 0 || option > 8) {
                    System.out.print("\u001B[31mError,Please choose a right option\n\u001B[0m");
                    options(d);
                }
                if (option == 1) {
                    d.traverse();
                } else if (option == 2) {
                    System.out.print("Enter the word to insert>>");
                    String toInsert = scanner.next();
                    d.insert(toInsert);
                } else if (option == 3) {
                    System.out.print("Enter the path of the file to insert>>");
                    String fileToInsert = scanner.next();
                    d.batch_insert(fileToInsert);
                } else if (option == 4) {
                    System.out.print("Enter the word to delete>>");
                    String toDelete = scanner.next();
                    d.insert(toDelete);
                } else if (option == 5) {
                    System.out.print("Enter the path of the file to delete>>");
                    String fileToDelete = scanner.next();
                    d.batch_insert(fileToDelete);
                } else if (option == 6) {
                    System.out.print("Enter the word to search>>");
                    String toSearch = scanner.next();
                    if (d.search(toSearch)) {
                        System.out.println("Word FOUND ✅");
                    } else {
                        System.out.println("Word NOT FOUND ❌");
                    }
                } else if (option == 7) {
                    System.out.println("Dictionary size = " + d.getSize());
                } else if (option == 8) {
                    System.out.println("Dictionary tree height = " + d.getHeight());
                }

            } catch (Exception e) {
                System.out.print("\u001B[31mError,Please choose a right option\n\u001B[0m");
            }
        }
    }
}