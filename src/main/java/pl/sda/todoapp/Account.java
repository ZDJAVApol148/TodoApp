package pl.sda.todoapp;

public class Account {

    private String number;
    private String name;

    public Account(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
