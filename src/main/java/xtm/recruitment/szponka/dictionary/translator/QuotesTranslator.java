package xtm.recruitment.szponka.dictionary.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xtm.recruitment.szponka.dictionary.dictionary.DictionaryData;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class QuotesTranslator implements Translator {

    private static final String QUOTE = "\"";
    DictionaryData dictionaryData;

    public QuotesTranslator(DictionaryData dictionaryData) {
        this.dictionaryData = dictionaryData;
    }

    @Override
    public String translateSentence(String sentence) {
        Stream<String> wordStream = Arrays.stream(sentence.split(" "));
        return wordStream.map(word -> dictionaryData.translate(word))
                .map(this::addQuotes)
                .collect(Collectors.joining(" "));
    }

    private String addQuotes(String word) {
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append(QUOTE).append(word).append(QUOTE).toString();
    }
}
