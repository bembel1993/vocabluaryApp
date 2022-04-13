import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ActiveWord extends Word {
    public String russInputWord;
    public String deutschInputWord;
    public String englishInputWord;
    public static File writeWordInVocabulary = new File("Vocabulary.txt");
    public static char[] buf;

    public ActiveWord(String rusW, String engW, String deW) {
        super(rusW, engW, deW);
        russInputWord = rusW;
        deutschInputWord = deW;
        englishInputWord = engW;
    }

    public void addInputWord() throws IOException {
        if (russInputWord == deutschInputWord || russInputWord == englishInputWord ||
                englishInputWord == russInputWord || englishInputWord == deutschInputWord ||
                deutschInputWord == russInputWord || deutschInputWord == englishInputWord) {
            System.out.println("Not correct input");
        } else {
            System.out.println("Word is Add");
            System.out.println("     -     ");
        }
    }

    public void showAddWord() {
        System.out.println("Russ: " + russInputWord);
        System.out.println("Eng: " + englishInputWord);
        System.out.println("De: " + deutschInputWord);
    }

    public void writeAddWordInFile() throws IOException {
        FileWriter fileWriter = new FileWriter(writeWordInVocabulary, true);
        BufferedWriter writeWordInFile = new BufferedWriter(fileWriter);
        System.out.println("Words is Write");
        System.out.println("      -       ");
        writeWordInFile.write(" Russ: " + russInputWord + "||" + "Eng: " + englishInputWord + "||" +
                "De: " + deutschInputWord + "\n");
        writeWordInFile.flush();
    }

    public static void showWriteAddWordInFile() throws IOException {
        FileReader fileReadAddToVocabulary = new FileReader(writeWordInVocabulary);
        buf = new char[10000];
        int c;// посимвольное чтение - by character reading
        try {
                    c = fileReadAddToVocabulary.read(buf);
                    buf = Arrays.copyOf(buf, c);
                System.out.print(buf);
                System.out.print("\n");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    public static void searchWordInAddFile() throws IOException {
        FileReader fileReadAddToVocabulary = new FileReader(writeWordInVocabulary);
        buf = new char[10000];
        int c;// посимвольное чтение - by character reading
            c = fileReadAddToVocabulary.read(buf);
            buf = Arrays.copyOf(buf, c);

        BufferedReader searchWord = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the required Word: ");
        String resultSearchWord = searchWord.readLine();
        //resultSearchWord.read
        if (resultSearchWord.equals(buf)) {
            System.out.println("Show searching Word: ");
            System.out.println(writeWordInVocabulary+"||"+resultSearchWord);
        } else {
            System.out.println("Word not found.");
        }
    }
}

