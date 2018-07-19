# Redis Key 命名规则

## 加锁

所有访问，在查权限的同时查一下有没有大锁

在访问所有修改页面的时候，都要再查一下相关锁

1. lock 

2. 操作

3. 操作内容

4. 操作对象的 ID，对应数据库主键（或者 All）

5. 操作者 userID

   :Default

示例：

Lock:Update:All			刷新全部缓存（大故障重启）

Lock:Update:Project:90:223	userID 为223的人正在更改 projectID 为90的内容



## 单一内容

Value  是序列化出来的 Json

1. 对象
2. 对象 ID，对应数据库主键
3. 对象所属人的 userID
4. 对象所属的其他信息



示例

Contract:30:90:40		第30号合同，负责人是 userID 90，属于40号工程



//尽量避免使用 Keys 进行模糊匹配



## 有序集合

### 从属关系

Value：当前对象的 ID 的集合

1. 父级对象
2. 父级 ID
3. 当前对象
4.  排序方式 ， default 为按照主键



示例

Project:20:Contract:2:Document:Default 	20号工程下的2号合同的所有文档

Project:20:Contract:Default				20号工程下的所有合同

User:3:Project:Default						3号用户所能看到的 Project

Project:all:time							所有项目的列表，按时间排序，也就是 score 是时间戳



## Token 信息

Value 是 token 的具体数值

用于限制一个用户只能同时获得一个 token

1. Token
2. userID



示例

Token:23					23号用户的 Token



## 权限

Value 是 true

Key 存在就意味着有权限

1. URL 接口
2. Level



示例

getProjectList:3				level3 用户可以访问 getProjectList 接口

## 总数

1. Sum
2. Project



示例

getProjectList:3				level3 用户可以访问 getProjectList 接口



