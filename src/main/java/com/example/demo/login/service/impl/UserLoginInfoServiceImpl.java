package com.example.demo.login.service.impl;

import com.example.demo.login.entity.UserLoginInfo;
import com.example.demo.login.mapper.UserLoginInfoMapper;
import com.example.demo.login.service.IUserLoginInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录信息表 服务实现类
 * </p>
 *
 * @author dingzc
 * @since 2021-04-12
 */
@Service
public class UserLoginInfoServiceImpl extends ServiceImpl<UserLoginInfoMapper, UserLoginInfo> implements IUserLoginInfoService {

}
