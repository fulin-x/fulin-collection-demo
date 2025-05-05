import com.fulin.FulinHashMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @Author: Fulin
 * @Description: HashMap测试
 * @DateTime: 2025/5/5 下午1:17
 **/
public class FulinHashMapTest {

    @Test
    public void testApi() {
        FulinHashMap<String, String> map = new FulinHashMap<>();
        int count = 100000;
        for (int i = 0; i < count; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }

        assertEquals(count, map.size());

        for (int i = 0; i < count; i++) {
            assertEquals(String.valueOf(i), map.get(String.valueOf(i)));
        }

        map.remove("5");
        assertNull(map.get("5"));
        assertEquals(count - 1, map.size());
    }
}
