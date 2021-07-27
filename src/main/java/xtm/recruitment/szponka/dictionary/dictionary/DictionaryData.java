package xtm.recruitment.szponka.dictionary.dictionary;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import xtm.recruitment.szponka.dictionary.counter.CountExecution;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class DictionaryData {

    private Map<String, String> dictionary = new HashMap<>();

    ObjectMapper mapper;

    public DictionaryData(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Value("${dictionaryPath}")
    private String dictionaryPath;

    @PostConstruct
    private void initDictionary() throws IOException {
        dictionary = mapper.readValue(new File(dictionaryPath), Map.class);
        log.info("Dictionary initialized: {} terms", dictionary.size());
    }

    @CountExecution
    public String translate(String givenTerm) {
        return dictionary.get(givenTerm) == null ? givenTerm : dictionary.get(givenTerm);
    }
}
