package test;

import com.sun.org.apache.bcel.internal.generic.I2B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiechao
 * @version 1.0.0
 * @date 2020/4/17 9:29
 * @description
 */
public class Jdk8Test {
    public static void main(String[] args) {
//        lambda表达式，需要注意：
//          (参数列表) -> {代码块}
//                - 参数类型可省略，编译器可以自己推断
//                - 如果只有一个参数，圆括号可以省略
//                - 代码块如果只是一行代码，大括号也可以省略
//                - 如果代码块是一行，且是有结果的表达式，`return`可以省略

//        List<Integer> list1 = Arrays.asList(10,5,25,-15,20);
//        // Jdk1.8写法，参数列表的数据类型可省略：
//        list1.sort((i1, i2) -> {return i1 - i2;});
////        如果代码块是一行，且是有结果的表达式，`return`可以省略
//        list1.sort((i1, i2) -> i1 - i2);
//        // 因为代码块是一个有返回值的表达式，可以省略大括号以及return
//        list1.sort((i1, i2) ->  i1 - i2);
//        System.out.println(list1);

        // JDK1.8遍历并打印集合，因为只有一个参数，所以我们可以省略小括号:
//        list1.forEach(i -> System.out.println(i));
//        // 这里遍历元素后需要打印，因此直接把println作为方法引用传递了
//        list1.forEach(System.out::println);

        List<Teacher> list = new ArrayList<>();
        list.add(new Teacher(28,"李四"));
        list.add(new Teacher(27,"张三"));
        list.add(new Teacher(29,"王五"));
//        list.add(Teacher.builder().age(28).name("李四").build());
//        list.add(Teacher.builder().age(27).name("张三").build());
//        list.add(Teacher.builder().age(29).name("王五").build());

//        //适合只对原数据读操作，集合还是原来的这个集合，但可以更改集合中的数据

        list.stream().forEach(teacher -> {
            if ("王五".equals(teacher.getName())) {
                teacher.setAddress("南京");
//                Address address = Address.builder().address("南京").build();
//                teacher.setAddress(address);
            }
        });
        System.out.println("还是老的List：" + list);
//
//        //不影响原数据，生成新数据
//        List<Teacher> listCopy = list.stream().map(teacher -> {
//            if ("王五".equals(teacher.getName())) {
//                Address address = Address.builder().address("南京").build();
//                teacher.setAddress(address);
//            }
//            return teacher;
//        }).collect(Collectors.toList());
//        System.out.println("产生新的List：" + listCopy);

//        //过滤
//        List<Teacher> listFilter = list.stream().filter(
//                teacher -> AllTypeUtils.isNotEmptyAndNotNull(teacher.getAddress()
//                )).collect(Collectors.toList());
//        System.out.println("产生新的List：" + listFilter);
//
//        //排序：升序（第一种写法）
//        List<Teacher> listSortedAsc1 = list.stream().sorted(Comparator.comparing(Teacher::getAge)
//        ).collect(Collectors.toList());
//        System.out.println("产生新的List：" + listSortedAsc1);
//
//        //排序：升序（第二种写法）
//        List<Teacher> listSortedAsc2 = list.stream().sorted((teacher1, teacher2) -> {
//                    return teacher1.getAge().compareTo(teacher2.getAge());
//                    //这种升序排列被编译器建议写成：Comparator.comparing(Teacher::getAge)
//                }
//        ).collect(Collectors.toList());
//        System.out.println("产生新的List：" + listSortedAsc2);
//
//        //排序：降序（第一种写法）
//        List<Teacher> listSortedDesc = list.stream().sorted(Comparator.comparing(Teacher::getAge).reversed()
//        ).collect(Collectors.toList());
//        System.out.println("产生新的List：" + listSortedDesc);
//
//        //排序：降序（第二种写法）
//        List<Teacher> listSortedDesc2 = list.stream().sorted((teacher1, teacher2) -> {
//                    return teacher2.getAge().compareTo(teacher1.getAge());
//                }
//        ).collect(Collectors.toList());
//        System.out.println("产生新的List：" + listSortedDesc2);


    }
}
