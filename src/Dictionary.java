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

    public void insert(String data) {
        d.insert(data);
        size++;
    }

    public void delete(String data) {
        d.delete(data);
        size--;
    }

    //public Boolean search(String data)
// {
//     return d.Search(data);
// }
    public void batch_insert(String path) {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                d.insert(data);
                size++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
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
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void traverse() {
        d.traverse();
    }

    public int getSize() {

        return d.getSize();
    }

//public int getHeight()
//{
//    return  height;
//}


}
