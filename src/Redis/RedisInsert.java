package Redis;

import redis.clients.jedis.Jedis;

public class RedisInsert {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.0.111");
        for(int i = 0; i < 10000; i++) {
            jedis.set("key"+i, String.valueOf(i));
        }
    }
}
