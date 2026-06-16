package com.example.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void test1() {
        when(dataServiceMock.retrieveData()).thenReturn(new int[] { 25, 15, 5 }, null);
        assertEquals(25, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void test2() {
        when(dataServiceMock.retrieveData()).thenReturn(new int[] {35});
        assertEquals(35, businessImpl.findTheGreatestFromAllData());
    }
}
