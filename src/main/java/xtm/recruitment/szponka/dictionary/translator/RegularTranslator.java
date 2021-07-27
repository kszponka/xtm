package xtm.recruitment.szponka.dictionary.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xtm.recruitment.szponka.dictionary.dictionary.DictionaryData;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RegularTranslator implements Translator {

    DictionaryData dictionaryData;

    public RegularTranslator(DictionaryData dictionaryData) {
        this.dictionaryData = dictionaryData;
    }

    @Override
    public String translateSentence(String sentenceToTranslate) {
        Stream<String> wordStream = Arrays.stream(sentenceToTranslate.split(" "));
        return wordStream.map(word -> dictionaryData.translate(word))
                .collect(Collectors.joining(" "));
    }
}
