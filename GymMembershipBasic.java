class GymMemberBasic {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMemberBasic(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("Invalid monthly fee");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }
}

class PremiumMemberBasic extends GymMemberBasic {

    private String trainerName;

    public PremiumMemberBasic(String memberId, int monthlyFee,
                              String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
}

public class GymMembershipBasic {

    public static String signUpBatch(String[] memberIds, int monthlyFee) {

        int signedUp = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new GymMemberBasic(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {

        GymMemberBasic member =
                new GymMemberBasic("MEM1", 1000);

        member.attendSession();
        member.attendSession();

        System.out.println(member.getSessionsAttended());

        String[] ids = {
            "MEM1",
            "GM1",
            "MEM2",
            " ",
            "MEM3"
        };

        System.out.println(signUpBatch(ids, 1000));
    }
}