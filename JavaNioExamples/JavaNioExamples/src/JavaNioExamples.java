import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class JavaNioExamples {

    final static String SEP = File.separator;

    public static void main(String[] args) {
        String stringPath = "." + SEP + "examples" + SEP + "emptyFile.txt";
        Path workingPath = Paths.get(stringPath);
        System.out.println("Working path: " + workingPath);
        createFileInDirectory(workingPath);

        workingPath = changeWorkingPath("." + SEP + "examples" + SEP + "sampleFile.txt");


        createFileInDirectory(workingPath);

        writeListToFile(workingPath, Arrays.asList("Line 1: testing", "Line 2: ToDo:", "Line 3: Do something"));

        try {
            readFileLineToLine(workingPath);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getLocalizedMessage());
        }


    }

    public static Path changeWorkingPath(String stringPath) {
        return Paths.get(stringPath);
    }

    public static void createFileInDirectory(Path path) {
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
                System.out.println("File created correctly.");
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getLocalizedMessage());
            }

        } else {

            System.out.println("File has already been created.");
        }
    }

    public static void writeListToFile(Path path, List<String> list) {
        try {
            Files.write(
                    path,
                    list,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
            System.out.println("List writes correctly.");
        } catch (IOException e) {
            System.out.println("Error writing the list: " + e.getLocalizedMessage());
        }
    }

    public static void readFileLineToLine(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (String line : lines) {
            System.out.println(line);
        }
    }

}
