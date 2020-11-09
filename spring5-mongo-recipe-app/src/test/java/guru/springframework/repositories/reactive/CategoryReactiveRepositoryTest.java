package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

    @Autowired
    CategoryReactiveRepository categoryRepo;

    @Before
    public void setUp() throws Exception {
    categoryRepo.deleteAll().block();
    }

    @Test
    public void testSave() throws Exception {
        Category category = new Category();
        category.setDescription("Foo");

        categoryRepo.save(category).block();

        Long count = categoryRepo.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

    @Test
    public void testFindByDescription() throws Exception {
        Category category = new Category();
        category.setDescription("Foo");

        categoryRepo.save(category).then().block();

        Category fetchedCat = categoryRepo.findByDescription("Foo").block();

        assertNotNull(fetchedCat.getId());
    }
}