package com.syncgym.api.commonUser.usecases.getByUsernameCommonUserUseCase;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.commonUser.exceptions.CommonUserNotFoundException;

public interface GetByUsernameCommonUserUseCase {

    CommonUser execute(String username) throws CommonUserNotFoundException;
}
