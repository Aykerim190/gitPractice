package com.digital.utils;

import com.digital.models.Student;
import com.github.javafaker.Faker;

public class FakeDataProvider { // данный класс будет предоставлять к-л фейковые данные

    static Faker faker = new Faker();

    public String generateFakeFullName(){
        return faker.name().fullName();
    }

    public String generationFirstName(){
        return faker.name().firstName();

    }
    public String generateFakeLastName(){
        return faker.name().lastName();

    }


    public String generateFakeEmail() {
        return faker.internet().emailAddress();
    }
    public String generationPhoneNUmber() {
        return faker.number().digits(10);
    }

    public String generationFakePermanentAddress() {
        return faker.address().streetName() + " " + faker.address().streetAddressNumber();
    }


    public String generationFakeCurrentAddress(){
        return faker.address().fullAddress();

    }

    public static String generateFakePermanentAddress(){
        return faker.address().streetName()+ " "+ faker.address().streetAddressNumber();
    }

    public static void main(String[] args) {
        System.out.println(generateFakePermanentAddress());
    }

    public Student createFakeStudent(){
        Student student = new Student();
        student.setFirstName(generationFirstName());
        student.setLastName(generateFakeLastName());
        student.setEMail(generateFakeEmail());
        student.setPhoneNUmber(generationPhoneNUmber());
        student.setCurrentAddress(generationFakeCurrentAddress());
        return student;

    }

}
