

# Spring

## IOC&DI



## Bean

### 实例化

四种方法：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<!--    配置bean-->

<!--    方式一：构造方法实例化bean-->
<!--    <bean id="bookDao" class="dao.impl.BookDaoImpl"/>-->

<!--    方式二：静态工厂实例化bean-->
<!--    <bean id="bookDao" class="factory.BookDaoFactory" factory-method="getBookDao"/>-->

<!--    方式四：使用FactoryBean实例化Bean-->
    <bean id="bookDao" class="factory.BookDaoFactoryBean"/>
</beans>
```

### 生命周期

![image-20250929180426391](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20250929180426391.png)

### 依赖注入

#### 方式

* setter注入
* 构造器注入

#### 选择

* 建议使用setter注入
* 第三方技术根据情况选择

### 第三方Bean

1. 第三方Bean管理
   * @Bean
2. 第三方Bean依赖注入
   * 引用类型：方法形参
   * 简单类型：成员变量

## 整合MyBatis

* MyBatis程序核心对象`SqlSessionFactory`

定义配置类`MybatisConfigure`

实现配置文件到类中Bean的转换

```java
public class MybatisConfigure {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setTypeAliasesPackage("com.itheima");
        ssfb.setDataSource(dataSource);
        return ssfb;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.itheima.dao");
        return msc;
    }
}

```



## 整合Junit

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
```



## AOP

### 核心概念

* 目标对象：原始功能去掉共性功能对应的类产生的对象，这种对象是无法直接完成工作的
* 代理：目标对象无法直接完成工作，需要对其功能回填，通过原始对象的代理对象实现

![image-20250930152009254](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20250930152009254.png)

### 入门案例

```java
@Configuration
@ComponentScan("com.itheima")
@EnableAspectJAutoProxy
public class SpringConfigure {
}

// 在配置类中，@EnableAspectJAutoProxy是核心注解，用于启动自动代理功能，使得@Before，@After，@Around能正常工作


@Component
@Aspect // AOP注解，加上才能生效
public class MyAdvice {

    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
    private void pt(){}

    @Before("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }
}
```

### 工作流程

1. Spring容器启动
2. 读取所有切面配置中的切入点`@PointCut`
3. 初始化Bean，判定Bean对应的类中的方法是否匹配到任意切入点
   * 匹配失败，创建对象
   * 匹配成功，创建原始对象（`目标对象`）的`代理`对象
4. 获取Bean执行方法
   * 获取Bean，调用方法并执行，完成操作
   * 获取的Bean是代理对象时，根据代理对象的运行模式运行原始方法与增强的内容，完成操作

### 切入点表达式

![image-20250930161302473](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20250930161302473.png)

### 通知类型

共五种，前置`Before`，后置`After`，环绕`Around`，返回后`AfterReturning`，抛出异常后`AfterThrowing`

> 其中环绕通知`Around`为重点

```java
@Around("pt()")
public Object around(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("around before...");
    // 调用代理的原始方法
    Object proceed = pjp.proceed();
    System.out.println("around after...");
    return proceed;
} 
```

![image-20250930172042045](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20250930172042045.png)

### 总结

![image-20250930190921213](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20250930190921213.png)

![image-20250930190931070](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20250930190931070.png)

![image-20250930191045591](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20250930191045591.png)



## 事务

* 在业务层接口上添加Spring事务管理

```java
public AccountServiceImpl implements AccountService{
    @Transactional
    public void transfer(String out,String in,Double money){
        int i = 1 / 0;
    }
}
```

* 设置事务管理器

```java
@Bean
public PlatformTransactionManager transactionManager(DataSource datasource){
    DataSourceTransactionManager ptm = new DataSourceTransactionManager();
    
    ptm.setDataSource(dataSource);
    return ptm;
}
```

* 开启注解式事务驱动`@EnableTransactionManagement`



# SpringMvc

## ssm整合

![image-20251002194508279](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251002194508279.png)
