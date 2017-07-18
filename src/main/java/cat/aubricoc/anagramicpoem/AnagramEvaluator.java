package cat.aubricoc.anagramicpoem;

import java.util.List;

import cat.aubricoc.anagramicpoem.utils.TextUtils;

public class AnagramEvaluator {

	private static final AnagramEvaluator INSTANCE = new AnagramEvaluator();

	private AnagramEvaluator() {
		super();
	}

	public static AnagramEvaluator getInstance() {
		return INSTANCE;
	}

	public boolean compareOneToMany(String one, List<String> many) {
		String oneEncoded = TextUtils.normalizeCleanAndSort(one);
		for (String other : many) {
			String otherEncoded = TextUtils.normalizeCleanAndSort(other);
			if (!oneEncoded.equals(otherEncoded)) {
				return false;
			}
		}
		return true;
	}
}
