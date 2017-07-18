package cat.aubricoc.anagramicpoem.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cat.aubricoc.anagramicpoem.model.Poem;
import cat.aubricoc.anagramicpoem.model.Verse;

public class PoemParser {

	private static final PoemParser INSTANCE = new PoemParser();

	private PoemParser() {
		super();
	}

	public static PoemParser getInstance() {
		return INSTANCE;
	}

	public Poem toPoem(String poemText) {
		List<Verse> verses = toVerses(poemText);
		if (verses == null) {
			return null;
		}
		Poem poem = new Poem();
		poem.setVerses(verses);
		return poem;
	}

	private List<Verse> toVerses(String poemText) {
		String[] lines = toLines(poemText);
		if (lines == null) {
			return null;
		}
		List<Verse> verses = new ArrayList<>();
		for (String line : lines) {
			Verse verse = toVerse(line);
			if (verse != null) {
				verses.add(verse);
			}
		}
		return verses;
	}

	private Verse toVerse(String text) {
		if (StringUtils.isBlank(text)) {
			return null;
		}
		Verse verse = new Verse();
		verse.setText(text);
		return verse;
	}

	private String[] toLines(String text) {
		if (StringUtils.isBlank(text)) {
			return null;
		}
		return text.split("\\r?\\n");
	}
}
