package springcloud.entity;

import cn.hutool.core.bean.BeanUtil;

import java.util.HashMap;
import java.util.Map;

public class CopyTest {
    public static void main(String[] args) {
        Person p = new Person("zs",18,'男');
        Map<String,Object> map = new HashMap<>();
        BeanUtil.copyProperties(p,map);
        System.out.println(map);
    }
}
