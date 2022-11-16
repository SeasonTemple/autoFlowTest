package com.st.srcreview.bean;

public class OverloadAndOverride {

    public float getNum() {
        return 3.0f;
    }

    static class Sub extends OverloadAndOverride {
        // 重载发生在本类,方法名相同,参数列表不同,与返回值无关,只和方法名,参数列表,参数的类型有关.
        //（1）：方法名必须相同
        //（2）：方法的参数列表一定不一样。
        //（3）：访问修饰符和返回值类型可以相同也可以不同。
        // 简单而言：重载就是对于不同的情况写不同的方法。 比如，同一个类中，写不同的构造函数用于初始化不同的参数。

        public double getNum(float a) {
            return 4.0f;
        }

        public void getNum(int a) {
            return;
        }

        // 重写发生在父类子类之间,比如所有类都是继承与Object类的,Object类中本身就有equals, hashcode,toString方法等.在任意子类中定义了重名和同样的参数列表就构成方法重写.
        // 重写（override）：一般都是表示子类和父类之间的关系，其主要的特征是：方法名相同，参数相同，但是具体的实现不同。
        //（1）：方法名必须相同，返回值类型必须相同
        //（2）：参数列表必须相同
        //（3）：访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为public，那么在子类中重写该方法就不能声明为protected。
        //（4）：子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为private和final的方法。
        //（5）：构造方法不能被重写。
        //（6）：子类方法抛出的异常不能大于父类被重写方法的异常 （父类异常的子类）。
        // 简单而言：就是具体的实现类对于父类的该方法实现不满意，需要自己在写一个满足于自己要求的方法。
        @Override
        public float getNum() {
            return 1.0f;
        }
    }
}
