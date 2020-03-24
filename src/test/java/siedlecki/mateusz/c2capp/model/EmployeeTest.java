package siedlecki.mateusz.c2capp.model;

import org.junit.jupiter.api.Test;
import siedlecki.mateusz.c2capp.model.employee.Employee;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class EmployeeTest {


    @Test
    void builderWithId() {
        Employee employee = Employee.builder()
                .id(1L)
                .firstName("Jan")
                .lastName("Kowalski")
                .login("jankowalski")
                .build();

        assertNotNull(employee);
    }
}