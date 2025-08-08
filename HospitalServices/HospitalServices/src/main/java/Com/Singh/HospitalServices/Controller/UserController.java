package Com.Singh.HospitalServices.Controller;


import Com.Singh.HospitalServices.Dto.UserRequestDto;
import Com.Singh.HospitalServices.Dto.UserResponseDto;
import Com.Singh.HospitalServices.Services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    private  final  UserServices userServices;


    @PostMapping("/createUser")
    public UserResponseDto addNewUser(@RequestBody UserRequestDto userRequestDto)
    {
        return userServices.createUserAccount(userRequestDto);
    }

}
