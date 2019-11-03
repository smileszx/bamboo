# Thread 和 Runnable 区别

面试官究竟想获取什么信息呢？

## 异同点总结
### 1 Thread不适合资源共享；Runnable容易实现资源共享
### 2 Runnable可以避免单继承限制（不能访问父类的私有成员）
### 3 增加程序健壮性，代码可以被多个线程共享，代码和数据独立
### 4 线程池中只能放入实现Runnable或Callable的线程，不能直接放入继承Thread类的线程

换个角度
- Runnable是接口
- Thread是类，且实现了Runnable接口
- 使用Runnable定义的子类无start方法，只有Thread类中才有
- Thread类有一个构造方法，public Thread(Runnable target) 该构造方接受Runnable子类实例
Thread类可以启动Runnable。
- 使用场景，程序开发中只要是多线程肯定以实现Runnable接口为主
好处：
避免继承的局限，一个类可以实现多个接口
适合资源共享



线程资源是宝贵资源