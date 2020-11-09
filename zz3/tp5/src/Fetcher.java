import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Fetcher {

    public Class className;

    private Field[] fields;
    private Constructor[] constructors;
    private Method[] methods;

    public Map<String, ArrayList<String>> scope_Fields = new HashMap<>();
    public Map<String, ArrayList<String>> scope_Methods =  new HashMap<>();
    public Map<String, ArrayList<String>> scope_Ctors =  new HashMap<>();

    public Set<String> dependencies = new HashSet<>();

    public Fetcher(Class className) {
        this.className = className;
        fields = className.getDeclaredFields();
        methods = className.getDeclaredMethods();
        constructors = className.getDeclaredConstructors();
    }

    public String getEquivalence(String type, Set<String> dependencies){
        if (type.equals("java.lang.String")) {
            dependencies.add("#include <string>");
            return "std::string";
        }
        if (type.equals(("java.lang.Integer"))){
            return "int";
        }
        return type;
    }

    public void fetchFields(){
        for (Field field : fields){
            String[] splitedField = field.toString().split(" ");
            String scope = splitedField[0]; // Get the scope of the field
            String type = splitedField[1];
            String attribute = field.getName();

            if (!scope_Fields.containsKey(scope)) {
                scope_Fields.put(scope, new ArrayList<>());
            }
            scope_Fields.get(scope).add(new StringBuilder(getEquivalence(type, dependencies)).append(" ").append(attribute).toString());
        }
    }

    public void fetchMethods(){
        for (Method method : methods){
            String[] splitedMethod = method.toString().split(" ");
            String scope = splitedMethod[0];
            String returnType = splitedMethod[1];
            String methodName = splitedMethod[2].split("\\.")[1];;

            if (!scope_Methods.containsKey(scope)) {
                scope_Methods.put(scope, new ArrayList<>());
            }
            scope_Methods.get(scope).add(new StringBuilder(getEquivalence(returnType, dependencies)).append(" ").append(methodName).toString());
        }
    }

    public void fetchConstructors(){
        for (Constructor constructor : constructors){
            String[] splitedCtors = constructor.toString().split(" ");
            String scope = splitedCtors[0];
            String ctorName = splitedCtors[1];

            if (!scope_Ctors.containsKey(scope)) {
                scope_Ctors.put(scope, new ArrayList<>());
            }
            scope_Ctors.get(scope).add(new StringBuilder().append(ctorName).toString());
        }
    }
}