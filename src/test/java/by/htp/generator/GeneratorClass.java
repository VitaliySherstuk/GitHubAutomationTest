package by.htp.generator;

import java.util.Random;

public class GeneratorClass {

	private final static String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private final static String symbolsForSentences = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 .,!%*;:";
	
	private static Random random = new Random();
	
	public static String generateWord(int length)
	{
		String finalWord = "";
		
		for(int i=0; i<length; i++)
		{
			finalWord += symbols.charAt(random.nextInt(symbols.length()));
		}
		
		return finalWord;
	}
	
	public static String generatorSentence(int length)
	{
		String sentence = "";
		
		for(int i=0; i<length; i++)
		{
			sentence += symbolsForSentences.charAt(random.nextInt(symbolsForSentences.length()));
		}
		return sentence;
	}
}
