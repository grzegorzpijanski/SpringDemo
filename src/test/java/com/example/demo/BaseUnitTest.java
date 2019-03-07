package com.example.demo;

import info.solidsoft.mockito.java8.api.WithBDDMockito;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BaseUnitTest implements WithBDDMockito, WithAssertions, WithTestObjectFactory { }