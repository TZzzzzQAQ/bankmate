package com.friedchicken.account.mapper;

import com.friedchicken.account.dto.CustomerAccountDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerAccountMapper {
    CustomerAccountDto findByMobile(@Param("mobileNumber") String mobileNumber);
}
