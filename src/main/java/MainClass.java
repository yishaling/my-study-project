import java.util.*;

public class MainClass {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int count = 0;
        String min_ = "";
        String max_ = "";
        while (reader.hasNext()) {
            ++count;

            if (count == 2) {
                max_ = reader.nextLine();
                Integer min = Integer.valueOf(min_);
                Integer max = Integer.valueOf(max_);
                int num = 0;
                for (int i = min; i <= max; i++) {
                    for (int j = min; j <= max; j++) {
                        int thisNum = i & j;
                        int thisNum2 = i | j;
                        if (thisNum > thisNum2 && thisNum > num) {
                            num = thisNum;
                        } else if (thisNum < thisNum2 && thisNum2 > num) {
                            num = thisNum2;
                        }
                    }

                }
                System.out.println(num);
            } else if (count == 1) {
                min_ = reader.nextLine();
            }

        }

    }

    /**
     * 第二题 这种处理方式就有问题，个人觉得最好的处理方式是用SQL+DTO 方式处理
     * 1.select table1*,table2.* from table1 left join table2 table1.${fieldName} =table2.${fieldName} -->包含所有信息的DTO List
     * 2.dto中用get 方法里面写逻辑 ---> 包装为Map 或者Entity
     * <p>
     * 以下是原题处理方式的程序
     *
     * @param list1
     * @param list2
     * @param fildName
     * @return
     */
    public List<Map<String, Object>> margeList(List<Map<String, Object>> list1, List<Map<String, Object>> list2, String fildName) {
        for (Map<String, Object> data1 : list1) {
            Object f1 = data1.get(fildName);
            for (Map<String, Object> data2 : list2) {
                Object f2 = data2.get(fildName);
                //判断某字段是否相等
                if (null != f2 && f2.equals(f1)) {
                    Set<Map.Entry<String, Object>> entries = data2.entrySet();
                    for (Map.Entry<String, Object> entry : entries) {
                        String key2 = entry.getKey();
                        //如果表A没有值 则将表B的字段值赋予A
                        if (data1.get(key2) == null) {
                            data1.put(key2, entry.getValue());
                        }
                    }

                }
            }
        }
        return list1;

    }

    public List<Map<String, Object>> margeList2(List<Map<String, Object>> list1, List<Map<String, Object>> list2, String fildName) {
        List<Object> list = new ArrayList<>();
        for (Map<String, Object> data2 : list2) {
            if(data2.get(fildName)!=null){
                list.add(data2.get(fildName));
            }

        }
        for (Map<String, Object> data1 : list1) {
            boolean contains = list.contains(data1.get(fildName));

        }
        return list1;

    }

}
