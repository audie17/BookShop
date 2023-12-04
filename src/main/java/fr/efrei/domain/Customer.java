package fr.efrei.domain;
import java.util.*;

public class Customer {
    private int cus_id;
    private String name;
    private String surname;
    private float pointNumber;

    private Customer() {
    }

    public Customer(Builder builder) {
        this.cus_id = builder.cus_id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.pointNumber = builder.pointNumber;
    }

    public int getCus_id() {
        return cus_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getPointNumber() {
        return pointNumber;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Customer{" +
                "cus_id=" + cus_id +
                ", name='" + name +
                ", surname='" + surname+
                ", pointNumber=" + pointNumber +
                '}';
    }

    public static class Builder {
        private int cus_id;
        private String name;
        private String surname;
        private float pointNumber =0;

        public Builder setCus_id(int cus_id) {
            this.cus_id = cus_id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setPointNumber(float pointNumber) {
            this.pointNumber = pointNumber;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
    }


