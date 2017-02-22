package org.zjye.math;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ScenarioContext {

    private final ConcurrentMap<String, Object> data = new ConcurrentHashMap();

    @PostConstruct
    public void reset(){
        data.clear();
    }

    public <T> void add(String key, T value) {
        data.put(key, value);
    }

    public <T> T get(String key) {
        Object value = data.get(key);

        return (T)value;
    }
}
