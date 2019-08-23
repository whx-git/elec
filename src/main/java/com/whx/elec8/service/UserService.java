package com.whx.elec8.service;

import com.whx.elec8.domain.ElecUser;
import com.whx.elec8.domain.LoginResultInfo;

public interface UserService {

    public LoginResultInfo login(String name, String password);
}
