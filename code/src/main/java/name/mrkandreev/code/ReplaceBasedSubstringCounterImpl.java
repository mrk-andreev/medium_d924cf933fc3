package name.mrkandreev.code;

public class ReplaceBasedSubstringCounterImpl implements SubstringCounter {
    @Override
    public int count(String string, String substring) {
        return (string.length() - string.replace(substring, "").length()) / substring.length();
    }
}
