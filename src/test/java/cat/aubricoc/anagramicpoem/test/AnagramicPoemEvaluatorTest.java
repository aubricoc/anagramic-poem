package cat.aubricoc.anagramicpoem.test;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import cat.aubricoc.anagramicpoem.AnagramicPoemEvaluator;

public class AnagramicPoemEvaluatorTest {

	@Test
	public void testNullAnagramicPoem() throws IOException {
		String poemText = null;
		boolean result = AnagramicPoemEvaluator.getInstance().isAnagramicPoem(poemText);
		Assert.assertFalse(result);
	}
	
	@Test
	public void testEmptyAnagramicPoem() throws IOException {
		String poemText = StringUtils.EMPTY;
		boolean result = AnagramicPoemEvaluator.getInstance().isAnagramicPoem(poemText);
		Assert.assertFalse(result);
	}
	
	@Test
	public void testOneLineAnagramicPoem() throws IOException {
		String poemText = "Hello World";
		boolean result = AnagramicPoemEvaluator.getInstance().isAnagramicPoem(poemText);
		Assert.assertFalse(result);
	}
	
	@Test
	public void testNoAnagramicPoem() throws IOException {
		String poemText = "Hello World\nHi World!";
		boolean result = AnagramicPoemEvaluator.getInstance().isAnagramicPoem(poemText);
		Assert.assertFalse(result);
	}
	
	@Test
	public void testTwoLinesAnagramicPoem() throws IOException {
		boolean result = validateAnagramicPoemFromFile("anagramic_poem_two_lines.txt");
		Assert.assertTrue(result);
	}
	
	@Test
	public void testLongAnagramicPoem() throws IOException {
		boolean result = validateAnagramicPoemFromFile("anagramic_poem_long.txt");
		Assert.assertTrue(result);
	}
	
	@Test
	public void testLongNoAnagramicPoem() throws IOException {
		boolean result = validateAnagramicPoemFromFile("no_anagramic_poem_long.txt");
		Assert.assertFalse(result);
	}
	
	private boolean validateAnagramicPoemFromFile(String fileName) throws IOException {
		URL fileUrl = ClassLoader.getSystemClassLoader().getResource(fileName);
		String poemText = IOUtils.toString(fileUrl, "UTF-8");
		return AnagramicPoemEvaluator.getInstance().isAnagramicPoem(poemText);
	}
}
