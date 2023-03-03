[toc]
----

### 
#### 初始化配置
##### github创建仓库
- 生成密钥：进入家目录，如果没有`.ssh`文件的话，执行`ssh-keygen`；
- 进入`.ssh`，打开`id_rsa.pub`：`cat id_rsa.pub`，复制公钥；
- 上传到github；
- 在文件夹下gitbash，`git init`：初始化仓库。(此时在本地已经创建仓库，可以`git commit`)
- 接入到云端：
  - `git remote add origin git@github.com:Yuxy518/AssetTradingPlatform.git`；
  - `git push -u origin master`；
- 在另外一台电脑上克隆：`git clone git@github.com:Yuxy518/AssetTradingPlatform.git`；
- 拉取最新版本：`git pull`；
- 上传最新版本：`git push`；

---
##### 后端初始化
- 在resources.application.properties下设置端口地址`server.port=3000`；
- 解决跨域问题：添加配置类`CorsConfig`；
- 在`pom.xml`文件中添加`mybiats`依赖；[Maven仓库地址](https://mvnrepository.com/)
  - `Spring Boot Starter JDBC`
  - `Project Lombok`
  - `MySQL Connector/J`
  - `mybatis-plus-boot-starter`
  - `mybatis-plus-generator`
- 在`application.properties`中添加数据库配置；
    ```java
    spring.datasource.username=root
    spring.datasource.password=123456
    spring.datasource.url=jdbc:mysql://localhost:3306/kob?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    ```

##### 修改Spring Security
- 添加依赖：
  - `spring-boot-starter-security`
  - 此时访问后端页面需要授权，可以通过`user`,`随机密码`来登录访问；
- 实现`service.impl.UserDetailsServiceImpl`类，继承自`UserDetailsService`接口，用来接入数据库信息(其中需要实现`UserDetailsImpl`类)；
  - 此时需要将数据库中的密码声明为明文(`{noop}`)；
  - 可以用数据库里的`用户名`和`密码`来登录授权页面；
- 实现`config.SecurityConfig`类，用来实现用户密码的加密存储；
  - 此时就需要将数据库中的密码进行`BCrypt`加密；
  - 用数据库里的`用户名`和`密码`来登录；

##### 配置jwt验证
- 添加依赖：
  - `jjwt-api`
  - `jjwt-impl`
  - `jjwt-jackson`
- 实现`utils.JwtUtil`类，为jwt工具类，用来创建、解析jwt token
- 实现`config.filter.JwtAuthenticationTokenFilter`类，用来验证jwt token，如果验证成功，则将User信息注入上下文中
- 配置config.SecurityConfig类，放行登录、注册等接口
---

#### 常见报错
```java
Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.NullPointerException] with root cause

java.lang.NullPointerException: null
```
原因：
- 数据库中字段名称不能有`_`或者`大写字母`
- Pojo层中，数据表对应的类需要加注解：
  ```java
  @TableName(value = "refinanceinfo") //对应数据表的表名
  ```

---
#### 知识点
##### 获取全局变量store中属性
- ```js
  import { useStore } from 'vuex';
  import { computed } from '@vue/reactivity';
  ```
  ```js
  const store = useStore();
  const userId = computed(() => store.state.user.id);
  const token = computed(() => store.state.user.token);
  //取值记得用.value
  ```

##### 处理maven冲突
- 安装maven Helper插件；
- 在pom.xml文件下，点击`DependencyAnalyzer`，查看冲突位置。
- 将冲突位置禁用。

##### 后端传list到前端，前端接收后渲染
- 后端：
  - 将list转成json字符串形式传到前端；
  - 这里需要加依赖：
    ```xml
    <dependency>
        <groupId>net.sf.json-lib</groupId>
        <artifactId>json-lib</artifactId>
        <version>2.4</version>
        <classifier>jdk15</classifier>
    </dependency>
    ```
  - 转化为字符串
    ```java
    JSONArray jsonArray = JSONArray.fromObject(list);
    String json_list  =  jsonArray.toString();
    ```
- 前端：
  - 前端渲染需要用ref定义动态变量
    ```js
    import { ref } from 'vue';
    const records = ref([]); //需要动态变化
    ```
  - 将后端传过来的json字符串转为对象，存到record中
    ```js
    records.value = JSON.parse(resp.list);
    ```
  - 渲染的时候遍历对象
    ```js
    <tr v-for="(record, index) in records" :key="record.submitTime">
        <th scope="row">{{ index + 1 }}</th>
        <td>{{ record.submitTime }}</td>
        <td>{{ record.type }}</td>
        <td>{{ record.progress }}</td>
        <td>{{ record.remarks }}</td>
    </tr>
    ```
---
#### 实现过程
##### 2023.2.14
- 建立git仓库；
- 初始化前端代码；
- 初始化后端，配置数据库，mybiats，修改spring security，配置jwt验证；
- 实现登录用的3个api；

##### 2023.2.15
- 解决api报错：数据库字段名称不能有下划线或者大写字母；
- 实现前端导航栏；
- 创建前端各页面，划分各个功能模块，搭建前端骨架；

- 办理转按揭
  - 转按揭信息采集
  - 提交转按揭合同
  - 我的办理记录
  - 异常反馈
- 交定金
  - 交定金信息采集
  - 提交认购书
  - 支付定金
  - 我的办理记录
  - 异常反馈
- 签订交易合同
  - 信用评估(转)
  - 信息采集
  - 签订交易合同
  - 我的办理记录
  - 异常反馈
- 办理按揭贷款
  - 信用评估(转)
  - 选择贷款类型(转)
  - 签订合同
  - 我的办理记录
  - 异常反馈
- 违约处理
  - 投诉违约
  - 我的处理记录

##### 2023.2.16
- 实现前端页面底部；
- 实现两个功能模块的前端样式；

##### 2023.2.17
- 实现其他三个功能模块前端样式；
- 实现登录注册功能模块；

- 这两天的效率不高！


##### 2023.2.18
- 查了一天关于将文件传到后端，还没找到方案。。

##### 2023.2.19
- 上午实现了将转按揭数据传到后端，存储到数据库。解决了很多bug才成功：
  - 前端：
    - 响应式获取store中state里的值，需要用`computed`：
      ```js
      import { useStore } from 'vuex';
      import { computed } from '@vue/reactivity';
      ```
      ```js
      const store = useStore();
      const userId = computed(() => store.state.user.id); //取值用.value，需要在函数中
      ```
    - 绑定的ref需要用.value来取值；
  - 后端：
    - Pojo层里每个数据表对应的类，需要加上注解@TableName(value = "")，对应数据表的表名；要不然后端报错找不到数据表。
      ```java
      @Data
      @AllArgsConstructor
      @NoArgsConstructor
      @TableName(value = "refinanceinfo") //对应数据表的表名
      public class RefinanceInfo {
        @TableId(type = IdType.AUTO) //自增变量
        private Integer id;
        private Integer userid;
      }
      ```
  - 经验：
    - 如果报错了，就一点一点的打断点，看到底执行到哪一步出现了问题。
    - 从controller走，看能不能到service，如果不能就是controller层里的问题，然后再逐语句输出来看。

- 实现了办理转按揭功能模块连接数据库操作，熟练了建数据库写api的过程；
- 了解数据库和对应实体类之间默认的'_'命名法和驼峰命名法之间的自动映射。或者用注解`@TableField("remarks")`指定数据库名。
  否则如果数据库字段名和实体类名字一样时，会报错字段不存在。

##### 2023.2.20
- 实现了交定金模块的连接数据库操作；
- 去掉了一些没必要的页面，优化前端结构；
- 明天做最后的收尾。

##### 2023.2.21
- 布置网站分工；
- 实现另外两个模块的连接数据库操作；
- 看来需要一上午，最后两个模块的数据库操作，首页添加组件，改变图片。

##### 2023.2.22
- 实现最后两个模块的数据库操作；
- 添加首页组件；
- 更改各页面图片，完善前端细节。
- 项目结束！