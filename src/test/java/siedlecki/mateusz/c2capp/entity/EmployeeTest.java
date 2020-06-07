package siedlecki.mateusz.c2capp.entity;

import org.junit.jupiter.api.Test;
import siedlecki.mateusz.c2capp.entity.employee.EmployeeEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class EmployeeTest {


    @Test
    void builderWithId() {
        EmployeeEntity employee = EmployeeEntity.builder()
                .id(1L)
                .firstName("Jan")
                .lastName("Kowalski")
                .login("jankowalski")
                .build();

        assertNotNull(employee);
    }
}
