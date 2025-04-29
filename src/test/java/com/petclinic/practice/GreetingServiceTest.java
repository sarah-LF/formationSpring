package com.petclinic.practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest // charge l'app context
@ActiveProfiles("dev")
class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService; // Si 2 beans, soit @Qualifier, soit mettre le nom exact du bon bean en nom de variable

    @Autowired
    ApplicationContext applicationContext;

//    @MockitoBean // override bean
//    private StudentRepo studentRepo;

    @BeforeEach
    void setUp() {
//        this.applicationContext = new AnnotationConfigApplicationContext("com.petclinic.practice");
//        greetingService = applicationContext.getBean(GreetingService.class); // <=> @SpringBootTest
    }


    @Test
    void shouldGreetSuccessfully(){
        String result = greetingService.sayHi();
        assertEquals("Hello John", result);
    }

    @Test
    void shouldCountBeanDefinitions(){
        System.out.println("Nb de beans : " + applicationContext.getBeanDefinitionCount());
    }

    @Test
    void shouldDisplayBeanDefinitions(){
        String[] beanNames = this.applicationContext.getBeanDefinitionNames();
        System.out.println("All beans in the application context:");
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

//    @TestConfiguration // pour override beans dans les tests
//    static class blabla {
//        @Bean
//        static void sqdqs() {
//
//        }
//    }
}