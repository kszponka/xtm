package xtm.recruitment.szponka.dictionary.translator;

import org.junit.jupiter.api.Test;
import xtm.recruitment.szponka.dictionary.dictionary.DictionaryData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RegularTranslatorTest {

    @Test
    void shouldTranslateFullSentence() {
        //given
        DictionaryData dictionaryData = mock(DictionaryData.class);
        RegularTranslator regularTranslator = new RegularTranslator(dictionaryData);

        when(dictionaryData.translate("jeden")).thenReturn("one");
        when(dictionaryData.translate("dwa")).thenReturn("two");

        String givenSentence = "jeden dwa jeden";
        String expectedSentence = "one two one";

        // when
        String result = regularTranslator.translateSentence(givenSentence);

        // then
        assertEquals(expectedSentence, result);
    }
}