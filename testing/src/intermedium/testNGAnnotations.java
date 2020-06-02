package intermedium;

import org.testng.annotations.*;

public class testNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Este metodo se ejecuta antes de una suite de pruebas");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Este metodo se ejecuta antes de las pruebas");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Este metodo se ejecuta antes de la clase");
    }

    @BeforeMethod
    public void beforeMetod(){
        System.out.println("Se ejecuta antes de cada metodo de prueba @Test");
    }

    @Test
    public void testCase1(){
        System.out.println("Caso de prueba 1");
    }

    @Test
    public void testCase2(){
        System.out.println("Caso de prueba 2");
    }

    @AfterMethod
    public void  AfterMethod(){
        System.out.println("Se ejecuta despues de cada metodo de prueba");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("Se ejecuta despues de la clase");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Se ejecuta despues de todas las pruebas");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("Este metodo se ejecuta despues de una suite de pruebas");
    }


}
