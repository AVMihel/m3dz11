package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmsManagerTest {

    //Ноль добавлений
    @Test
    public void testNull() {
        FilmsManager manager = new FilmsManager();


        String[] expected = {};
        String[] actual = manager.findFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    //Одно добавление
    @Test
    public void testOne() {
        FilmsManager manager = new FilmsManager();

        manager.addFilms("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    //Несколько добавлений
    @Test
    public void testSeveral() {
        FilmsManager manager = new FilmsManager();

        manager.addFilms("Бладшот");
        manager.addFilms("Вперёд");
        manager.addFilms("Отель'Белград'");
        manager.addFilms("Джентельмены");

        String[] expected = {"Бладшот", "Вперёд", "Отель'Белград'", "Джентельмены"};
        String[] actual = manager.findFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    //Добавляем 3 при лимите 5
    @Test
    void testLastFilms() {
        FilmsManager manager = new FilmsManager();
        manager.addFilms("Бладшот");
        manager.addFilms("Вперёд");
        manager.addFilms("Отель'Белград'");

        String[] expected = {"Отель'Белград'", "Вперёд", "Бладшот"};
        String[] actual = manager.findLastFilms();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Добавляем 5 при лимите 5
    @Test
    void testLastFilmsEqualLimit() {
        FilmsManager manager = new FilmsManager();
        manager.addFilms("Бладшот");
        manager.addFilms("Вперёд");
        manager.addFilms("Отель'Белград'");
        manager.addFilms("Джентельмены");
        manager.addFilms("Человек невидимка");

        String[] expected = {"Человек невидимка", "Джентельмены", "Отель'Белград'", "Вперёд", "Бладшот"};
        String[] actual = manager.findLastFilms();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Добавляем 6 при лимите 5
    @Test
    void testLastFilmsMoreLimit() {
        FilmsManager manager = new FilmsManager();
        manager.addFilms("Бладшот");
        manager.addFilms("Вперёд");
        manager.addFilms("Отель'Белград'");
        manager.addFilms("Джентельмены");
        manager.addFilms("Человек невидимка");
        manager.addFilms("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек невидимка", "Джентельмены", "Отель'Белград'", "Вперёд"};
        String[] actual = manager.findLastFilms();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Добавляем 2 при установленном лимите 3
    @Test
    void testLastFilmsLessCustomLimit() {
        FilmsManager manager = new FilmsManager(3);
        manager.addFilms("Бладшот");
        manager.addFilms("Вперёд");

        String[] expected = {"Вперёд", "Бладшот"};
        String[] actual = manager.findLastFilms();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Добавляем 3 при установленном лимите 3
    @Test
    void testLastFilmsEqualCustomLimit() {
        FilmsManager manager = new FilmsManager(3);
        manager.addFilms("Бладшот");
        manager.addFilms("Вперёд");
        manager.addFilms("Отель'Белград'");

        String[] expected = {"Отель'Белград'", "Вперёд", "Бладшот"};
        String[] actual = manager.findLastFilms();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Добавляем 7 при установленном лимите 6
    @Test
    void testLastFilmsMoreCustomLimit() {
        FilmsManager manager = new FilmsManager(6);
        manager.addFilms("Бладшот");
        manager.addFilms("Вперёд");
        manager.addFilms("Отель'Белград'");
        manager.addFilms("Джентельмены");
        manager.addFilms("Человек невидимка");
        manager.addFilms("Тролли. Мировой тур");
        manager.addFilms("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек невидимка", "Джентельмены", "Отель'Белград'", "Вперёд"};
        String[] actual = manager.findLastFilms();

        Assertions.assertArrayEquals(expected, actual);
    }


}
