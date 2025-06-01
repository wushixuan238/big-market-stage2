package cn.bugstack.types.common;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * 自定义分表算法
 * 处理字符串类型的user_id
 */
public class MyTableAlgorithm implements StandardShardingAlgorithm<String> {

    private Properties props;
    
    @Override
    public String getType() {
        return "CLASS_BASED";
    }

    @Override
    public Properties getProps() {
        return props;
    }

    @Override
    public void init(Properties properties) {
        this.props = properties;
    }

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        int tableSize = collection.size();
        // 真实表的前缀
        String tablePrefix = preciseShardingValue.getDataNodeInfo().getPrefix();
        // 分片键的值
        long orderId = preciseShardingValue.getValue().hashCode() / 2;
        // 对分片键取模后确定位置
        long mod = Math.abs(orderId % tableSize);
        return tablePrefix + "00" + mod;
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        // 范围查询暂不支持
        return collection;
    }
}
