package name.mrkandreev.code;

public class IndexOfSubstringCounterImpl implements SubstringCounter {
    @Override
    public int count(String string, String substring) {
        int pos = -1;
        int count = 0;

        while ((pos = string.indexOf(substring, pos+1)) != -1) {
            count++;
        }

        return count;
    }
}
