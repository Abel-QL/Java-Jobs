package src.Services;

import src.Domain.Snack;

import java.util.List;

public interface IServiceSnacks {
    void addSnack(Snack snack);

    void showSnack();

    List<Snack> getSnacks();
}
