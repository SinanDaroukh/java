import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

import static java.lang.System.lineSeparator;

public class CPP_Writer {

    public StringBuilder mainContent;
    public Fetcher fetcher;
    public String cpp_file;

    public CPP_Writer(StringBuilder mainContent, Fetcher f, String cpp_file) {
        this.mainContent = mainContent;
        this.fetcher= f;
        this.cpp_file = cpp_file;
    }

    public void writeGuardian(){
        mainContent.append("// --- The ULTIMATE Guardian ").append(lineSeparator());
        mainContent.append("#pragma once").append(lineSeparator());
    }

    public void writeDependencies(){
        mainContent.append("// --- Libraries").append(lineSeparator());
        for (String dependency : fetcher.dependencies)
            mainContent.append(dependency).append(lineSeparator());
        mainContent.append(lineSeparator());
    }

    public void writeClassSkeleton(){
        mainContent.append("// --- Skeleton").append(lineSeparator());
        mainContent.append("class").append(" ").append(cpp_file).append("{").append(lineSeparator());

        mainContent.append("// \t --- Attributes --- ").append(lineSeparator());
        for (Map.Entry<String, ArrayList<String>> el : fetcher.scope_Fields.entrySet()){
            mainContent.append("\t").append(el.getKey()).append(":").append(lineSeparator());
            for ( String attribute : el.getValue())
                mainContent.append("\t\t").append(attribute).append(";").append(lineSeparator());
        }

        mainContent.append("// \t --- Constructors --- ").append(lineSeparator());
        for (Map.Entry<String, ArrayList<String>> el : fetcher.scope_Ctors.entrySet()){
            mainContent.append("\t").append(el.getKey()).append(":").append(lineSeparator());
            for ( String attribute : el.getValue())
                mainContent.append("\t\t").append(attribute).append("{};").append(lineSeparator());
        }

        mainContent.append("// \t --- Methods --- ").append(lineSeparator());
        for (Map.Entry<String, ArrayList<String>> el : fetcher.scope_Methods.entrySet()){
            mainContent.append("\t").append(el.getKey()).append(":").append(lineSeparator());
            for ( String attribute : el.getValue())
                mainContent.append("\t\t").append(attribute).append("{};").append(lineSeparator());
        }

        mainContent.append("};").append(lineSeparator());
    }

    public void createFile(boolean flag) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(cpp_file + ".hpp", "UTF-8");

        writeGuardian();
        writeDependencies();
        writeClassSkeleton();

        if ( flag ){
            System.out.print(mainContent);
        }

        writer.print(mainContent);
        writer.close();

        System.out.println("File " + cpp_file + ".hpp" + " created");
    }
}
