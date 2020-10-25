

### 1.第一个SpringBoot程序：

**搭建SpringBooot开发环境的两种方式：**

#### 1. 方式一：从spring官网下载

- 进入官网：[SpringBoot官网](https://spring.io/projects/spring-boot#overview)

![image-20201024094716324](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024094716.png)

![image-20201024094942598](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024094942.png)

- 点击上图中GENERATE进行下载

- 下载解压后用idea打开

  ![image-20201024095635299](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024095635.png)

- 在DemoApplication==同级目录==下建一个controller测试

  ![image-20201024100100880](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024100101.png)

  ![image-20201024100338237](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024100338.png)

  浏览器出现如下界面，就成功了！

  ![image-20201024100358105](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024100358.png)

- 拓展：打成jar包运行

  ![image-20201024101301707](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024101301.png)



#### 2. 方式二：idea创建SpringBoot项目

##### 1. 步骤：

![image-20201024114213070](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024114213.png)

![image-20201024114310363](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024114310.png)

![image-20201024114432854](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024114432.png)



![image-20201024114358380](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024114358.png)





修改端口号：

![image-20201024102854912](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024102855.png)

更改banner

![image-20201024102817762](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024102948.png)

![image-20201024102759178](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024102759.png)



### 2. yaml

1. 基础语法：

   ![image-20201024115330526](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024115330.png)

2. 给属性赋值：

   ![image-20201024120537983](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024120538.png)

3. yaml特有语法：

   <img src="https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024121522.png" alt="image-20201024121522471" style="zoom:67%;" />

### 3. 多环境配置：

- 使用.properties配置

  ![image-20201024152344829](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024152933.png)

- 使用yaml配置：

  ![image-20201024152919352](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024152919.png)

  ![image-20201024165252612](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024173820.png)

### 4. 使用SpringBoot开发

####  1. 设置自定义配置的一个技巧

1. 搜索要找的自动配置类（以WebMvcAutoConfiguration类为例）

   ![image-20201024171740004](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024171740.png)

2. 在这个类中找到要配置的properties类的位置

   ![image-20201024172550091](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024172550.png)

3. 在配置文件中配置这个类中对应的属性即可

   ![image-20201024172342631](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024172342.png)

   ![image-20201024172812968](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024172813.png)

### 5. Thymeleaf使用

![image-20201024200820084](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024200820.png)

![image-20201024201305688](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201024201305.png)

### 6. 自定义视图解析

![image-20201025085514651](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025085626.png)

![image-20201025090704783](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025090704.png)

### 7. 员工管理系统案例：

#### 1. 静态页面使用Thymeleaf

![image-20201025103745254](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025103745.png)

![image-20201025110700186](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025110700.png)

![image-20201025111303189](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025111303.png)

- 使用fragment

  ![image-20201025121131731](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025121132.png)

  ![image-20201025121304470](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025121304.png)

- 展示员工：

  ![image-20201025123230281](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025123230.png)

关闭模板引擎缓存：![image-20201025103855401](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025103855.png)

- 取值问题

  ![image-20201025151622673](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025151622.png)

#### 2. 配置国际化

- 国际化配置文件准备

![image-20201025105150118](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025105150.png)

- 配置properties文件让上一步的文件生效

  ![image-20201025105808064](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025105808.png)

![image-20201025105956921](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025105957.png)

- 自定义地区解析组件 `LocaleResolver`

  ![image-20201025112213381](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025112358.png)

- 注册到spring中`@Bean`

  ![image-20201025112347622](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025112347.png)

- 

### 8. 整合JDBC

#### 1. 创建项目：

![image-20201025164403733](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025164403.png)

#### 2. 使用jdbcTemplate

![image-20201025172135830](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025172136.png)

###  9. 整合Druid

- 使用Druid数据源

![image-20201025174217518](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025174217.png)

- 把自己配置的Druid数据源注册到Spring容器中

  ![image-20201025175208271](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025175208.png)

- 开启Druid后台监控

  ![image-20201025180206649](https://gitee.com/yuziyan/cloudimage/raw/master/img/20201025180206.png)