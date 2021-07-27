package xtm.recruitment.szponka.dictionary.translator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class TranslatorsTest {

    @Test
    void shouldChooseCorrectTranslatorRegular() {
        //given
        RegularTranslator regularTranslator = mock(RegularTranslator.class);
        QuotesTranslator quotesTranslator = mock(QuotesTranslator.class);
        Translators translators = new Translators(regularTranslator, quotesTranslator);
        Translators.Mode regularMode = Translators.Mode.REGULAR;

        // when
        Translator chosenTranslator = translators.chooseTranslator(regularMode);

        // then
        assertTrue(chosenTranslator instanceof RegularTranslator);
    }

    @Test
    void shouldChooseCorrectTranslatorWithQuotes() {
        //given
        RegularTranslator regularTranslator = mock(RegularTranslator.class);
        QuotesTranslator quotesTranslator = mock(QuotesTranslator.class);
        Translators translators = new Translators(regularTranslator, quotesTranslator);
        Translators.Mode withQuotesMode = Translators.Mode.WITH_QUOTES;

        // when
        Translator chosenTranslator = translators.chooseTranslator(withQuotesMode);

        // then
        assertTrue(chosenTranslator instanceof QuotesTranslator);
    }
}