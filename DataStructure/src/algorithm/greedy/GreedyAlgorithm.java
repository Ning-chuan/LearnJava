package algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    /**
     * 利用贪心算法求出能覆盖所有地区的电台组合
     */
    public static void main(String[] args) {
        //定义一个map 存储广播电台和它覆盖的地区
        HashMap<String, HashSet<String>> broadcast = new HashMap<>();

        //定义广播电台 并加入到broadcast
        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");
        broadcast.put("K1", set1);
        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");
        broadcast.put("K2", set2);
        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");
        broadcast.put("K3", set3);
        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");
        broadcast.put("K4", set4);
        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");
        broadcast.put("K5", set5);

        //allAreas存储所有未覆盖地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");


        //定义selects 存放已经选择的电台集合 刚开始为空
        ArrayList<String> selects = new ArrayList<>();
        //定义maxKey 存储每次for循环中能覆盖最多未覆盖地区的电台
        String maxKey;
        //定义curSet 存储当前电台未覆盖地区与未覆盖地区的交集
        HashSet<String> curSet = new HashSet<>();

        //核心步骤：只要还有地区没有覆盖，就一直循环
        while (allAreas.size() > 0) {
            maxKey = null;
            //遍历所有电台
            for (String key : broadcast.keySet()) {
                //0.置空curSet
                curSet.clear();
                //1.求当前电台覆盖地区与未覆盖地区的交集
                HashSet<String> areas = broadcast.get(key);
                curSet.addAll(areas);
                curSet.retainAll(allAreas);
                //2.看看是否需要更改maxKey
                if (curSet.size() > 0) {
                    if(maxKey == null){
                        maxKey = key;
                    }else{
                        //求maxKey电台覆盖地区和未覆盖地区的交集
                        HashSet<String> preSet = broadcast.get(maxKey);
                        preSet.retainAll(allAreas);
                        if(curSet.size() > preSet.size()){
                            //当前电台能覆盖更多的地区，把maxKey置为当前
                            maxKey = key;
                        }
                    }
                }

            }
            //3.循环结束，如果存在maxKey，加入结果集，然后移除已经覆盖的地区
            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcast.get(maxKey));
                HashSet<String> set = broadcast.get(maxKey);
            }


        }

        System.out.println(selects);

    }
}
