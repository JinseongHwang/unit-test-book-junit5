package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class Example3_9 extends IntegrationTests {

    @Test
    void testWithExtends() throws Exception {
        assertNotNull(database);
    }
}
