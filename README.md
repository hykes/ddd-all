
### DDD落地实践

#### 工程结构

ddd-application    
ddd-domain        
ddd-facade         
ddd-facade-api     
ddd-infrastructure 
ddd-ui

本工程用于演示如何使用DDD理论开发业务系统。对应DDD理论，本工程主要由四大块组成：

*  Interface: 门面层，对外以各种协议提供服务，该层需要明确定义支持的服务协议、契约等
*  Application: 应用服务层，组合domain层的领域对象和基础设施层的公共组件，根据业务需要包装出多变的服务，以适应多变的业务服务需求。
*  Domain: 业务领域层，是我们最应当关心的一层，也是最多变的一层，需要保证这一层是高内聚的。确保所有的业务逻辑都留在这一层，而不会遗漏到其他层。按照ddd（domain driven design）理论，主要有如下概念构成：entity、value object、domain service、factory、domain event、repository
*  Infrastructure: 基础设施层提供公共功能组件，供controller、service、domain层调用。比如：持久化相关组件、httpclent、validation、checkLogint、exceptionHanler、message resource等。
