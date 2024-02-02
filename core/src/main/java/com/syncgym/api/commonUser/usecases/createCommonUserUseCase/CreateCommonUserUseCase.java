package com.syncgym.api.commonUser.usecases.createCommonUserUseCase;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.commonUser.exceptions.CommonUserAlreadyExistsException;
import com.syncgym.api.commonUser.exceptions.CommonUserInternalException;

public interface CreateCommonUserUseCase {

    CommonUser execute(String username, String password, CommonUser commonUser) throws CommonUserAlreadyExistsException, CommonUserInternalException;
}
