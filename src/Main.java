import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of the backend tree of the dictionary :");
        System.out.print("\u001B[33m1)AVL Tree\n2)Red Black Tree\u001B[0m`\nAnswer>>");
        int D_type;

        Dictionary d;
        //YOUSSEF
            D_type = scanner.nextInt();
            while (D_type != 1 && D_type != 0 ){
                System.out.print("\u001B[31mError,Please choose a right answer\n\u001B[0mAnswer>>");
                D_type = scanner.nextInt();
            }
            d = new Dictionary(D_type);

            options(d);

    }
    static void options(Dictionary d){
        while(true){
            //Menu
            System.out.println("\u001B[33mDictionary options\u001B[0m");
            System.out.println("\u001B[32m1)Show dictionary\u001B[0m");
            System.out.println("\u001B[32m2)Insert word\u001B[0m");
            System.out.println("\u001B[32m3)Insert batch\u001B[0m");
            System.out.println("\u001B[32m4)Delete word\u001B[0m");
            System.out.println("\u001B[32m5)Delete batch\u001B[0m");
            System.out.println("\u001B[32m6)Search word\u001B[0m");
            System.out.println("\u001B[32m7)Get size of dictionary\u001B[0m");
            System.out.println("\u001B[32m7)Get height of the tree\u001B[0m");
            System.out.print("Choose option>> ");
            Scanner scanner = new Scanner(System.in);
            try {
                int option= scanner.nextInt();
                //Options
                if(option==1){
                    d.traverse();
                } else if (option==2)
                {
                    System.out.print("Enter the word to insert>>");
                    String toInsert = scanner.next();
                    d.insert(toInsert);
                } else if (option==3){
                    System.out.print("Enter the word to delete>>");
                    String todelete = scanner.next();
                    d.delete(todelete);
                } else if (option==4)
                {
                    //to be completed
                } else if (option==5) {
                    System.out.println("Dictionary size = "+d.getSize());
                }}
            catch (Exception e){
                System.out.print("\u001B[31mError,Please choose a right option\n\u001B[0mAnswer>>");
            }
        }
    }
}