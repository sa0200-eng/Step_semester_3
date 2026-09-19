abstract class ToyBoxToy {

    private static int count = 1000;
    private final String toyId;

    protected ToyBoxToy(String name) {
        count++;
        toyId = "TOY-" + count;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }
}


class ToyCarBox extends ToyBoxToy {

    private String name;

    public ToyCarBox(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}


class ToyRobotBox extends ToyBoxToy {

    private String name;

    public ToyRobotBox(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Beep boop!";
    }
}


public class TalkingToyBox {

    public static void main(String[] args) {

        ToyCarBox c = new ToyCarBox("Speedster");
        ToyRobotBox r = new ToyRobotBox("Bolt");

        System.out.println(c.makeSound());
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}