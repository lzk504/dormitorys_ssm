package com.southwind.service;

import com.southwind.dto.AccountDto;
import com.southwind.form.AccountForm;

/**
 * @author lzk
 * @create 2022-07-05 17:16
 */
public interface AccountService {
    public AccountDto login(AccountForm accountForm);
}
