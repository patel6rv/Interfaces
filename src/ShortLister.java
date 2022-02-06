import java.util.ArrayList;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;

public class ShortLister {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<Object> words = new ArrayList<>();


        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String[] lineInArray;
                while (reader.ready()) {
                    rec = reader.readLine();
                    lineInArray = rec.split(", ");
                    for (String word : lineInArray) {
                        words.add(word);
                    }
                }
                reader.close();

                List<Object> filteredWords = collectAll(new ShortWordFilter(), words);
                for (Object filtered: filteredWords) {
                    System.out.println(filtered);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Object> collectAll(Filter filter, List<Object> objects)
    {
        ArrayList<Object> list = new ArrayList<>();
        for(Object rec: objects)
        {
            if (filter.accept(rec))
            {
                list.add(rec);
            }
        }

        return list;
    }
}
