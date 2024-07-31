package exercise.exception;

// BEGIN
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String messeage) {
        super(messeage);
    }
}
// END
