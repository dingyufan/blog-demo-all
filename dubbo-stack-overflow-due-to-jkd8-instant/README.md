### 0 问题复现

直接使用拉取的代码，先启动provider，再启动consumer，即可复现



### 1 问题解决

#### 1.1 使用Date
这个就不举例了，直接改字段数据类型为Date


#### 1.2 writeReplace / readResolve 方法
- 将代码恢复刚拉取的状态
- 放开 DemoDTO 类中的readResolve方法的注释


#### 1.3 修改序列化方式
- 将代码恢复刚拉取的状态
- 修改provider的spring-dubbo.xml中 dubbo:protocol 配置


#### 1.4 升级Dubbo版本（√）
- 将代码恢复刚拉取的状态
- 修改consumer、provider的pom文件，dubbo版本修改到2.6.1
- 如果想要改为2.6.6+版本，注意netty3、netty4的版本变化


#### 1.5 SPI扩展Serialization
略
