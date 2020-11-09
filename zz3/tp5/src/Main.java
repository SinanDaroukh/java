import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, UnsupportedEncodingException {
        String cpp_file;
        String java_file = args[0];
        Boolean flag = false;

	    if ( args.length > 3){
	        System.err.println("Usage : main.java Class.java [Class.cpp]");
	        throw new IllegalArgumentException();
        }
	    else if (args.length == 3){
            cpp_file = args[1];
            if (args[2].equals("--stdout")){
                flag = true;
            }
        }
	    else if (args.length == 2){
	        cpp_file = args[1];
        }
	    else {
	        cpp_file = java_file;
        }
        Fetcher r = new Fetcher(Class.forName(java_file));
        r.fetchFields();
        r.fetchMethods();
        r.fetchConstructors();

        CPP_Writer builder = new CPP_Writer(new StringBuilder(), r, cpp_file);
        builder.createFile(flag);

    }
}
