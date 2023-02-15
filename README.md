#### github创建仓库：
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
#### 后端初始化：
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

#### 修改Spring Security
- 添加依赖：
  - `spring-boot-starter-security`
  - 此时访问后端页面需要授权，可以通过`user`,`随机密码`来登录访问；
- 实现`service.impl.UserDetailsServiceImpl`类，继承自`UserDetailsService`接口，用来接入数据库信息(其中需要实现`UserDetailsImpl`类)；
  - 此时需要将数据库中的密码声明为明文(`{noop}`)；
  - 可以用数据库里的`用户名`和`密码`来登录授权页面；
- 实现`config.SecurityConfig`类，用来实现用户密码的加密存储；
  - 此时就需要将数据库中的密码进行`BCrypt`加密；
  - 用数据库里的`用户名`和`密码`来登录；

#### 配置jwt验证
- 添加依赖：
  - `jjwt-api`
  - `jjwt-impl`
  - `jjwt-jackson`
- 实现`utils.JwtUtil`类，为jwt工具类，用来创建、解析jwt token
- 实现`config.filter.JwtAuthenticationTokenFilter`类，用来验证jwt token，如果验证成功，则将User信息注入上下文中
- 配置config.SecurityConfig类，放行登录、注册等接口
---

#### 报错
```java
Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.NullPointerException] with root cause

java.lang.NullPointerException: null
```
- 原因：数据库中字段名称不能有`_`或者`大写字母`。

#### 实现过程
##### 2023.2.14
- 建立git仓库；
- 初始化前端代码；
- 初始化后端，配置数据库，mybiats，修改spring security，配置jwt验证；
- 实现登录用的3个api；

##### 2023.2.14
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




