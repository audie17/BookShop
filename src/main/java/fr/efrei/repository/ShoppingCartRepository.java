package fr.efrei.repository;

import fr.efrei.domain.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartRepository implements IShoppingCartRepository{
    private static  ShoppingCartRepository repository = null;
    private List<ShoppingCart> shoppingCartDB = null;

    // Private constructor to enforce the singleton pattern
    private  ShoppingCartRepository() {
        shoppingCartDB = new ArrayList<>();
    }

    public static ShoppingCartRepository getRepository() {
        if (repository == null) {
            repository = new ShoppingCartRepository();
        }
        return repository;
    }

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        boolean success = shoppingCartDB.add(shoppingCart);
        return success ? shoppingCart: null;
    }

    @Override
    public ShoppingCart read(int shoppingCartId) {
        if (shoppingCartDB == null) {
            throw new IllegalStateException("Customer database is not initialized.");
        }

        return shoppingCartDB.stream()
                .filter(c -> c.getShoppingCart_id() == shoppingCartId)
                .findAny()
                .orElse(null);
    }

    @Override
    public ShoppingCart update(ShoppingCart newShoppingCart) {
        ShoppingCart oldShoppingCart = read(newShoppingCart.getShoppingCart_id());
        if (oldShoppingCart == null)
            return null;

        boolean success = delete(newShoppingCart.getShoppingCart_id());
        if (success) {
            boolean successAdded = shoppingCartDB.add(newShoppingCart);
            return successAdded ? newShoppingCart : null;
        }

        return null;
    }

    @Override
    public boolean delete(int shoppingCartID) {
        ShoppingCart shoppingCartToDelete = read(shoppingCartID);
        return shoppingCartDB.remove(shoppingCartToDelete);
    }

    @Override
    public List<ShoppingCart> getAll() {
        return new ArrayList<>(shoppingCartDB);
    }


    /*
    @Override

    public Object create(Object o) {
        return null;
    }

    @Override
    public Object read(Object o) {
        return null;
    }

    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }*/
}

