package fr.efrei.repository;

import fr.efrei.domain.Book;
import fr.efrei.domain.ShoppingCart;

import java.util.List;


public interface IShoppingCartRepository extends IRepository{
    ShoppingCart create(ShoppingCart shoppingCart);
    ShoppingCart read(int id);
    ShoppingCart update(ShoppingCart entity);
    boolean delete(int id);
    List<ShoppingCart> getAll();
}
