package xtm.recruitment.szponka.dictionary.dictionary;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import xtm.recruitment.szponka.dictionary.translator.Translators;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@WebMvcTest(DictionaryController.class)
class DictionaryControllerTest {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private DictionaryService dictionaryService;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();
    }

    @Test
    public void shouldUseModeWithQuotesToTranslate() throws Exception {
        when(dictionaryService.translateSentence("Ala ma kota", Translators.Mode.WITH_QUOTES)).thenReturn("Alice has a cat");
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/translate")
                        .param("sentenceToTranslate", "Ala ma kota")
                        .param("mode", "WITH_QUOTES"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Alice has a cat"));
    }

    @Test
    public void shouldUseDefaultModeRegularToTranslate() throws Exception {
        when(dictionaryService.translateSentence("Ala ma kota", Translators.Mode.REGULAR)).thenReturn("Alice has a cat");
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/translate")
                        .param("sentenceToTranslate", "Ala ma kota"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Alice has a cat"));
    }

    @Test
    public void shouldReturnSortedListOfResult() throws Exception {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("Alice", 5);
        result.put("cat", 2);
        when(dictionaryService.getSortedResult()).thenReturn(result);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/result"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.Alice").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$..*").value(Matchers.containsInRelativeOrder(5, 2)));
    }
}



