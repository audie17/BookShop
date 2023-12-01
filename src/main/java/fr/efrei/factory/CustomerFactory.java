package fr.efrei.factory;

import fr.efrei.domain.Customer;
import fr.efrei.util.Helper;

public class CustomerFactory {
    public static Customer createCustomer( int cus_id, String name, String surname, int pointNumber) {
        if (Helper.isNullorEmpty(name) || Helper.isNullorEmpty(surname))
            return null;

        if (cus_id <= 0)
            return null;

        return new Customer.Builder()
                .setCus_id(cus_id)
                .setName(name)
                .setSurname(surname)
                .setPointNumber(pointNumber)
                .build();
    }

}