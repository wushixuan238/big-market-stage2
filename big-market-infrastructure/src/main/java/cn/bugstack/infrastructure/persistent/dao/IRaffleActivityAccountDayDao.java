package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.RaffleActivityAccountDay;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 抽奖活动账户表-日次数
 * @create 2024-04-03 15:56
 */
@Mapper
public interface IRaffleActivityAccountDayDao {

    RaffleActivityAccountDay queryActivityAccountDayByUserId(RaffleActivityAccountDay raffleActivityAccountDayReq);

    int updateActivityAccountDaySubtractionQuota(RaffleActivityAccountDay raffleActivityAccountDay);

    void insertActivityAccountDay(RaffleActivityAccountDay raffleActivityAccountDay);

    Integer queryRaffleActivityAccountDayPartakeCount(RaffleActivityAccountDay raffleActivityAccountDay);

    void addAccountQuota(RaffleActivityAccountDay raffleActivityAccountDay);

}
