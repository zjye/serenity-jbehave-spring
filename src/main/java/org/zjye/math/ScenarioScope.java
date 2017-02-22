package org.zjye.math;

import org.jbehave.core.annotations.BeforeScenario;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ScenarioScope implements Scope {

    private final ConcurrentMap<String, Object> cache = new ConcurrentHashMap();

    @BeforeScenario
    public void startScenario(){
        cache.clear();
    }

    @Override
    public Object get(String name, ObjectFactory objectFactory) throws IllegalStateException{
        if (!cache.containsKey(name)){
            cache.putIfAbsent(name, objectFactory.getObject());
        }
        return cache.get(name);

    }

    @Override
    public Object resolveContextualObject(String name){
        return null;
    }

    @Override
    public Object remove(String name){
        return cache.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback){}

    @Override
    public String getConversationId(){
        return "scenario scope";
    }
}
