package siedlecki.mateusz.c2capp.service.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import siedlecki.mateusz.c2capp.entity.employee.EmployeeEntity;
import siedlecki.mateusz.c2capp.repository.employee.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeSerivceTest {

    @InjectMocks
    EmployeeSerivce employeeSerivce;

    @Mock
    EmployeeRepository employeeRepository;

    EmployeeEntity someEmployee;

    @BeforeEach
    void setUp() {
        someEmployee = EmployeeEntity.builder()
                .firstName("Mateusz")
                .lastName("Siedlecki")
                .login("msiedlecki")
                .password("1234")
                .email("siedleckimateus@gmail.com")
                .build();
    }

    @Test
    void findAll() {
//        given
        List<EmployeeEntity> employees = new ArrayList<>();
        employees.add(someEmployee);
        when(employeeRepository.findAll()).thenReturn(employees);

//        when
        List<EmployeeEntity> allEmployees = employeeSerivce.findAll();

//        then
        assertEquals(1,allEmployees.size());
        verify(employeeRepository,times(1)).findAll();
    }

    @Test
    void findById() {
//        given
        when(employeeRepository.findById(any())).thenReturn(Optional.of(someEmployee));

//        when
        Optional<EmployeeEntity> byIdEmployee = employeeSerivce.findById(1L);

//        then
        assertNotNull(byIdEmployee);
        verify(employeeRepository, times(1)).findById(any());

    }

    @Test
    void findByIdNotFound() {
//        given
        when(employeeRepository.findById(any())).thenReturn(Optional.empty());

//        when
        EmployeeEntity byIdEmployee = employeeSerivce.findById(1L).orElse(null);

//        then
        assertNull(byIdEmployee);
        verify(employeeRepository, times(1)).findById(any());

    }

    @Test
    void save() {
//        given
        EmployeeEntity employee = EmployeeEntity.builder().id(1L).build();
        when(employeeRepository.save(any())).thenReturn(someEmployee);

//        when
        EmployeeEntity savedEmployee = employeeSerivce.save(employee);

//        then
        assertNotNull(savedEmployee);
        verify(employeeRepository,times(1)).save(any());

    }
}
