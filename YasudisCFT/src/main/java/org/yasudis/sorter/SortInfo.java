package YasudisCFT.src.main.java.org.yasudis.sorter;

import java.util.List;

public class SortInfo {
    private Class<? extends Comparable<?>> inputType;
    private SortOrder sortOrder;
    private String outputFileName;
    private List<String> inputFileNames;

    public SortInfo() {
    }

    public SortInfo(Class<? extends Comparable<?>> inputType, SortOrder sortOrder, String outputFileName, List<String> inputFileNames) {
        this.inputType = inputType;
        this.sortOrder = sortOrder;
        this.inputFileNames = inputFileNames;
    }

    public Class<? extends Comparable<?>> getInputType() {
        return inputType;
    }

    public void setInputType(Class<? extends Comparable<?>> inputType) {
        this.inputType = inputType;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFilename) {
        this.outputFileName = outputFilename;
    }

    public List<String> getInputFileNames() {
        return inputFileNames;
    }

    public void setInputFileNames(List<String> inputFilenames) {
        this.inputFileNames = inputFilenames;
    }
}
