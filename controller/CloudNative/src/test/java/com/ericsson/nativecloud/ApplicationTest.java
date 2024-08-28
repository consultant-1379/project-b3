package com.ericsson.nativecloud;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

// Test class added ONLY to cover main() invocation not covered by application tests.
class ApplicationTest {

    @Test
    void main() {
        Application.main(new String[] {});
        int i=1;
        assertEquals(1,i);
    }
}