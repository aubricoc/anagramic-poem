package cat.aubricoc.anagramicpoem;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class AnagramicPoemRunner {

	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.err.println("One argument is required: The poem filepath.");
			return;
		}
		String poemFilePath = args[0];
		File file = new File(poemFilePath);
		if (!file.exists()) {
			System.err.println("File doesn't exists!");
			return;
		}
		String poemText = FileUtils.readFileToString(file, "UTF-8");
		boolean result = AnagramicPoemEvaluator.getInstance().isAnagramicPoem(poemText);
		if (result) {
			System.out.println("Yes! This poem is anagramic!");
		} else {
			System.out.println("No! This is not an anagramic poem!");
		}
	}
}
