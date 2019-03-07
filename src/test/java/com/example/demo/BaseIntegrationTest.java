package com.example.demo;

import info.solidsoft.mockito.java8.api.WithBDDMockito;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        MockitoTestExecutionListener.class
})
public abstract class BaseIntegrationTest implements WithBDDMockito, WithAssertions, WithTestObjectFactory { }