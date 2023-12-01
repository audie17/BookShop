package fr.efrei.domain;
import java.util.*;

public class Employee {
        private int emp_id;
        private String name;
        private String surname;
        private String rayon;

        private Employee() {
        }

        public Employee(Builder builder) {
            this.emp_id = emp_id;
            this.name = name;
            this.surname = surname;
            this.rayon = rayon;
        }

        public int getEmp_id() {
            return emp_id;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getRayon() {
            return rayon;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Employee{" +
                    "emp_id=" + emp_id +
                    ", name='" + name +
            ", surname='" + surname +
            ", rayon='" + rayon +
            '}';
        }
        public static class Builder{
            private int emp_id;
            private String name;
            private String surname;
            private String rayon;

            public Builder setEmp_id(int emp_id) {
                this.emp_id = emp_id;
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

            public Builder setRayon(String rayon) {
                this.rayon = rayon;
                return this;
            }
            public Employee build() {
                return new Employee(this);
            }
        }
    }

