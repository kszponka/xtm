package xtm.recruitment.szponka.dictionary.dictionary;

import org.springframework.stereotype.Service;
import xtm.recruitment.szponka.dictionary.counter.Counter;
import xtm.recruitment.szponka.dictionary.translator.Translator;
import xtm.recruitment.szponka.dictionary.translator.Translators;

import java.util.Map;

@Service
class DictionaryService {

    private Translators translators;
    private Counter counter;

    public DictionaryService(Translators translators, Counter counter) {
        this.translators = translators;
        this.counter = counter;
    }

    public String translateSentence(String sentenceToTranslate, Translators.Mode mode) {
        Translator translator = translators.chooseTranslator(mode);
        return translator.translateSentence(sentenceToTranslate);
    }

    public Map<String, Integer> getSortedResult() {
        return counter.getSortedRanking();
    }
}
