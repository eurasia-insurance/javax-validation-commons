package tech.lapsa.javax.validation.constraints;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tech.lapsa.javax.validation.ValidHumanName;

public class ValidHumanNameConstraintValidator implements ConstraintValidator<ValidHumanName, String> {

    private static final String ENGLISH_PATTERN = "^[A-Z\\ \\-]+$";
    private static final String RUSSIAN_PATTERN = "^[А-ЯЁё\\ \\-]+$";
    private static final String KAZAKH_PATTERN = "^[А-ЯЁёӘҒҚҢӨҰҮҺІ\\ \\-]+$";

    private static final Map<String, Pattern> languagePatterns = new HashMap<>();

    static {
	final int flags = Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS | Pattern.UNICODE_CASE;
	languagePatterns.put("en", Pattern.compile(ENGLISH_PATTERN, flags));
	languagePatterns.put("ru", Pattern.compile(RUSSIAN_PATTERN, flags));
	languagePatterns.put("kk", Pattern.compile(KAZAKH_PATTERN, flags));
    }

    private String[] languagesAllowed;

    @Override
    public void initialize(final ValidHumanName a) {
	languagesAllowed = a.languagesAllowed();
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	if (value.trim().isEmpty())
	    return true;
	for (final String lang : languagesAllowed) {
	    final Pattern p = languagePatterns.get(lang);
	    if (p != null && p.matcher(value.toString()).matches())
		return true;
	}
	return false;
    }
}