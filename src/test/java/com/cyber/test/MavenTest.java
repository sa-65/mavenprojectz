package com.cyber.test;

import com.github.javafaker.Faker;

public class MavenTest {
    public static void main(String[] args) {
        System.out.println("Hello Maven");

        Faker faker=new Faker();

        System.out.println(faker.funnyName().name());
    }
}
