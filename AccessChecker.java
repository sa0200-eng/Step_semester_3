public class AccessChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {

        // SAME_CLASS
        if (accessorContext.equals("SAME_CLASS")) {
            return "ALLOWED";
        }

        // SAME_PACKAGE
        if (accessorContext.equals("SAME_PACKAGE")) {
            if (fieldModifier.equals("private")) {
                return "DENIED";
            }
            return "ALLOWED";
        }

        // DIFFERENT_PACKAGE
        if (accessorContext.equals("DIFFERENT_PACKAGE")) {
            if (fieldModifier.equals("public")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        // SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE
        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
            if (fieldModifier.equals("public") ||
                fieldModifier.equals("protected")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        // SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE
        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {
            if (fieldModifier.equals("public")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        return "DENIED";
    }

    public static String summarizeBatch(String[][] attempts) {

        int allowed = 0;
        int denied = 0;

        for (String[] attempt : attempts) {

            String result = classifyAccess(attempt[0], attempt[1]);

            if (result.equals("ALLOWED")) {
                allowed++;
            } else {
                denied++;
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }
}