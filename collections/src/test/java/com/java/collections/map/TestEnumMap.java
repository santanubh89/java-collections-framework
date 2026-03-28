package com.java.collections.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

@Slf4j
public class TestEnumMap {

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    @Test
    public void testEnumMap() {
        Map<Day, String> dayMap = new EnumMap<>(Day.class);
        dayMap.put(Day.MONDAY, "Work");
        dayMap.put(Day.TUESDAY, "Gym");
        dayMap.put(Day.WEDNESDAY, "Study");
        dayMap.put(Day.THURSDAY, "Shopping");
        dayMap.put(Day.FRIDAY, "Relax");
        dayMap.put(Day.SATURDAY, "Hiking");
        dayMap.put(Day.SUNDAY, "Family Time");

        log.info("EnumMap Contents: {}", dayMap);
    }
}