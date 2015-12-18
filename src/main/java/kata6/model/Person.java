package kata6.model;

public class Person {

    private final Mail mail;
    private final String name;

    public Person(String name, Mail mail) {
        this.name = name;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public Mail getMail() {
        return mail;
    }

}
