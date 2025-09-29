# IOC&DI



# Bean

## 实例化

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

## 生命周期

![image-20250929180426391](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20250929180426391.png)

## 依赖注入

### 方式

* setter注入
* 构造器注入

### 选择

* 建议使用setter注入
* 第三方技术根据情况选择