package com.syncgym.api.security.services.signUpService;

import com.syncgym.api.permission.enums.Permissions;
import com.syncgym.api.permission.exceptions.PermissionsNotFoundException;
import com.syncgym.api.permission.getPermissionByDescriptionUseCase.GetPermissionByDescriptionUseCase;
import com.syncgym.api.security.exceptions.PermissionNotFoundException;
import com.syncgym.api.security.rest.AccountCredentials;
import com.syncgym.api.security.rest.Token;
import com.syncgym.api.security.services.signInService.SignInService;
import com.syncgym.api.shared.exceptions.BadRequestException;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.user.exceptions.UsernameAlreadyExists;
import com.syncgym.api.user.usecases.createUser.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private SignInService signInService;

    @Autowired
    private GetPermissionByDescriptionUseCase getPermission;

    @Override
    public Token execute(AccountCredentials accountCredentials) throws SyncgymException {
        try {
            createUserUseCase.execute(
                    accountCredentials.username(),
                    accountCredentials.password(),
                    List.of(getPermission.execute(Permissions.ADMIN.name()))
            );

            return signInService.execute(accountCredentials);
        } catch (UsernameAlreadyExists e) {
            throw new BadRequestException("Username already exists");
        } catch (PermissionsNotFoundException e) {
            throw new PermissionNotFoundException("Internal error");
        }
    }
}
