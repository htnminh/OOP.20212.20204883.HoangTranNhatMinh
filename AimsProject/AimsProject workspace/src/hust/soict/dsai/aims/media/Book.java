package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	private String content = "";
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String,Integer> wordFrequency = new TreeMap<String, Integer>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	@Override
	public String toString() {
		return String.format("%s. Book - %s - %s - %s - \"%s\" - %s - %s: %s $",
				id, title, category, authorsString(),
				content, contentTokens.size(), wordFrequency, cost);
	}
	public String authorsString() {
		return String.join(", ", authors);
	}
	
	public List<String> getAuthors() {
		return authors;
	}
	
	private int indexAuthor(String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				return i;
			}
		}
		return -1;
	}
	
	public void addAuthor(String authorName) {
		if (indexAuthor(authorName) == -1) {
			authors.add(authorName);
			System.out.println("Added the author: " + authorName);
		} else
			System.out.println("Cannot add author, author already exists");
	}
	public void removeAuthor(String authorName) {
		int i = indexAuthor(authorName);
		if (i != -1) {
			authors.remove(i);
			System.out.println("Removed the author: " + authorName);
		} else
			System.out.print("Cannot remove author, author does not exist");
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		updateTokensAndFrequency();
	}
	

	public List<String> getContentTokens() {
		return contentTokens;
	}

	public Map<String, Integer> getWordFrequency() {
		return wordFrequency;
	}

	private void updateTokensAndFrequency() {
		String[] wordArray = content.split("(\\p{Punct}| )");
		contentTokens = new ArrayList<String>(Arrays.asList(wordArray));
		contentTokens.removeIf(string -> string.equals(""));
		// why too much code needed to do a simple job like this:
		// https://stackoverflow.com/questions/3907394/java-is-there-a-map-function
		contentTokens = 
				contentTokens.stream().map(string -> string.toLowerCase())
					.collect(Collectors.toList());
		Collections.sort(contentTokens);
		
		for (String word: contentTokens) {
			wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
		}
		
	}
}
