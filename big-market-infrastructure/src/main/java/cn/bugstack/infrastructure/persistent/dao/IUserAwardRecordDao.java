package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.UserAwardRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 用户中奖记录表
 * @create 2024-04-03 15:57
 */
@Mapper
public interface IUserAwardRecordDao {

    void insert(UserAwardRecord userAwardRecord);

}
