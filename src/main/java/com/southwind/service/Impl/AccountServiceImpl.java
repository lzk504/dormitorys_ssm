package com.southwind.service.Impl;

import com.southwind.dto.AccountDto;
import com.southwind.entity.DormitoryAdmin;
import com.southwind.entity.SystemAdmin;
import com.southwind.form.AccountForm;
import com.southwind.mapper.DormitoryAdminMapper;
import com.southwind.mapper.SystemAdminMapper;
import com.southwind.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzk
 * @create 2022-07-05 17:20
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private SystemAdminMapper systemAdminMapper;
    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;
    /**
     * 用户登录
     *
     * @param accountForm
     * @return
     */
    @Override
    public AccountDto login(AccountForm accountForm) {
        AccountDto dto = new AccountDto<>();
        //判读用户类型
        switch (accountForm.getType()) {
            case "systemAdmin":
                SystemAdmin systemAdmin = this.systemAdminMapper.findByUsername(accountForm.getUsername());
                //判断用户名是否正确
                if(systemAdmin == null){
                    dto.setCode(-1);
                }else{
                    //判断密码是否正确
                    if(!systemAdmin.getPassword().equals(accountForm.getPassword())){
                        dto.setCode(-2);
                    }else{
                        dto.setCode(0);
                        dto.setAdmin(systemAdmin);
                    }
                }
                break;
            case "dormitoryAdmin":
                DormitoryAdmin dormitoryAdmin = dormitoryAdminMapper.findByUsername(accountForm.getUsername());
                //判断用户名是否正确
                if(dormitoryAdmin == null){
                    dto.setCode(-1);
                }else{
                    //判断密码是否正确
                    if(!dormitoryAdmin.getPassword().equals(accountForm.getPassword())){
                        dto.setCode(-2);
                    }else{
                        dto.setCode(0);
                        dto.setAdmin(dormitoryAdmin);
                    }
                }
                break;
        }
        return dto;
    }
}
