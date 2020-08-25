package cn.linjie;

import org.junit.Test;

import java.util.*;

public class TestDemo02 {
    //在map上使用泛型
    @Test
    public void testMap(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("aaa","111");
        map.put("bbb","222");
        map.put("ccc","333");
        //遍历map 有两种遍历方式
        //1.获取所有的key，通过key得到value 使用get方法
        //2.获取key和value的关系
        //使用第一种
        //获取所有的key
        Set<String> sets = map.keySet();
        //遍历所有key返回的set
        for (String key:sets){
            String value = map.get(key);
            System.out.println(key+":"+value);
        }
        //使用第二种
        //得到key和value的关系
        Set<Map.Entry<String,String>> set1 = map.entrySet();
        //遍历set1
        for (Map.Entry<String,String> entry:set1){
            //entry是key和value关系
            String keyv = entry.getKey();
            String valuev = entry.getValue();
            System.out.println(keyv+":"+valuev);
        }
    }

    //泛型使用在set集合上
    @Test
    public void testSet(){
        Set<String> set = new HashSet<String>();
        set.add("www");
        set.add("qqq");
        set.add("zzz");
        //遍历set有两种方式
        //迭代器 增强for
        //使用增强for来遍历
        for (String s:set){
            System.out.println(s);
        }
        System.out.println("==========");
        //使用迭代器遍历
        Iterator<String> it1 = set.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next());
        }
    }

    //泛型在list上的使用
    @Test
    public void testlist() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        //遍历list集合
        //普通for循环 迭代器 增强for循环
        //普通for
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("============");
        //使用增强for循环
        for (String s:list){
            System.out.println(s);
        }
        System.out.println("============");
        //使用迭代器遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
