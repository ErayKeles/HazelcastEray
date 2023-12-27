package com.mycompany.hazelcasteray;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map; // Add this import statement

public class HazelcastEray {

    public static void main(String[] args) {
        Config config = new Config();
        HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);

        Map<String, Person> map = hz.getMap("personMap");

        for (int i = 0; i < 10000; i++) {
            String key = "person" + i;
            Person person = new Person("DummyPerson" + i);
            map.put(key, person);
        }

        // Get example
        String randomKey = "person" + (int) (Math.random() * 10000);
        Person retrievedPerson = map.get(randomKey);
        System.out.println("Retrieved Person: " + retrievedPerson);

        Hazelcast.shutdownAll();
    }
}
