import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {


    @Test
    public void test_jedis_set() throws Exception {

        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("name", "xiaolu");
        jedis.close();
        String s = "";
    }

    @Test
    public void test_jedis_get() throws Exception {
        Jedis jedis = new Jedis();
        String name = jedis.get("name");
        Assert.assertEquals("xiaolu", name);

    }
}
