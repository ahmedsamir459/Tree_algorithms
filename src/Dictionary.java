import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class Dictionary {
    Tree d;
    int size = 0;

    Dictionary(int type) {
        if (type == 1) {
            d = new AVL<>();
        } else if (type == 2) {
            d = new RB<>();
        }
    }

    public void insert(String toInsert) {
        if (d.contains(toInsert)) {
            System.out.print("(" + toInsert + ")" + "\u001B[31mAlready EXIST\n\u001B[0m");
        }
        else {
            d.insert(toInsert);
            System.out.print("(" + toInsert + ")" + "\u001B[32m Succefully inserted ✅\n\u001B[0m");
            size++;
        }
    }

    public void delete(String data) {
        d.delete(data);
        size--;
    }

    public Boolean search(String toSearch) {
        if (d.contains(toSearch)) {
            System.out.println("\u001B[32mWord FOUND\u001B[0m ✅");
        } else {
            System.out.println("\u001B[31mWord NOT FOUND\u001B[0m ❌");
        }
        return d.contains(toSearch);
    }

    public void batch_insert(String path) {
        try {
            int Inserted=0;
            int notInserted=0;
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (d.contains(data)) {
                    notInserted++;
                }
                else {
                    d.insert(data);
                    Inserted++;
                    size++;
                }
            }
            System.out.print("("+Inserted+")"+"\u001B[32m words SUCCEFULLY INSERTED ✅\n\u001B[0m");
            if(notInserted !=0) {
                System.out.print("(" + notInserted + ")" + "\u001B[31m words ALREADY EXIST \n\u001B[0m");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred opening file");
            e.printStackTrace();
        }
    }

    public void batch_delete(String path) {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                d.delete(data);
                size--;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred opening file");
            e.printStackTrace();
        }

    }

    public void traverse() {

        if (d.isEmpty()) {
            System.out.print("\u001B[31mNothing to show, dictionary is EMPTY\n\u001B[0m");
        } else d.traverse();
    }

    public int getSize() {

        return size;
    }

    public int getHeight() {
        return getHeight();
    }

}
