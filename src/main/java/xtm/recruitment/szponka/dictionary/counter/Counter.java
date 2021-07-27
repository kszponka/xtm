package xtm.recruitment.szponka.dictionary.counter;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Aspect
@Component
public class Counter {

    Map<String, Integer> rankingMap = new ConcurrentHashMap<>();

    @AfterReturning("@annotation(countExecution) && args(term)")
    public void count(CountExecution countExecution, String term) {
        rankingMap.merge(term, 1, Integer::sum);
    }

    public Map<String, Integer> getSortedRanking() {
        Map<String, Integer> sortedResult = rankingMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1,
                        LinkedHashMap::new));
        return sortedResult;
    }
}
