package com.easypan.component;

import com.easypan.entity.constants.Constants;
import com.easypan.entity.dto.SysSettingsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("redisComponent")
public class RedisComponent {
    @Autowired
    private RedisUtils redisUtils;

    public SysSettingsDto getSysSettingsDto(){
        SysSettingsDto sysSettingsDto= (SysSettingsDto) redisUtils.get(Constants.REDIS_KEY_SYS_SETTING);
        if(sysSettingsDto==null){
            sysSettingsDto = new SysSettingsDto();
            redisUtils.set(Constants.REDIS_KEY_SYS_SETTING,sysSettingsDto);
        }
        return sysSettingsDto;
    }
}
