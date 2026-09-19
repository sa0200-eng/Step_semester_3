abstract class DeliveryNoteLog {

    protected String trackingId;

    public DeliveryNoteLog(String trackingId) {
        this.trackingId = trackingId;
    }

    public abstract String confirmDelivery();


    public String confirmDelivery(String signature) {

        return confirmDelivery()
                + ", signed by " + signature;
    }
}


class ParcelNoteLog
        extends DeliveryNoteLog {

    public ParcelNoteLog(String trackingId) {
        super(trackingId);
    }

    @Override
    public String confirmDelivery() {
        return "Parcel "
                + trackingId
                + " delivered";
    }
}


class LetterNoteLog
        extends DeliveryNoteLog {

    public LetterNoteLog(String trackingId) {
        super(trackingId);
    }

    @Override
    public String confirmDelivery() {
        return "Letter "
                + trackingId
                + " delivered";
    }
}


public class PackageDropOffLog {

    public static void logAll(
            DeliveryNoteLog[] notes) {

        for (DeliveryNoteLog note : notes) {
            System.out.println(
                note.confirmDelivery()
            );
        }
    }


    public static void main(String[] args) {

        ParcelNoteLog p =
                new ParcelNoteLog("TRK-1");

        LetterNoteLog l =
                new LetterNoteLog("TRK-2");

        System.out.println(
            p.confirmDelivery()
        );

        System.out.println(
            p.confirmDelivery("J. Smith")
        );


        DeliveryNoteLog ref = p;

        logAll(
            new DeliveryNoteLog[]{
                ref,
                l
            }
        );
    }
}