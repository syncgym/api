package com.syncgym.api.security.services.signUpService;

import com.syncgym.api.permission.enums.Permissions;
import com.syncgym.api.permission.exceptions.PermissionsNotFoundException;
import com.syncgym.api.permission.getPermissionByDescriptionUseCase.GetPermissionByDescriptionUseCase;
import com.syncgym.api.security.entities.AccountCredentials;
import com.syncgym.api.security.entities.Token;
import com.syncgym.api.security.exceptions.PermissionNotFoundException;
import com.syncgym.api.security.services.signInService.SignInService;
import com.syncgym.api.shared.exceptions.BadRequestException;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.user.exceptions.UsernameAlreadyExists;
import com.syncgym.api.user.usecases.createUser.CreateUserUseCase;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class SignUpServiceImpl implements SignUpService {

    private final CreateUserUseCase createUserUseCase;

    private final SignInService signInService;

    private final PasswordEncoder passwordEncoder;

    private final GetPermissionByDescriptionUseCase getPermission;

    public SignUpServiceImpl(CreateUserUseCase createUserUseCase, SignInService signInService, PasswordEncoder passwordEncoder, GetPermissionByDescriptionUseCase getPermission) {
        this.createUserUseCase = createUserUseCase;
        this.signInService = signInService;
        this.passwordEncoder = passwordEncoder;
        this.getPermission = getPermission;
    }

    @Override
    public Token execute(AccountCredentials accountCredentials) throws SyncgymException {
        try {
            createUserUseCase.execute(
                    accountCredentials.username(),
                    passwordEncoder.encode(accountCredentials.password()),
                    List.of(getPermission.execute(Permissions.COMMON_USER.name()))
            );

            return signInService.execute(accountCredentials);
        } catch (UsernameAlreadyExists e) {
            throw new BadRequestException("Username already exists");
        } catch (PermissionsNotFoundException e) {
            throw new PermissionNotFoundException("Internal error");
        }
    }
}
