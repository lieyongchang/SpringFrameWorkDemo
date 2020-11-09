package guru.springframework.repositories.reactive;

import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureReactiveRepositoryTest {
    public static final String EACH = "Each";

    @Autowired
    UnitOfMeasureRepository uomRepo;

    @Before
    public void setUp() throws Exception {
    uomRepo.deleteAll();
    }

    @Test
    public void testSaveUom() throws Exception {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(EACH);

        uomRepo.save(uom);

        Long count = uomRepo.count();

        assertEquals(Long.valueOf(1L), count);

    }

    @Test
    public void testFindByDescription() throws Exception {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(EACH);

        uomRepo.save(uom);

        UnitOfMeasure fetchedUOM = uomRepo.findByDescription(EACH).get();

        assertEquals(EACH, fetchedUOM.getDescription());

    }
}