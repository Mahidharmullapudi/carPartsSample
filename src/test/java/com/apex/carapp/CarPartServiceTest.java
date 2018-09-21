package com.apex.carapp;

import com.apex.carapp.entities.CarPart;
import com.apex.carapp.repositories.CarRepository;
import com.apex.carapp.services.CarService;
import com.apex.carapp.services.CarServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
public class CarPartServiceTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public CarService carService() {
            return new CarServiceImpl();
        }
    }

    @Autowired
    private CarService carService;

    @MockBean
    private CarRepository carRepository;

    @Before
    public void setUp() {
        CarPart carPart = new CarPart();
        carPart.setMake("honda");
        carPart.setModel("accord");
        carPart.setYear("2018");

        List<CarPart> result = new ArrayList<>();
        result.add(carPart);
        Mockito.when(carRepository.findAll(Example.of(carPart)))
                .thenReturn(result);
    }

    @Test
    public void whenFindByModelMakeYear_thenReturnCarPart() {
        try {
            List<CarPart> found = carService.search("honda", "accord", "2018");

            assertThat(found.size())
                    .isEqualTo(1);

            assertThat(found.get(0).getModel())
                    .isEqualTo("honda");
            assertThat(found.get(0).getMake())
                    .isEqualTo("accord");
            assertThat(found.get(0).getYear())
                    .isEqualTo("2018");
        } catch (Exception ex) {

        }

    }
}
