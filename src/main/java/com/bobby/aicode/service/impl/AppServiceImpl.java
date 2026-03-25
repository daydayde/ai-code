package com.bobby.aicode.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.bobby.aicode.model.entity.App;
import com.bobby.aicode.mapper.AppMapper;
import com.bobby.aicode.service.AppService;
import org.springframework.stereotype.Service;

/**
 * 应用 服务层实现。
 *
 * @author <a href="https://github.com/daydayde">Bobby</a>
 */
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, App>  implements AppService{

}
