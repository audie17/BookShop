package fr.efrei.Repository;

public interface IShoppingCartRepository extends IRepository {
    ShoppingCart create(ShoppingCart entity);
    ShoppingCart read(int id);
    ShoppingCart update(ShoppingCart entity);
    boolean delete(int id);
    List<ShoppingCart> getAll();
}