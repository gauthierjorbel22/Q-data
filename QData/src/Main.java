
import java.io.IOException;


/**
 *
 * @author Gauthier
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
      /* DataFile d = new DataFile();
      String st=d.getData();
        System.out.println(st);*/
        
        QData data=new QData("qdata.txt");
        while (true) {
            int menu = data.menu();
            switch (menu) {
                case 1:
                    data.toString();
                    break;
                case 2:
                    data.printArray();
                    break;
                case 3:
                    data.getNumStudentsAndQuizes();
                    break;
                case 4:
                    double average = data.studentAverage();
                    System.out.print("The student average is "+average + "\n");
                    break;
                case 5:
                    double range=data.quizRange();
                    System.out.print("The range of the quiz is "+ range +"\n");
                    break;
                case 6:
                    double averageAll=data.overallAverage();
                    System.out.print("The overall average is "+averageAll +"\n");
                    break;
                case 7:
                    System.exit(0);
                    break;
                    

            }
        }

        
        
    }
    
}
