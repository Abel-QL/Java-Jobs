import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    private static int counterSnack = 0;
    private final int snackId;
    private String snackName;
    private double snackPrice;

    public Snack() {
        snackId = ++Snack.counterSnack;
    }

    public Snack(String snackName, double snackPrice) {
        this(); //llama al constructor vacío de arriba que inicializa el snakId y debe ser la primera línea en el constructor
        this.snackName = snackName;
        this.snackPrice = snackPrice;
    }

    public static int getCounterSnack() {
        return counterSnack;
    }

    public int getSnackId() {
        return snackId;
    }

    public String getSnackName() {
        return snackName;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public double getSnackPrice() {
        return snackPrice;
    }

    public void setSnackPrice(double snackPrice) {
        this.snackPrice = snackPrice;
    }

    @Override
    public String toString() {
        return " Snack{ ID: %d, Name: %s, Price: %.2f RD$}".formatted(snackId, this.snackName, this.snackPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return this.snackId == snack.snackId && Double.compare(snackPrice, snack.snackPrice) == 0 && Objects.equals(snackName, snack.snackName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snackId, snackName, snackPrice);
    }
}


