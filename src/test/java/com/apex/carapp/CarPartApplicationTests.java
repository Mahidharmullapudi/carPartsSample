package com.apex.carapp;

import com.apex.carapp.entities.CarPart;
import com.apex.carapp.repositories.CarRepository;
import com.apex.carapp.services.CarService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class CarPartApplicationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void whenAdd_thenReturnCarPart() {
        // given
        CarPart carPart = new CarPart();
        carPart.setMake("toyota");
        carPart.setModel("camry");
        carPart.setYear("2017");
        entityManager.persist(carPart);
        entityManager.flush();
        // when
        CarPart found = carRepository.findById(Long.valueOf("1")).get();
        // then
        assertThat(found.getPartId())
                .isEqualTo(1);
        assertThat(found.getMake())
                .isEqualTo(carPart.getMake());
        assertThat(found.getModel())
                .isEqualTo(carPart.getModel());
        assertThat(found.getYear())
                .isEqualTo(carPart.getYear());
    }

    @Test
    public void whenRemove_thenNoCarPart() {
        // given
        CarPart carPart = new CarPart();
        carPart.setMake("toyota");
        carPart.setModel("camry");
        carPart.setYear("2017");
        entityManager.persist(carPart);
        entityManager.flush();
        // when
        carRepository.delete(carPart);
        Optional<CarPart> found = carRepository.findById(Long.valueOf("1"));
        // then
        Assert.assertFalse(found.isPresent());
    }

    @Test
    public void whenFindById_thenReturnCarPart() {
        // given
        CarPart carPart = new CarPart();
        carPart.setMake("honda");
        carPart.setModel("accord");
        carPart.setYear("2018");
        entityManager.persist(carPart);
        entityManager.flush();
        // when
        CarPart found = carRepository.findById(Long.valueOf("1")).get();
        // then
        assertThat(found.getModel())
                .isEqualTo(carPart.getModel());
        assertThat(found.getMake())
                .isEqualTo(carPart.getMake());
        assertThat(found.getYear())
                .isEqualTo(carPart.getYear());
    }
}
