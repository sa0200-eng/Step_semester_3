abstract class OrchestraInstrument {

    public OrchestraInstrument() {
    }

    public abstract String play();
}


class StringInstrumentOrchestra
        extends OrchestraInstrument {

    public StringInstrumentOrchestra() {
        super();
    }

    @Override
    public String play() {
        return "Strumming the strings";
    }
}


class ViolinOrchestra
        extends StringInstrumentOrchestra {

    public ViolinOrchestra() {
        super();
    }

    @Override
    public String play() {
        return super.play()
                + ", with a bow drawn across four strings";
    }
}


public class OrchestraWarmUpRoutine {

    public static void main(String[] args) {

        StringInstrumentOrchestra s =
                new StringInstrumentOrchestra();

        ViolinOrchestra v =
                new ViolinOrchestra();

        System.out.println(s.play());
        System.out.println(v.play());
    }
}