package com.digital.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties; // класс для расширения properties, чтобы брать данные с этого файла

public class ConfigReader { // с этого класса могли данные брать с файла config.properties

    private static Properties properties; //для работы с параметрами java.util.Properties


    // для хранения статичных данных создаем стат блоки
    static {
        try{
            String path = "C:\\Users\\Lenovo\\IdeaProjects\\SummerSDET2023\\UI\\src\\main\\resources\\config.properties"; //config.properties/copy.path
            FileInputStream inputStream = new FileInputStream(path);// чтобы объект мог открыть файл и взять данные
            properties = new Properties(); //создаем объект properties
            properties.load(inputStream); // и грузим все данные c файла
            inputStream.close(); // закрываем поток
        } catch (IOException e){
            e.printStackTrace();

        }
    }

    public static String getProperty(String key){ // для получения нр названий из метода, в скобках указываем ключ
        return properties.getProperty(key).trim();


    }

    public static void main(String[] args) {
        System.out.println(getProperty("browser"));
    }

}
