# CountFileSize for Mac
# 针对苹果系统的用户，计算文件的真实大小

## 计算文件的大小，单位可以是 KB，MB，GB 之一
### 1、命令行用法：
```
java -jar CountFileSize.jar <第一个参数是单位，如：MB> <第二个参数是文件路径> <第三个也是文件路径> ...
```

```
如：
java -jar /Users/xxx/Desktop/CountFileSize.jar  mb /Users/xxx/Desktop/arm64-v8a.apk /Users/xxx/Desktop/arm64-v8a-so.apk
```

### 2、command 可执行文件用法：

#### 请先安装 JDK & 配置环境变量
#### 如果双击当前 start_for_mac.command 文件无法运行，请修改文件执行权限
#### - (右键属性修改或者 chmod u+x start_for_mac.command)

#### 2.1、双击 start_for_mac.command 文件即可
