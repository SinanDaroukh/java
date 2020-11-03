import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String cpp_file;
        String java_file = args[0];
	    if ( args.length > 2){
	        System.err.println("Usage : main.java Class.java [Class.cpp]");
	        throw new IllegalArgumentException();
        }
	    else if (args.length == 2){
	        cpp_file = args[1];
        }
	    else {
	        cpp_file = java_file;
        }

        Class c = null;
        try {
            c = Class.forName(java_file);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c.getName());

        Field[] fields = c.getDeclaredFields();

        Constructor[] constructors = c.getConstructors();

        System.out.println(Arrays.toString(constructors));

        System.out.println(Arrays.toString(fields));

        //Todp - File writer



    }
}
