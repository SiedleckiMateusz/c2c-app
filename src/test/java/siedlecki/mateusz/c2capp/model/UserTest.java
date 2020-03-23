package siedlecki.mateusz.c2capp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class UserTest {


    @Test
    void builderWithId() {
        User user = User.builder()
                .id(1L)
                .firstName("Jan")
                .lastName("Kowalski")
                .login("jankowalski")
                .build();

        assertNotNull(user);
    }
}