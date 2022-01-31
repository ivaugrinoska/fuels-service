package mk.ukim.finki.fuelsservice.entity.exceptions;

public class FuelNotFoundException extends RuntimeException {
    public FuelNotFoundException(Long id) {
        super(String.format("Fuel with id %d not found.",id));
    }
}
