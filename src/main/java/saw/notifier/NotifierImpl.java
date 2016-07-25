package saw.notifier;

public class NotifierImpl implements Notifier{
    private String name;
    private String buffer;

    public NotifierImpl(String name) {
        this.name = name;
        this.buffer = "";
    }

    @Override
    public void print() {
        System.out.println("Notifier " + name + ": {\n" + buffer + "}");
    }

    @Override
    public void addMessage(String text) {
        buffer = buffer + "      " + text + "\n";
    }
}
