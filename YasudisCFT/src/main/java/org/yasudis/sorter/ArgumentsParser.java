package YasudisCFT.src.main.java.org.yasudis.sorter;

import java.util.ArrayList;
import java.util.List;

public class ArgumentsParser {
    private static SortInfo sortInfo;

    private ArgumentsParser() {
    }

    public static SortInfo getSortInfo() {

        return sortInfo;
    }

    public static void parse(String[] args) throws IllegalArgumentException {
        sortInfo = new SortInfo();
        sortInfo.setSortOrder(SortOrder.ASC);

        if (args.length < 3) {
            throw new IllegalArgumentException("Недостаточно аргументов");
        }

        int elementInCommand = 0;
        int commandSize = 0;

        if (args[0].equals("-d") || args[0].equals("-a")) {
            if (args[0].equals("-d")) {
                sortInfo.setSortOrder(SortOrder.DESC);
            }

            elementInCommand++;
            commandSize++;

            if (args[1].equals("-i")) {
                sortInfo.setInputType(Integer.class);
                commandSize++;
                elementInCommand++;
            } else if ((args[1].equals("-s"))) {
                sortInfo.setInputType(String.class);
                commandSize++;
                elementInCommand++;
            }
        } else if (args[0].equals("-i")) {
            sortInfo.setInputType(Integer.class);
            commandSize++;
            elementInCommand++;
        } else if ((args[0].equals("-s"))) {
            sortInfo.setInputType(String.class);
            commandSize++;
            elementInCommand++;
        }

        if (commandSize < 2) {
            throw new IllegalArgumentException("Слишком мало аргументов.");
        }

        sortInfo.setOutputFileName(parseOutputFilename(args[elementInCommand]));
        sortInfo.setInputFileNames(parseInputFilenames(args, elementInCommand + 1));
    }

    private static String parseOutputFilename(String commandLine) throws IllegalArgumentException {
        if (!commandLine.endsWith(".txt")) {
            throw new IllegalArgumentException("Недопустимое расширение файла " + commandLine);
        }

        return commandLine;
    }

    private static List<String> parseInputFilenames(String[] inputFilenamesLine, int element) throws
            IllegalArgumentException {
        List<String> inputFilenamesList = new ArrayList<>();

        for (int i = element; i < inputFilenamesLine.length; i++) {
            if (!inputFilenamesLine[i].endsWith(".txt")) {
                System.err.println("Недопустимое расширение файла " + inputFilenamesLine[i] +
                        ". Данные файла будут пропущены");
            } else {
                inputFilenamesList.add(inputFilenamesLine[i]);
            }
        }

        if (inputFilenamesList.isEmpty()) {
            throw new IllegalArgumentException("Отсутствуют правильно указанные файлы входных данных.");
        }

        return inputFilenamesList;
    }
}
