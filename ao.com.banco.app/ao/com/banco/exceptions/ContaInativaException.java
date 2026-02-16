package ao.com.banco.exceptions;

public class ContaInativaException extends RuntimeException {
    public ContaInativaException(String message) {
        super(message);
    }
}
