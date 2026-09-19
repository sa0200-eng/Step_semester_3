class GymMemberInheritance {

    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMemberInheritance(String memberId, int monthlyFee) {

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

    public void displayInfo() {
        System.out.println(
            "Standard Member | Sessions: " + sessionsAttended
        );
    }
}


class PremiumMemberInheritance extends GymMemberInheritance {

    protected String trainerName;

    public PremiumMemberInheritance(String memberId, int monthlyFee,
                                    String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Premium Member | Trainer: " + trainerName +
            " | Sessions: " + sessionsAttended
        );
    }
}


class EliteMemberInheritance extends PremiumMemberInheritance {

    private String lockerNumber;

    public EliteMemberInheritance(String memberId, int monthlyFee,
                                  String trainerName,
                                  String lockerNumber) {

        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Elite Member | Trainer: " + trainerName +
            " | Locker: " + lockerNumber +
            " | Sessions: " + sessionsAttended
        );
    }
}


class GroupClassMemberInheritance extends GymMemberInheritance {

    private String className;

    public GroupClassMemberInheritance(String memberId, int monthlyFee,
                                       String className) {

        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Group Class Member | Class: " + className +
            " | Sessions: " + sessionsAttended
        );
    }
}


public class GymMembershipInheritance {

    public static String classifyGeneration(
            GymMemberInheritance member) {

        if (member instanceof EliteMemberInheritance) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof GroupClassMemberInheritance) {
            return "Hierarchical sibling (independent branch)";
        }

        return "Standard/Premium branch";
    }


    public static int getTotalSessionsAttended(
            GymMemberInheritance[] members) {

        int total = 0;

        for (GymMemberInheritance member : members) {
            total += member.getSessionsAttended();
        }

        return total;
    }


    public static void main(String[] args) {

        GymMemberInheritance member =
                new GymMemberInheritance("MEM1", 1000);

        PremiumMemberInheritance premium =
                new PremiumMemberInheritance(
                    "MEM2",
                    2000,
                    "Coach Riya"
                );

        EliteMemberInheritance elite =
                new EliteMemberInheritance(
                    "MEM3",
                    3000,
                    "Coach Arjun",
                    "L12"
                );

        GroupClassMemberInheritance group =
                new GroupClassMemberInheritance(
                    "MEM4",
                    1500,
                    "Zumba"
                );

        member.displayInfo();
        premium.displayInfo();
        elite.displayInfo();
        group.displayInfo();

        System.out.println(
            classifyGeneration(elite)
        );

        System.out.println(
            classifyGeneration(group)
        );

        premium.attendSession();
        premium.attendSession();
        premium.attendSession();

        elite.attendSession();
        elite.attendSession();

        group.attendSession();
        group.attendSession();
        group.attendSession();
        group.attendSession();

        GymMemberInheritance[] members = {
            premium,
            elite,
            group
        };

        System.out.println(
            getTotalSessionsAttended(members)
        );
    }
}