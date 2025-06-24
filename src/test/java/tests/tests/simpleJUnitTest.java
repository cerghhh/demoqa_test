package tests;

import org.junit.jupiter.api.*;


public class simpleJUnitTest {
int result ;


@BeforeAll
static void Beforeall(){
    System.out.println("###   Beforeall\n");

}
    @BeforeEach
    void BeforeEach(){
        System.out.println("###   BeforeEach");
        result = getResoult();
    }
    @AfterEach
    void AfterEach(){
        System.out.println("###   AfterEach");
        result = 0 ;
    }

    @AfterAll
   static void AfterAll(){
        System.out.println("\n###   AfterAll()\n");

}


    @Test
    void first() {
        System.out.println("###   first");
        Assertions.assertTrue(result>2);
    }
    @Test
    void ADfirst() {
        System.out.println("###   ADfirst");
        Assertions.assertTrue(result>2);
    }@Test
    void DFfirst() {
        System.out.println("###   DFfirst");
        Assertions.assertTrue(result>2);
    }@Test
    void GHirst() {
        System.out.println("###   GHirst");
        Assertions.assertTrue(result>2);
    }
    private int getResoult() {
        return 3;
    }
}
