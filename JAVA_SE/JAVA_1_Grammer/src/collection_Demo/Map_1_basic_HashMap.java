package collection_Demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Map_1_basic_HashMap {

	public static void main(String[] args) {
		// 创建 MAP是无序的
		Map<String, String> hm = new HashMap<String, String>();

		// 添加 key(object) value(object) 如果原来就有这个key 会返回原来的value
		System.out.println(hm.put("aKey", "aValue"));// null
		System.out.println(hm.put("aKey", "cValue"));// aValue
		hm.put("bKey", "bValue");
		// 大小
		System.out.println(hm.size());// 2
		// 是否为空 isEmpty()

		// 是否含有 key 返回boolean
		System.out.println(hm.containsKey("aKey"));
		// 是否含有 value 返回boolean
		System.out.println(hm.containsValue("aValue"));
		
		//修改 重新放一个相同的key,会自动覆盖value的。也可以拿出来直接做操作
		String string = hm.get("aKey");
		string=string+"111111";
		System.out.println(hm.get("aKey"));
		// 两个map合并 putAll
		
		
		// get 根据key查找value 不存在返回null
		System.out.println(string);
		// 删除 返回删除的元素
		System.out.println(hm.remove("aKey"));
		// putAll 加入一个MAP 对象
		// clear 清空

		// 遍历 通过key遍历
		Iterator<String> it = hm.keySet().iterator();// 遍历key
		while (it.hasNext()) {
			// 取出key
			String key = it.next().toString();
			// 通过key得到value
			String value = hm.get(key);
		}

		// 遍历2 entrySet 感觉比上一个麻烦一些
		Set<Map.Entry<String, String>> entries = hm.entrySet();
		Iterator<Map.Entry<String, String>> iterator = entries.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			// 得到key和value
			entry.getKey();
			entry.getValue();

		}

	}

}
