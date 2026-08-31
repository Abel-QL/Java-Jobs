package Services;

import Domain.Snack;

import java.util.List;

public interface IServiceSnacks {
    void addSnack(Snack snack);

    void showSnack();

    List<Snack> getSnacks();
}
