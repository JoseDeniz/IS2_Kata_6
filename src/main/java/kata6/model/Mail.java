package kata6.model;

public class Mail {

    private final String address;

    public Mail(String address) {
        this.address = address;
    }

    public String getDomain() {
        return address.substring(address.indexOf("@") + 1);
    }

    public String address() {
        return address;
    }
}
