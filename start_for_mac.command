# 请先安装 JDK & 配置环境变量
# 如果双击当前 start_for_mac.command 文件无法运行，请修改文件执行权限
# - (右键属性修改或者 chmod u+x start_for_mac.command)

echo 当前 Java 程序正在运行中，请勿关闭此窗口!
parent_dir=$(dirname "$0")
java -jar -Dfile.encoding=utf-8 $parent_dir/CountFileSize.jar 

#echo ---------------------
# 使用 read 命令达到类似 bat 中的 pause 命令效果
#echo 按任意键继续
#read -n 1
#echo 运行结束
