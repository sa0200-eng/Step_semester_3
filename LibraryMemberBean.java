import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LibraryMemberBean {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    private boolean membershipIdSet = false;

    public LibraryMemberBean() {
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {

        if (!membershipIdSet) {
            membershipId = id;
            membershipIdSet = true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {

        try {
            MessageDigest digest =
                MessageDigest.getInstance("SHA-256");

            byte[] hash =
                digest.digest(answer.getBytes(StandardCharsets.UTF_8));

            StringBuilder result = new StringBuilder();

            for (byte b : hash) {
                result.append(String.format("%02x", b));
            }

            securityAnswer = result.toString();

        } catch (NoSuchAlgorithmException e) {
            securityAnswer = Integer.toHexString(answer.hashCode());
        }
    }

    public static void main(String[] args) {

        LibraryMemberBean m = new LibraryMemberBean();

        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);

        System.out.println(m.getMembershipId());

        m.setMembershipId("FAKE-0000");

        System.out.println(m.getMembershipId());

        System.out.println(m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain");
    }
}