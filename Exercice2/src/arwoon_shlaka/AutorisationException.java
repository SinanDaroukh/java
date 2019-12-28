package arwoon_shlaka;

public class AutorisationException extends Exception {

    String message;

    AutorisationException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "An Autorisation Exception has occurred ! - Message : " + message;
    }
}
