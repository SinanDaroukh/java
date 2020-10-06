package arwoon_shlaka;

public class EmptyException extends Exception {

    @Override
    public String getMessage(){
        return "An Empty Exception has occurred !";
    }
}