abstract class KitchenToolSmart {

    private int speedLevel;

    public KitchenToolSmart() {
        speedLevel = 1;
    }

    public abstract String prepare();

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {

        if (speedLevel < 1 || speedLevel > 5) {
            throw new IllegalArgumentException(
                "Speed level must be between 1 and 5"
            );
        }

        this.speedLevel = speedLevel;
    }
}


interface WashableSmart {

    String clean();
}


class BlenderSmart
        extends KitchenToolSmart
        implements WashableSmart {

    public BlenderSmart() {
        super();
    }

    @Override
    public String prepare() {
        return "Blending at speed "
                + getSpeedLevel();
    }

    @Override
    public String clean() {
        return "Blender rinsed and dried";
    }
}


public class SmartKitchenAssistant {

    public static void main(String[] args) {

        BlenderSmart b =
                new BlenderSmart();

        b.setSpeedLevel(3);

        System.out.println(
            b.getSpeedLevel()
        );

        try {
            b.setSpeedLevel(9);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid speed level");
        }

        System.out.println(
            b.getSpeedLevel()
        );

        System.out.println(
            b.prepare()
        );

        System.out.println(
            b.clean()
        );
    }
}