package cat.aubricoc.anagramicpoem.utils;

import java.text.Normalizer;
import java.util.Arrays;

public class TextUtils {

	public static String normalizeCleanAndSort(String text) {
		text = normalize(text);
		text = clean(text);
		text = sort(text);
		return text;
	}

	public static String normalize(String text) {
		return Normalizer.normalize(text, Normalizer.Form.NFD).toLowerCase();
	}

	public static String clean(String text) {
		return text.replaceAll("[^a-z]", "");
	}

	public static String sort(String text) {
        char[] chars = text.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
	}
}
