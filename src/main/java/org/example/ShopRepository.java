package org.example;

public class ShopRepository {
    private Product[] products = new Product[0];

    /**
     * Метод для добавления товара в репозиторий
     *
     * @param product добавляемый товар
     */
    public void add(Product product) {
        products = addToArray(products, product);
    }

    /**
     * Метод для удаления товара из репозитория по его ID
     *
     * @param id ID удаляемого товара
     */
    public void removeById(int id) {
        Product productToRemove = findById(id);
        if (productToRemove == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }

        int indexToRemove = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;
            for (int i = 0; i < products.length; i++) {
                if (i != indexToRemove) {
                    tmp[copyToIndex++] = products[i];
                }
            }
            products = tmp;
        }
    }

    /**
     * Метод для поиска товара по его ID
     *
     * @param id ID искомого товара
     * @return найденный товар или null, если не найден
     */
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    /**
     * Метод для получения всех товаров в репозитории
     *
     * @return массив всех товаров в репозитории
     */
    public Product[] findAll() {
        return products;
    }

    /**
     * Вспомогательный метод для добавления элемента в массив
     *
     * @param current массив, в который добавляется элемент
     * @param product добавляемый элемент
     * @return новый массив с добавленным элементом
     */
    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        System.arraycopy(current, 0, tmp, 0, current.length);
        tmp[tmp.length - 1] = product;
        return tmp;
    }
}



