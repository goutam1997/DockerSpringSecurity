package inventory.service.impl;

import inventory.dao.ProductDao;
import inventory.models.Product;
import inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product addProduct(Product product) {
        return productDao.save(product);
    }
}
