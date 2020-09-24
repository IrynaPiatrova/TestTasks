import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VersionValidatorTask {

    private static final String currentVersion = "3.1.0";

    public static void main(String[] args) {
        System.out.println("isVersionValid = " + isVersionValid("3.0.0"));
    }

    protected static boolean isVersionValid(String version) {
        int lengthVersion = version.length();
        int lengthCurrentVersion = currentVersion.length();

        if (lengthCurrentVersion != lengthVersion) {
            return false;
        }

        if (currentVersion.equals(version)) {
            return true;
        }

        List<Integer> versionListValues = getIntegerListValuesByString(version);
        List<Integer> currentVersionListValues = getIntegerListValuesByString(currentVersion);

        for (int i = 0; i < versionListValues.size() - 1; i++) {
            Integer versionValue = versionListValues.get(i);
            Integer currentVersionValue = currentVersionListValues.get(i);

            if (currentVersionValue < versionValue) {
                return true;
            }
        }

        return false;
    }

    private static List<Integer> getIntegerListValuesByString(String version) {
        String[] split = version.split("\\.");
        return Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toList());
    }
}
