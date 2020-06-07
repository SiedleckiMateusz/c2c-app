package siedlecki.mateusz.c2capp.controller.model.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShowEmployee {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private String phoneNumber;
    private ShowWorkPosition workPosition;
    private ShowDepartment department;

}
