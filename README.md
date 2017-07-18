# Anagramic Poem

Evaluate if a text is an anagramic poem or not.

## Assumptions

*	An empty text is not a poem, so it is not an anagramic poem.
*	A single line poem is not anagramic.
*	Characters variations are interpreted as no variation. Examples: _á_ == _a_ or _ñ_ == _n_
*	Evaluation is case insensitive.
*	Symbols are ignored.

## How to run as a command line program

The easiest way to run a poem evaluation is using Maven:

	mvn exec:java -Dexec.args="<FilePath>"

Another way is using directly java, but it's necessary to first download dependencies and use it in classpath. 

## How to use as a library

You can add the library as a Maven dependency:

	<dependency>
		<groupId>cat.aubricoc</groupId>
		<artifactId>anagramic-poem</artifactId>
		<version>1.0</version>
	</dependency>`

And call the function:

	AnagramicPoemEvaluator.getInstance().isAnagramicPoem("my poem");
