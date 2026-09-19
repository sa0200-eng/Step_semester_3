class GymMemberAttendance {

    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMemberAttendance(String memberId, int monthlyFee) {

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


    public String displayInfo() {

        return "Standard | Sessions: "
                + sessionsAttended;
    }
}


class PremiumMemberAttendance extends GymMemberAttendance {

    private String trainerName;

    public PremiumMemberAttendance(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }


    public String getTrainerName() {
        return trainerName;
    }


    @Override
    public String displayInfo() {

        return "Premium | Trainer: "
                + trainerName
                + " | Sessions: "
                + sessionsAttended;
    }
}


public class GymAttendanceAnnouncer {

    public static String batchPrint(
            GymMemberAttendance[] members) {

        StringBuilder result =
                new StringBuilder();

        for (GymMemberAttendance member : members) {

            result.append(
                member.displayInfo()
            );

            if (member instanceof PremiumMemberAttendance) {

                PremiumMemberAttendance premium =
                        (PremiumMemberAttendance) member;

                result.append(
                    " [Trainer via downcast: "
                    + premium.getTrainerName()
                    + "]"
                );
            }

            result.append(" | ");
        }

        return result.toString();
    }


    public static void main(String[] args) {

        GymMemberAttendance standard =
                new GymMemberAttendance(
                    "MEM6",
                    1000
                );

        PremiumMemberAttendance premium =
                new PremiumMemberAttendance(
                    "MEM7",
                    2000,
                    "Coach Riya"
                );

        GymMemberAttendance[] members = {
            standard,
            premium
        };

        System.out.println(
            batchPrint(members)
        );
    }
}