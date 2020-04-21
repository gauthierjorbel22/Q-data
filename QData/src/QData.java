
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gauthier
 */
public class QData {

    Scanner input;
    Scanner input2, input3;
    private String[][] stArray;
    private String fileName;
    private String fileData = "";

    //Constructor with a string parameter called fileName 
    public QData(String fileName) {
        this.fileName = fileName;
        try {
            input3 = new Scanner(new File(fileName));

            readFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //getter of a stArray 
    public String[][] getStArray() {
        return stArray;
    }

    //determine the number of students and the number of quizzes
    public void getNumStudentsAndQuizes() {
        System.out.println("\nThe number of students is: " + this.stArray.length);
        System.out.println("The number of quizzes is: " + this.stArray[0].length);
        System.out.println();

    }

    //a method to read the file
    public void readFile() {
        try {
            int sizeRow = 0;
            int sizeCol = 0;
            while (input3.hasNext()) {
                fileData += input3.nextLine() + "\n";
            }
            input = new Scanner(new File(fileName));
            while (input.hasNext()) {

                String line = input.nextLine();
                String[] token = line.split(" ");
                sizeCol = Math.max(sizeCol, token.length);
                sizeRow++;
            }
            this.stArray = new String[sizeRow][sizeCol];
            int count = 0;
            input.close();
            input2 = new Scanner(new File(fileName));
            while (input2.hasNext()) {
                String line = input2.nextLine();
                String[] token = line.split(" ");
                for (int c = 0; c < token.length; c++) {
                    stArray[count][c] = token[c];
                }
                count++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //getter for number of students 
    public int getNumStudent() {
        return this.stArray.length;
    }

    //getter for number of quizzes
    public int getNumQuizes() {
        return this.stArray[0].length;
    }

    //method to print the array
    public void printArray() {
        System.out.println("print array" + "\n");

        for (String[] arr : this.stArray) {
            for (String y : arr) {

                System.out.print(Integer.parseInt(y) + " ");
            }

            System.out.println("");
        }

    }

    @Override
    public String toString() {
        System.out.println(fileData);
        return fileData;
    }

    //method to calculate and show the student average 
    public double studentAverage() {
        Scanner inputUser = new Scanner(System.in);
        int size = this.stArray.length;
        System.out.print("Select a student of your choice from 1 to " + size + " : ");
        String user = inputUser.next();
        boolean validInput = false;
        int studentN = 0;
        do {
            try {
                studentN = Integer.parseInt(user);
                if (studentN >= 1 && studentN <= size) {
                    validInput = false;
                    break;

                } else {
                    validInput = true;
                    System.out.println("Wrong student number, Please select between 1 and " + size);
                }

            } catch (Exception e) {
                System.err.println("INVALID INPUT");

            }
            inputUser.nextLine();
            System.err.print("Please try again: ");

            user = inputUser.next();
        } while (validInput);
        double total = 0;

        for (int i = 0; i < this.stArray[studentN - 1].length; i++) {

            total += Integer.parseInt(stArray[studentN - 1][i]);
        }

        System.out.println();
        double average = (total / this.stArray[studentN - 1].length);
        return average;

    }

    //mehtod called menu just to output a menu from which the user will select options 
    public int menu() {

        System.out.printf("%12s\n", "Menu");
        System.out.printf("%12s\n", "____");
        System.out.printf("\n\n%5s", "[1] Print the data from the file");
        System.out.printf("\n\n%5s", "[2] Print Array");
        System.out.printf("\n\n%5s", "[3] Show number of student and number of quizes");
        System.out.printf("\n\n%5s", "[4] Student Average");
        System.out.printf("\n\n%5s", "[5] Student Range");
        System.out.printf("\n\n%5s", "[6] overall Average");
        System.out.printf("\n\n%5s", "[7] EXIT");
        System.out.print("\n\n\tEnter your choice: ");
        Scanner useI = new Scanner(System.in);
        boolean validInput = true;
        int selection = 0;
        do {
            try {
                selection = useI.nextInt();
                if (selection >= 1 && selection <= 7) {
                    validInput = false;
                    break;
                } else {
                    validInput = true;
                    System.out.println("Invalid selection, Please select a number within the menu");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, Integer an integer!");
            }
            useI.nextLine();
            System.out.print("Try again: ");
        } while (validInput);
        return selection;
    }

    //mehtod called quizRange to determine the range 
    public double quizRange() {

        Scanner inputUser = new Scanner(System.in);
        int size = this.stArray.length;
        System.out.print("Select a student of your choice from 1 to " + size + " : ");
        String user = inputUser.next();
        boolean validInput = false;
        int studentN = 0;
        do {
            try {
                studentN = Integer.parseInt(user);
                if (studentN >= 1 && studentN <= size) {
                    validInput = false;
                    break;

                } else {
                    validInput = true;
                    System.out.println("Wrong student number, Please select between 1 and " + size);
                }

            } catch (Exception e) {
                System.err.println("INVALID INPUT");

            }
            inputUser.nextLine();
            System.err.print("Please try again: ");

            user = inputUser.next();
        } while (validInput);

        int min = 0, max = 0;
        for (int i = 0; i < this.stArray[studentN - 1].length; i++) {
            if (i == 0) {
                min = Integer.parseInt(stArray[studentN - 1][i]);
            }

            min = Math.min(min, Integer.parseInt(stArray[studentN - 1][i]));
            max = Math.max(max, Integer.parseInt(stArray[studentN - 1][i]));

        }

        System.out.println();
        double range = (max - min);

        return range;

    }

    // method called overallAverage to calculate the average of all the students
    public double overallAverage() {
        double total = 0;

        for (String[] ars : this.stArray) {
            for (String x : ars) {
                total += Integer.parseInt(x);
            }

        }
        double averageAll = (total / (this.stArray.length * this.stArray[0].length));
        return averageAll;
    }

}
