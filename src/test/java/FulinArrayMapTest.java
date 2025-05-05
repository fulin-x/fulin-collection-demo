import com.fulin.FulinArrayMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @Author: Fulin
 * @Description: HashMap测试
 * @DateTime: 2025/5/5 下午1:17
 **/
public class FulinArrayMapTest {

    @Test
    public void testApi() {
        FulinArrayMap<String, String> map = new FulinArrayMap<>();
        int count = 10000;
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
