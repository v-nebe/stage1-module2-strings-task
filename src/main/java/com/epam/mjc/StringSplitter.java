package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        ArrayList <String> substrings = new ArrayList<>();
        StringBuilder regex = new StringBuilder();

        for (String delimiter : delimiters) {
            regex.append("\\Q").append(delimiter).append("\\E|");
        }
        regex.setLength(regex.length() - 1);

        StringTokenizer tokenizer = new StringTokenizer(source, regex.toString());
        while (tokenizer.hasMoreTokens()){
            substrings.add(tokenizer.nextToken());
        }

        return substrings;
        //throw new UnsupportedOperationException("You should implement this method.");
    }
}
