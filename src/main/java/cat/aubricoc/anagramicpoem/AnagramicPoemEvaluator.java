package cat.aubricoc.anagramicpoem;

import java.util.ArrayList;
import java.util.List;

import cat.aubricoc.anagramicpoem.model.Poem;
import cat.aubricoc.anagramicpoem.model.Verse;
import cat.aubricoc.anagramicpoem.parser.PoemParser;

public class AnagramicPoemEvaluator {

	private static final AnagramicPoemEvaluator INSTANCE = new AnagramicPoemEvaluator();

	private AnagramicPoemEvaluator() {
		super();
	}

	public static AnagramicPoemEvaluator getInstance() {
		return INSTANCE;
	}

	public boolean isAnagramicPoem(String poemText) {
		Poem poem = PoemParser.getInstance().toPoem(poemText);
		if (poem == null) {
			return false;
		}
		return validateAnagramicPoem(poem);
	}

	private boolean validateAnagramicPoem(Poem poem) {
		List<Verse> verses = poem.getVerses();
		boolean result = validateMinVerses(verses);
		result &= validateAnagramicVerses(verses);
		return result;
	}

	private boolean validateMinVerses(List<Verse> verses) {
		return verses != null & verses.size() > 1;
	}

	private boolean validateAnagramicVerses(List<Verse> verses) {
		String firstVerse = null;
		List<String> restOfVerses = new ArrayList<>();
		for (Verse verse : verses) {
			if (firstVerse == null) {
				firstVerse = verse.getText();
			} else {
				restOfVerses.add(verse.getText());
			}
		}
		return AnagramEvaluator.getInstance().compareOneToMany(firstVerse, restOfVerses);
	}
}
