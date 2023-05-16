package name.mrkandreev.code;

public class IndexOfWithJumpSubstringCounterImpl implements SubstringCounter {
    @Override
    public int count(String string, String substring) {
        int count = 0;

        int idx;
        for(int pos = 0; (idx = string.indexOf(substring, pos)) != -1; pos = idx + substring.length()) {
            ++count;
        }

        return count;
    }
}
