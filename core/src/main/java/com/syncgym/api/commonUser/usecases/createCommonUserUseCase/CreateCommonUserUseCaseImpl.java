package com.syncgym.api.commonUser.usecases.createCommonUserUseCase;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.commonUser.exceptions.CommonUserAlreadyExistsException;
import com.syncgym.api.commonUser.exceptions.CommonUserInternalException;
import com.syncgym.api.commonUser.ports.CommonUserRepositoryService;
import com.syncgym.api.permission.enums.Permissions;
import com.syncgym.api.permission.exceptions.PermissionsNotFoundException;
import com.syncgym.api.permission.getPermissionByDescriptionUseCase.GetPermissionByDescriptionUseCase;
import com.syncgym.api.user.exceptions.UsernameAlreadyExists;
import com.syncgym.api.user.usecases.createUser.CreateUserUseCase;

import java.util.List;

public class CreateCommonUserUseCaseImpl implements CreateCommonUserUseCase {

    private final CommonUserRepositoryService commonUserRepositoryService;

    private final CreateUserUseCase createUserUseCase;

    private final GetPermissionByDescriptionUseCase getPermissionByDescriptionUseCase;

    public CreateCommonUserUseCaseImpl(CommonUserRepositoryService commonUserRepositoryService, CreateUserUseCase createUserUseCase, GetPermissionByDescriptionUseCase getPermissionByDescriptionUseCase) {
        this.commonUserRepositoryService = commonUserRepositoryService;
        this.createUserUseCase = createUserUseCase;
        this.getPermissionByDescriptionUseCase = getPermissionByDescriptionUseCase;
    }

    @Override
    public CommonUser execute(String username, String password, CommonUser commonUser) throws CommonUserAlreadyExistsException, CommonUserInternalException {
        try {
            var permission = getPermissionByDescriptionUseCase.execute(Permissions.COMMON_USER.getDescription());
            var user = createUserUseCase.execute(username, password, List.of(permission));
            return commonUserRepositoryService.save(commonUser, user);
        } catch (PermissionsNotFoundException e) {
            throw new CommonUserInternalException();
        } catch (UsernameAlreadyExists e) {
            throw new CommonUserAlreadyExistsException();
        }
    }
}
