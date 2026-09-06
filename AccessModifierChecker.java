public class AccessModifierChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        if (fieldModifier.equals("private")) {
            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if (fieldModifier.equals("default")) {
            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE") ||
                accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {

        int privateAllowed = 0;
        int privateDenied = 0;

        int defaultAllowed = 0;
        int defaultDenied = 0;

        int protectedAllowed = 0;
        int protectedDenied = 0;

        int publicAllowed = 0;
        int publicDenied = 0;

        for (String[] attempt : attempts) {

            String modifier = attempt[0];
            String context = attempt[1];

            boolean allowed =
                classifyAccess(modifier, context).equals("ALLOWED");

            if (modifier.equals("private")) {
                if (allowed) privateAllowed++;
                else privateDenied++;
            }
            else if (modifier.equals("default")) {
                if (allowed) defaultAllowed++;
                else defaultDenied++;
            }
            else if (modifier.equals("protected")) {
                if (allowed) protectedAllowed++;
                else protectedDenied++;
            }
            else if (modifier.equals("public")) {
                if (allowed) publicAllowed++;
                else publicDenied++;
            }
        }

        return "private: " + privateAllowed + " allowed / "
                + privateDenied + " denied | default: "
                + defaultAllowed + " allowed / " + defaultDenied
                + " denied | protected: " + protectedAllowed
                + " allowed / " + protectedDenied + " denied | public: "
                + publicAllowed + " allowed / " + publicDenied + " denied";
    }

    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            String modifier = attempts[i][0];
            String context = attempts[i][1];

            if (classifyAccess(modifier, context).equals("DENIED")) {
                return modifier + " via " + context
                    + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }

    public static void main(String[] args) {

        System.out.println(
            classifyAccess("private", "SAME_CLASS")
        );

        System.out.println(
            classifyAccess("protected", "DIFFERENT_PACKAGE")
        );

        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
            summarizeByModifier(attempts)
        );

        String[][] orderedAttempts = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(
            firstDeniedAttempt(orderedAttempts)
        );

        String[][] allowedAttempts = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(
            firstDeniedAttempt(allowedAttempts)
        );
    }
}