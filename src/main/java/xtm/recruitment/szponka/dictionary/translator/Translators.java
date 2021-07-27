package xtm.recruitment.szponka.dictionary.translator;

import org.springframework.stereotype.Component;

@Component
public class Translators {

    public enum Mode {
        REGULAR, WITH_QUOTES
    }

    private RegularTranslator regularTranslator;
    private QuotesTranslator quotesTranslator;

    public Translators(RegularTranslator regularTranslator, QuotesTranslator quotesTrans) {
        this.regularTranslator = regularTranslator;
        this.quotesTranslator = quotesTrans;
    }

    public Translator chooseTranslator(Mode mode) {
        switch (mode) {
            case WITH_QUOTES:
                return quotesTranslator;

            default:
                return regularTranslator;
        }
    }
}
