package com.naver.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CarDto {
    private String name;
    private int age;
    @JsonProperty(value = "car_list")
    private List<CarList> carLists;
    private static class CarList{
        private String brand;
        @JsonProperty(value = "car_number")
        private String carNumber;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public void setCarNumber(String carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public String toString() {
            return "CarList{" +
                    "brand='" + brand + '\'' +
                    ", carNumber='" + carNumber + '\'' +
                    '}';
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<CarList> getCarLists() {
        return carLists;
    }

    public void setCarLists(List<CarList> carLists) {
        this.carLists = carLists;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carLists=" + carLists +
                '}';
    }
}
