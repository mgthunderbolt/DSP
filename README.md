# DSP Demain-Side Platform 需求方广告平台
## 一 Hbase部分：保存标签
#### tags表 -- 用于标签的保存
* rowkey: md5( tag )
* column family: cf
* value: { name:tag }
* 创建表：create 'tags', 'cf'

#### user_tags表 -- 用于保存用户对应的标签
* rowkey: md5(user_cookie)md5(tag) //md5 散列值处理后数据分布更均匀
* column family: cf
* value: { name:tag,title:2,h1:3,h2:7,h3:4,p:10,total:23.5 } //每个标签的权重不一样，total是各个标签打计算结果
* 创建表： create 'user_tags', 'cf'

## 二 Spark部分：广告投放计算
