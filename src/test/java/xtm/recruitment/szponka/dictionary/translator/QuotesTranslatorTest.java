package xtm.recruitment.szponka.dictionary.translator;

import org.junit.jupiter.api.Test;
import xtm.recruitment.szponka.dictionary.dictionary.DictionaryData;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuotesTranslatorTest {

    @Test
    void shouldTranslateFullSentenceWithQuotes() {
        //given
        DictionaryData dictionaryData = mock(DictionaryData.class);
        QuotesTranslator regularTranslator = new QuotesTranslator(dictionaryData);

        when(dictionaryData.translate("jeden")).thenReturn("one");
        when(dictionaryData.translate("dwa")).thenReturn("two");

        String givenSentence = "jeden dwa jeden";
        String expectedSentece = "\"one\" \"two\" \"one\"";

        // when
        String result = regularTranslator.translateSentence(givenSentence);

        // then
        assertEquals(expectedSentece, result);
    }
}
