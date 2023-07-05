package com.estore.api.estoreapi.persistence;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

import com.estore.api.estoreapi.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@Tag("Persistence-tier")
public class ProductFileDAOTest {
    ProductFileDAO productFileDAO;
    Product[] testProducts;
    ObjectMapper mockObjectMapper;

    @BeforeEach
    public void setupHeroFileDAO() throws IOException {
        mockObjectMapper = mock(ObjectMapper.class);

        testProducts = new Product[3];
        testProducts[0] = new Product(1,"Tuba",599.99,5);
        testProducts[1] = new Product(2,"Clarinet",349.99,7);
        testProducts[2] = new Product(3,"Guitar",499.99,4);

        when(mockObjectMapper
            .readValue(new File("doesnt_matter.txt"),Product[].class))
                .thenReturn(testProducts);

        productFileDAO = new ProductFileDAO("doesnt_matter.txt",mockObjectMapper);
    }
}
