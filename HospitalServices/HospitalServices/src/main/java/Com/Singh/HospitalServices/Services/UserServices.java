package Com.Singh.HospitalServices.Services;

import Com.Singh.HospitalServices.Dto.UserRequestDto;
import Com.Singh.HospitalServices.Dto.UserResponseDto;

public interface UserServices {

    UserResponseDto createUserAccount(UserRequestDto userRequestDto);
}
