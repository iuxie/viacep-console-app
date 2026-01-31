package br.com.iurexavier.viacep.exception;

public class InvalidCepException extends RuntimeException {
    public InvalidCepException(String message) {
        super(message);
    }
}
