package edu3431.matiukhin.softwarequality8;/*
@author sasha
@project SoftwareQuality8
@class ServiceTest
@version 1.0.0
@since 30.04.2025 - 23 - 07
*/


import edu3431.matiukhin.softwarequality8.model.Product;
import edu3431.matiukhin.softwarequality8.repository.ProductRepository;
import edu3431.matiukhin.softwarequality8.request.CreateProductRequest;
import edu3431.matiukhin.softwarequality8.request.ProductRequest;
import edu3431.matiukhin.softwarequality8.request.UpdateProductRequest;
import edu3431.matiukhin.softwarequality8.service.ProductService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataMongoTest
public class ServiceTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService underTest;
    @Autowired
    private ProductService productService;

    @BeforeAll
    void beforeAll() {
    }

    @BeforeEach
    void setUp() {
        Product smartPhone =new Product("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3333,"00001", "###test");
        Product furniture= new Product("2","Furniture", "Office chair", "Art Metal Furniture A-36 black", 4444,"00002", "###test");
        Product fridge = new Product("3","Large household appliances", "Fridges", " MPM MPM-46-CJ-01", 3333,"00003", "###test");
        repository.saveAll(List.of(smartPhone,furniture,fridge));

    }

    @AfterEach
    void tearDown() {
       /* List<Product> itemsToDelete = repository.findAll().stream()
                .filter(item -> item.getDescription().contains("###test"))
                .toList();
        repository.deleteAll(itemsToDelete);*/
        repository.deleteAll();
    }

    @AfterAll
    void afterAll() {
    }


    @Test
    void whenInsertNewProduct_ThenCreateProductIsNotNull() {


        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);

        assertNotNull(createdProduct);


    }

    @Test
    void whenInsertNewProduct_ThenCreatedIdNotNull() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);


        assertNotNull(createdProduct.id());


    }



    //Check values

    @Test
    void whenInsertNewProduct_ThenCreatedCatagoryEquals() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);

        assertEquals("Smartfones and mobile phones", createdProduct.category());
    }





    @Test
    void whenInsertNewProduct_ThenCreatedTypeEquals() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);

        assertEquals("Smartphones", createdProduct.type());
    }



    @Test
    void whenInsertNewProduct_ThenCreatedNameEqualsXiaomiPoco() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);

        assertEquals("Xiaomi POCO", createdProduct.name());


    }

    @Test
    void whenInsertNewItem_ThenPriceMoreThanZero() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);


        assertTrue(createdProduct.price()>0);
    }


    @Test
    void whenInsertNewProduct_ThenCreatedCodeEquals() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);

        assertEquals("00001", createdProduct.code());
    }
    @Test
    void whenInsertNewItem_ThenDescription() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);


        assertEquals("###test1", createdProduct.description());
    }



//CheckDates


    @Test
    void whenInsertNewProduct_ThenCreateDateIsNotNull()
    {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Voda Phone", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);


        assertNotNull(createdProduct.createDate());


    }




    @Test
    void whenInsertNewProduct_ThenCreatedDateIsLocalDate() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);

        assertSame(LocalDateTime.class, createdProduct.createDate().getClass());



    }

    @Test
    void whenInsertNewProduct_ThenCreatedDateIsRelevant() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        LocalDateTime now = LocalDateTime.now();

        ProductRequest createdProduct = underTest.createItem(createProductRequest);

        assertTrue(createdProduct.createDate().isAfter(now));

    }


    @Test
    void whenInsertNewProduct_ThenCreatedDateIsUpdateDateNotNull() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);


        assertNotNull(createdProduct.updateDates());

    }



    @Test
    void whenInsertNewProduct_ThenCreatedDateIsUpdateDateIsArrayList() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);



        assertSame(ArrayList.class, createdProduct.updateDates().getClass());


    }

    @Test
    void whenInsertNewProduct_ThenCreatedDateIsUpdateDateIsEmpty() {
        CreateProductRequest createProductRequest = new CreateProductRequest("Smartfones and mobile phones", "Smartphone", "Xiaomi POCO", 3333, "00001", "###test1");

        ProductRequest createdProduct = underTest.createItem(createProductRequest);

        assertTrue( createdProduct.updateDates().isEmpty());

    }




    //Update


    @Test
    void whenUpdateNewProduct_ThenUpdatedProductIsNotNull() {

        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);
        assertNotNull(updatedProduct);


    }




    @Test
    void whenUpdateNewProduct_ThenUpdatedProductIdNotNull() {

        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);
        assertNotNull(updatedProduct);


    }




    @Test
    void whenUpdateNewProduct_ThenUpdatedItemIsNotNullCategory() {

        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);
        assertNotNull(updatedProduct);


    }



    @Test
    void whenUpdateNewProduct_ThenUpdatedItemIsNotNullType() {

        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);
        assertNotNull(updatedProduct);


    }


    @Test
    void whenUpdateNewProduct_ThenUpdatedItemIsNotNullName() {

        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);
        assertNotNull(updatedProduct);


    }


    @Test
    void whenUpdateNewProduct_ThenUpdatedItemIsNotZeroPrice() {

        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);
        assertNotNull(updatedProduct);


    }



    @Test
    void whenUpdateNewProduct_ThenUpdatedItemIsNotNullCode() {

        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);
        assertNotNull(updatedProduct);


    }








    //Check values

    @Test
    void whenUpdateProduct_ThenCreatedCatagoryEquals() {
        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);

        assertEquals("Smartfones and mobile phones", updateProductRequest.category());
    }





    @Test
    void whenUpdateNewProduct_ThenCreatedTypeEquals() {
        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);

        assertEquals("Smartphones", updatedProduct.type());
    }



    @Test
    void whenUpdateNewProduct_ThenCreatedNameEqualsRedmiNote5A() {
        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);

        assertEquals("Redmi Note 5A", updatedProduct.name());


    }

    @Test
    void whenUpdateProduct_ThenPriceMoreThanEquals3444() {
        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);


        assertEquals(3444, updatedProduct.price());
    }


    @Test
    void whenUpdateProduct_ThenCreatedCodeEquals() {
        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);



        assertEquals("00001", updatedProduct.code());
    }
    @Test
    void whenUpdateProduct_ThenDescription() {
        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);


        assertEquals("###test", updatedProduct.description());
    }



    //CheckDates

    @Test
    void whenUpdateNewProduct_ThenCreatedDateIsNotNull()
    {
        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);

        assertNotNull(updatedProduct.createDate());


    }





    @Test
    void whenUpdateNewProduct_ThenCreatedDateIsUpdateDateNotNull() {
        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);

        assertNotNull(updatedProduct.updateDates());

    }



    @Test
    void whenUpdateNewProduct_ThenCreatedDateIsUpdateDateIsArrayList() {
        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);

        assertSame(ArrayList.class, updatedProduct.updateDates().getClass());


    }

    @Test
    void whenUpdateNewProduct_ThenCreatedDateIsUpdateDatesIsNotEmpy() {
        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");

        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);

        assertTrue(!updatedProduct.updateDates().isEmpty());

    }


    @Test
    void whenUpdateNewProduct_ThenCreatedDateIsUpdateDatesIsRelevant() {
        UpdateProductRequest updateProductRequest =new UpdateProductRequest("1","Smartfones and mobile phones", "Smartphone", "Redmi Note 5A", 3444,"00001", "###test");
        LocalDateTime now = LocalDateTime.now();


        ProductRequest  updatedProduct = underTest.updateItem(updateProductRequest);



    }











}



