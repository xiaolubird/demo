import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    @Test
    public void test_pool_set() {
        JedisPoolConfig config = new JedisPoolConfig();
        // 最小连接数
        config.setMaxIdle(2);
        // 最大连接数
        config.setMaxTotal(10);
        // 最大等待时间
        config.setMaxWaitMillis(1000 * 2);

        // 获取连接时测试链接是否畅通
        config.setTestOnBorrow(true);

        JedisPool pool = new JedisPool(config, "localhost", 6379);
        Jedis jedis = pool.getResource();

        jedis.set("age", "23");
        Assert.assertEquals("23", jedis.get("age"));
        jedis.close();

        pool.destroy();
    }
}


