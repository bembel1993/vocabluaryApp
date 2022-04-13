import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assambly {
    public static void showAssemly() throws IOException {
        String select;
        for (; ; ) {
            System.out.println("Enter 'ok' to Word for Add, 'sh' to show list the Word, " +
                    "'src' to search needed Word or enter 'q' for exit: ");
            BufferedReader choice = new BufferedReader(new InputStreamReader(System.in));
            select = choice.readLine();
            if (select.equals("ok")) {

                BufferedReader enterRussWord = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter Russ: ");
                String russWord = enterRussWord.readLine();

                BufferedReader enterEngWord = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter English: ");
                String engWord = enterEngWord.readLine();

                BufferedReader enterDeWord = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter Deutsch: ");
                String deWord = enterDeWord.readLine();

                ActiveWord activeWord = new ActiveWord(russWord, engWord, deWord);
                System.out.println("---------------------------------");
                activeWord.addInputWord();
                activeWord.showAddWord();
                System.out.println("---------------------------------");
                activeWord.writeAddWordInFile();
                activeWord.showWriteAddWordInFile();
                System.out.println("---------------------------------");
            } else if (select.equals("q")) {
                System.out.println("exit");
                break;
            } else if (select.equals("sh")) {
                ActiveWord.showWriteAddWordInFile();
            } else if (select.equals("src")) {
                ActiveWord.searchWordInAddFile();
            }
        }
    }
}
