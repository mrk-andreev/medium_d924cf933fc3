package name.mrkandreev.code;

import java.util.regex.Pattern;

public class RegExSubstringCounterImpl implements SubstringCounter {
    @Override
    public int count(String string, String substring) {
        return (int) Pattern.compile(Pattern.quote(substring))
                .matcher(string)
                .results()
                .count();
    }
}
