package com.example.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

    @Test
    void test1(){
        DataService dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

    @Test
    void test2(){
        DataService dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(35, result);
    }
}

class DataServiceStub1 implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[]{25,15,5};
    }
}

class DataServiceStub2 implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[]{35};
    }
}
