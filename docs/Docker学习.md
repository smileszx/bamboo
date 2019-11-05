

## Docker实战

### 1 Docker入门

#### 1.1 Docker介绍

##### 1.1.1 Docker 产生背景
​		Docker 是云时代的产物， 它的诞生是一种必然。对于云计算\云服务的相关概念，本课程不会去阐述。 不过如果想了解 Docker，那么必须对云服务的一些运营模式有所了解。 

云服务的运营模式：

- IaaS（基础设施即服务）：经营的是基础设施，比如阿里云服务器（只安装操作系统）
- PaaS（平台即服务）：经营的是平台，比如 MySQL 开发平台（安装在 linux里面现成的平台）、 redis 开发平台。
- SaaS（软件即服务）：经营的是软件，比如公司的 OA 系统（部署到远程服务器中的 OA 软件）
  Docker 就是伴随着 PaaS 产生的。 

##### 1.1.2 Docker 是什么
Docker 就是一种虚拟化容器技术。
		通过 Docker 这种虚拟化容器技术， 我们可以对物理机的资源进行更加合理有效的利用， 可以将一台物理机器虚拟化出很多个拥有完整操作系统，并且相互独立的“虚拟计算机”。

​		不过， 对于虚拟化技术的理解， 我们要更加深入一些！ 那么， 什么是虚拟化呢？
​		在计算机中，虚拟化（英语： Virtualization）是一种资源管理技术，是将计算机的各种实体资源，如服务器、网络、内存及存储等，予以抽象、转换后呈现出来，打破实体结构间的不可切割的障碍，使用户可以比原本的组态更好的方式来应用这些资源。这些资源的新虚拟部份是不受现有资源的架设方式，地域或物理组态所限制。一般所指的虚拟化资源包括计算能力和资料存储。在实际的生产环境中，虚拟化技术主要用来解决高性能的物理硬件产能过剩和老的旧的硬件产能过低的重组重用，透明化底层物理硬件，从而最大化的利用物理硬件。 

虚拟化技术种类很多，例如：软件虚拟化、硬件虚拟化、内存虚拟化、网络虚拟化、桌面虚拟化、服务虚拟化、虚拟机等等。 

​		最常用的虚拟化技术有： 全虚拟化和操作系统（OS） 虚拟化。
比如， VMware workstation 就是全虚拟化的实现。
比如， 我们要讲的 Docker， 就是基于操作系统虚拟化技术的一种实现。 

​		基于操作系统创建出一些相互独立的、 功能虚拟化技术有多种实现方式，有基于硬件进行虚拟化的技术，而 Docker 只是针对操作系统进行虚拟化，对于硬件资源的使用率更低。 

相对于 VMware 这种虚拟化技术， Docker 拥有着显著的优势： 

1. 启动速度快， Docker 容器启动操作系统在秒级就可以完成，而 VMware 却是达到分钟级。
2. 系统资源消耗低， 一台 Linux 服务器可以运行成百上千个 Docker 容器， 而VMware 大概只能同时运行 10 个左右。
3. 更轻松的迁移和扩展， 由于 Docker 容器比 VMware 占用更少的硬盘空间，在需要搭建几套软件环境的情况下， 对安装好的 Docker 容器进行迁移会更快捷， 更方便。 而且 Docker 容器几乎可以在任意的平台上运行， 包括虚拟机、 物理机、 公有云， 私有云， 个人电脑等， 这种兼容性， 可以让用户将一个应用程序从一个平台直接迁移到另一个平台。 

##### 1.1.3 Docker能做什么

（1） 上手快
		用户只需要几分钟， 就可以把自己的程序“Docker 化”。 Docker 依赖于“写时复制”（copy-on-write）模型， 使修改应用程序也非常迅速， 可以说达到“随心所致，代码即改”的境界。 随后，就可以创建容器来运行应用程序了。大多数 Docker 容器只需要不到 1 秒中即可启动。由于去除了管理程序的开销， Docker 容器拥有很高的性能， 同时同一台宿主机中也可以运行更多的容器，使用户尽可能的充分利用系统资源。 

（2） 项目职责的逻辑分类
使用 Docker， 开发人员只需要关心容器中运行的应用程序，而运维人员只需要关心如何管理容器。 Docker 设计的目的就是要加强开发人员写代码的开发环境与应用程序要部署的生产环境一致性。 从而降低那种“开发时一切正常， 肯定是运维的问题（测试环境都是正常的，上线后出了问题就归结为肯定是运维的问题）” 

（3）快速高效的开发生命周期
Docker 的目标之一就是缩短代码从开发、 测试到部署、上线运行的周期， 让你的应用程序具备可移植性， 易于构建， 并易于协作。（通俗一点说， Docker 就像一个盒子， 里面可以装很多物件，如果需要这些物件的可以直接将该大盒子拿走，而不需要从该盒子中一件件的取。） 

（4）鼓励使用面向服务的架构（自动化部署）
Docker 还鼓励面向服务的体系结构和微服务架构。 Docker 推荐单个容器只运行一个应用程序或进程，这样就形成了一个分布式的应用程序模型，在这种模型下，应用程序或者服务都可以表示为一系列内部互联的容器， 从而使分布式部署应用程序， 扩展或调试应用程序都变得非常简单， 同时也提高了程序的内省性。（当然，可以在一个容器中运行多个应用程序） 

当然， Docker 的强大远远不至于此，而作为软件开发人员的我们，更关注的是如何利用它来搭建一套统一的软件开发环境。 接下来， 我们将会一步一步的揭开 Docker 的神秘面纱! 

##### 1.1.4 Docker的核心概念

docker 包含四个基本概念：

- 镜像（Image）

  Docker 镜像（Image） 就是一个只读的模板。
  Docker 镜像可以用来创建 Docker 容器。
  Docker 镜像和 Docker 容器的关系， 类似于 java 中 class 类与对象之间的关系。
  Docker 提供了一个很简单的机制来创建镜像或者更新已有的镜像，用户甚至可以直接从其他人那里下载一个已经做好的镜像来直接使用。 

- 容器（Container）

  Docker 利用容器（Container）来运行应用。
  容器是从镜像创建的运行实例。 它可以被启动、 开始、 停止、 删除。 每个容器都是相互隔离的、保证安全的平台。
  可以把容器看成是一个简易版的 Linux 环境（包括 ROOT 用户权限、进程空间、用户空间、网络等）和运行在其中的应用程序。 

- 仓库注册中心（Registry）

  Registry 是集中存放镜像文件的场所。

  Registry 分为公有（public） 和私有（private） 两种形式。

  - 最大的公有 Registry 是 Docker Hub，存放了数量庞大的镜像供用户下载使用。
  - 国内的公开 Registry 包括 USTC、网易云、 DaoCloud、 AliCloud 等，可以供大陆用户更稳当快捷的访问。
  - 用户可以在本地创建一个私有 Registry。  

- 仓库（Repository）

  Repository 是对于其中的镜像进行分类管理。
  一个 Registry 中会有多个 Repository。
  一个 Repository 中会有多个不同 tag 的 Image。
  比如名称为 centos 的 Repository 仓库下， 有 tag 为 6 或者 7 的 Image 镜像。 

  理解了这四个概念， 就理解了 docker 的整个生命周期了！ 

#### 1.2 Docker安装

```shell
#安装之前可以先卸载
yum -y remove docker
#安装：
yum install docker
#启动：
systemctl start docker
#systemctl start docker.service
```

```shell
#查看docker版本
docker --version

Docker version 1.13.1, build b2f74b2/1.13.1

#安装完成后，查看docker信息
docker info

Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?

CentOS上安装Docker-CE,后运行`docker run hello-world`报错`Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?`
```

解决办法：

```shell
systemctl daemon-reload
service docker restart
service docker status (should see active (running))
docker run hello-world
```

```shell
#查看docker状态
service docker status

Redirecting to /bin/systemctl status docker.service
● docker.service - Docker Application Container Engine
   Loaded: loaded (/usr/lib/systemd/system/docker.service; disabled; vendor preset: disabled)
   Active: active (running) since Sat 2019-07-27 04:49:35 EDT; 9s ago
     Docs: http://docs.docker.com
 Main PID: 5301 (dockerd-current)
    Tasks: 17
   CGroup: /system.slice/docker.service
           ├─5301 /usr/bin/dockerd-current --add-runtime docker-runc=/usr/libexec/docker/docker-runc-current --default-runtime=docker-runc --exec-opt na...
           └─5306 /usr/bin/docker-containerd-current -l unix:///var/run/docker/libcontainerd/docker-containerd.sock --metrics-interval=0 --start-timeout...

Jul 27 04:49:34 centos7-I dockerd-current[5301]: time="2019-07-27T04:49:34.190567621-04:00" level=warning msg="Docker could not enable SELinux o... system"
Jul 27 04:49:34 centos7-I dockerd-current[5301]: time="2019-07-27T04:49:34.236146378-04:00" level=info msg="Graph migration to content-addressab...seconds"
Jul 27 04:49:34 centos7-I dockerd-current[5301]: time="2019-07-27T04:49:34.236650924-04:00" level=info msg="Loading containers: start."
Jul 27 04:49:34 centos7-I dockerd-current[5301]: time="2019-07-27T04:49:34.308413653-04:00" level=info msg="Firewalld running: true"
Jul 27 04:49:34 centos7-I dockerd-current[5301]: time="2019-07-27T04:49:34.689554115-04:00" level=info msg="Default bridge (docker0) is assigned...address"
Jul 27 04:49:34 centos7-I dockerd-current[5301]: time="2019-07-27T04:49:34.996012502-04:00" level=info msg="Loading containers: done."
Jul 27 04:49:35 centos7-I dockerd-current[5301]: time="2019-07-27T04:49:35.038642817-04:00" level=info msg="Daemon has completed initialization"
Jul 27 04:49:35 centos7-I dockerd-current[5301]: time="2019-07-27T04:49:35.038665878-04:00" level=info msg="Docker daemon" commit="b2f74b2/1.13....n=1.13.1
Jul 27 04:49:35 centos7-I systemd[1]: Started Docker Application Container Engine.
Jul 27 04:49:35 centos7-I dockerd-current[5301]: time="2019-07-27T04:49:35.052626233-04:00" level=info msg="API listen on /var/run/docker.sock"
Hint: Some lines were ellipsized, use -l to show in full.


#docker启动
[root@centos7-I ~]# sudo docker run hello-world
Unable to find image 'hello-world:latest' locally
Trying to pull repository docker.io/library/hello-world ... 
latest: Pulling from docker.io/library/hello-world
1b930d010525: Pull complete 
Digest: sha256:6540fc08ee6e6b7b63468dc3317e3303aae178cb8a45ed3123180328bcc1d20f
Status: Downloaded newer image for docker.io/hello-world:latest

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
 $ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/
#查看docker信息
[root@centos7-I ~]# docker info                
Containers: 1
 Running: 0
 Paused: 0
 Stopped: 1
Images: 1
Server Version: 1.13.1
Storage Driver: overlay2
 Backing Filesystem: xfs
 Supports d_type: true
 Native Overlay Diff: true
Logging Driver: journald
Cgroup Driver: systemd
Plugins: 
 Volume: local
 Network: bridge host macvlan null overlay
Swarm: inactive
Runtimes: docker-runc runc
Default Runtime: docker-runc
Init Binary: /usr/libexec/docker/docker-init-current
containerd version:  (expected: aa8187dbd3b7ad67d8e5e3a15115d3eef43a7ed1)
runc version: 9c3c5f853ebf0ffac0d087e94daef462133b69c7 (expected: 9df8b306d01f59d3a8029be411de015b7304dd8f)
init version: fec3683b971d9c3ef73f284f176672c44b448662 (expected: 949e6facb77383876aeff8a6944dde66b3089574)
Security Options:
 seccomp
  WARNING: You're not using the default seccomp profile
  Profile: /etc/docker/seccomp.json
Kernel Version: 3.10.0-957.el7.x86_64
Operating System: CentOS Linux 7 (Core)
OSType: linux
Architecture: x86_64
Number of Docker Hooks: 3
CPUs: 1
Total Memory: 991.2 MiB
Name: centos7-I
ID: TQN7:CY6A:GOHJ:XT3N:KL67:S3QA:NU7I:7K4V:MJWY:ZCAW:SCNX:ZUVB
Docker Root Dir: /var/lib/docker
Debug Mode (client): false
Debug Mode (server): false
Registry: https://index.docker.io/v1/
Experimental: false
Insecure Registries:
 127.0.0.0/8
Live Restore Enabled: false
Registries: docker.io (secure)
```

##### 1.2.1 列出Docker镜像

```shell
[root@centos7-I ~]# docker images
REPOSITORY              TAG                IMAGE ID           CREATED            SIZE
docker.io/hello-world   latest             fce289e99eb9       6 months ago       1.84 kB
```

参数含义：

- Repository：镜像所在仓库名称
- Tag：镜像版本
- Image ID：镜像 ID
- Created：镜像创建时间
- Size：镜像大小 

##### 1.2.2 搜索镜像

```shell
#如果你需要从网络中查找需要的镜像，可以通过以下命令搜索
docker search 镜像名称
#举例搜索Tomcat
[root@centos7-I ~]# docker search tomcat
```

![1564385888157](E:\Architect\TechSnail\Docker\Docker学习.assets\1564385888157.png)

参数含义：

- NAME：仓库名称
- DESCRIPTION：镜像描述
- STARS：用户评价， 反应一个镜像的受欢迎程度
- OFFICIAL： 是否官方
- AUTOMATED： 自动构建，表示该镜像由 Docker Hub 自动构建流程创建的 

##### 1.2.3 拉取镜像

我们可以使用命令从一些公用仓库中拉取镜像到本地， 下面就列举一些常用的公用仓库拉取镜像的方式！

- **Docker Hub**

  Docker Hub 的网址： https://hub.docker.com/ 

  需求： 从 Docker Hub 仓库下载一个 CentOS 7 版本的操作系统镜像。 

  ```shell
  #命令如下：
  #Docker Hub 是 docker 默认的公用 Registry， 不过缺点是国内下载会比较慢。
  docker pull centos:7
  ## 拉取镜像测试
  [root@centos7-I ~]# docker pull centos:7
  Trying to pull repository docker.io/library/centos ... 
  7: Pulling from docker.io/library/centos
  8ba884070f61: Pull complete 
  Digest: sha256:a799dd8a2ded4a83484bbae769d97655392b3f86533ceb7dd96bbac929809f3c
  Status: Downloaded newer image for docker.io/centos:7
  ```

- **USTC**

  在宿主机器编辑文件（centos7 不支持 vim 命令， 但是支持 vi 命令）：

  ```shell
  $ vi /etc/docker/daemon.json 
  ```

  请在该配置文件中加入（没有该文件的话，请先建一个）： 

  ```json
  {
  	"registry-mirrors": ["https://docker.mirrors.ustc.edu.cn"]
  }
  ```

  最后， 需要重启 docker 服务
  systemctl restart docker
  之后再使用 pull 命令拉取镜像， 这时候是从 ustc 获取镜像， 而且速度杠杠的。
  docker pull centos:7 

 ##### 1.2.4 删除镜像

```shell
#删除指定镜像
docker rmi repository:tag
docker rmi imageID
#删除所有镜像
docker rmi $(docker images -q)
#注意：
#删除时，如果镜像的 image id 一致， 则需要按照一定顺序进行删除， 因为镜像之间有关联（reference）
```

##### 1.2.5 镜像迁移

```shell
#导出镜像：
docker save repository:tag/imageId > /root/xx.tar.gz
docker save -o mynginx.tar mynginx
#-o 输出到的文件
#执行后，运行 ls 命令即可看到打成的 tar 包

#导入镜像：
docker load < /root/xx.tar.gz
docker load -i mynginx.tar
#-i 输入的文件
#执行后再次查看镜像，可以看到镜像已经恢复
```

#### 1.3 Docker容器

##### 1.3.1 创建并运行容器 

创建容器命令： **docker run**
创建容器常用的参数说明：

- -i：表示运行容器
- -t：表示容器启动后会进入其命令行。加入这两个参数后，容器创建就能登录进去。即分配一个伪终端。
- --name :为创建的容器命名。
- -v：表示目录映射关系（前者是宿主机目录，后者是映射到宿主机上的目录），可以使用多个 -v 做多个目录或文件映射。注意：最好做目录映射，在宿主机上做修改，然后共享到容器上。
- -d：在 run 后面加上-d 参数,则会创建一个守护式容器在后台运行（这样创建容器后不会自动登录容器，如果只加-i -t 两个参数，创建后就会自动进去容器）。
- -p：表示端口映射，前者是宿主机端口，后者是容器内的映射端口。可以使用多个 -p 做多个端口映射 



创建容器两种方式：

- 以交互方式运行容器：

  ```shell
  docker run -i -t --name 容器名称 repository:tag /bin/bash
  docker run -it --name 容器名称 imageID /bin/bash
  
  #举例
  [root@centos7-I ~]# docker run -it --name centos_su centos:7 /bin/bash
  [root@centos7-I ~]# docker run -it --name centos_su 9f38484d220f /bin/bash
  ```

  

- 以守护进程方式运行容器：

  ```shell
  docker run -di --name 容器名称 repository:tag
  docker run -di --name 容器名称 imageID
  
  #举例
  [root@centos7-I ~]# docker run -di --name centos_su centos:7
  [root@centos7-I ~]# docker run -di --name centos_su 9f38484d220f
  ```

  注意： 通过 run 创建并进入容器之后， 如果使用 exit 命令退出容器，则容器停止。再次进入该容器， 先使用 start 启动容器， 再使用 exec/attach 命令进入容器。 

##### 1.3.2 启动容器

```
docker start 容器名称 或者 容器ID 
```

##### 1.3.3 进入容器

```shell
#进入正在运行的容器的命令如下：
docker exec -it 容器名称 或者 容器ID /bin/bash
docker attach 容器名称 或者 容器ID
```

两者之间的区别：
attach 进入容器之后， 如果使用 exit 退出容器， 则容器停止。
exec 进入容器之后， 使用 exit 退出容器， 容器依然处于运行状态。 

##### 1.3.4 查看容器

```shell
docker ps ： 查看正在运行的容器
docker ps -a： 查看历史运行过的容器
docker ps -l： 查看最近运行过的容器
```

##### 1.3.5 停止容器

```shell
docker stop 容器名称 或者 容器ID
```

##### 1.3.6 删除容器

```shell
#删除指定容器：
docker rm 容器名称 或者 容器ID
#删除所有容器：
docker rm ‘docker ps -a -q’
```

##### 1.3.7 复制文件

```shell
docker cp 源文件 目标文件
比如：
docker cp /root/boot.war my-centos:/usr/local/
```

说明：
/root/boot.war 是宿主机器的路径
my-centos 是容器的名称
/usr/local/是容器内的路径
注意： 源文件可以是宿主机器也可以是容器中的文件， 同样， 目标文件可以是容器也可以是宿主机器的文件。

#### 1.4 Docker应用

##### 1.4.1 MySQL部署

###### 1.4.1.1 拉取MySQL镜像

```shell
[root@centos7-I ~]# docker pull mysql:5.7
#查看镜像
[root@centos7-I ~]# docker images
REPOSITORY              TAG             IMAGE ID            CREATED             SIZE
docker.io/mysql         5.7             f6509bac4980        5 days ago          373 MB
```

###### 1.4.1.2 创建MySQL容器

```shell
[root@centos7-I ~] docker run -di --name smile_mysql -p 33306:3306 -e MYSQL_ROOT_PASSWORD=root mysql:5.7

# -p 代表端口映射，格式为 宿主机映射端口:容器运行端口
# -e 代表添加环境变量 MYSQL_ROOT_PASSWORD 是 root 用户的登陆密码
```

###### 1.4.1.3 进入MySQL容器，登录MySQL

```shell
#进入 mysql 容器
docker exec -it kkb_mysql /bin/bash
#Docker容器登陆 mysql
mysql -u root -p

#CentOS宿主机登录MySQL，如果宿主机也安装了MySQL，登录命令需要指定宿主机IP地址和容器映射端口号33306
[root@centos7-I ~]# mysql -uroot -p -h192.168.1.101 -P33306
```

###### 1.4.1.4 远程登录MySQL

在我们本机的电脑上去连接虚拟机 CentOS中的 Docker 容器，192.168.1.101 是虚拟机操作系统的 IP ，端口号是宿主机映射端口号33306

![1564405130801](E:\Architect\TechSnail\Docker\Docker学习.assets\1564405130801.png)



###### 1.4.1.5 查看容器IP地址

```shell
[root@centos7-I ~]# docker inspect smile_mysql
[
    {
        "Id": "111dd66a9a9ff1385855706f26992e667de2fd20982f5920975ce33b84450c20",
        "Created": "2019-07-28T11:41:07.266844132Z",
        "Path": "docker-entrypoint.sh",
        "Args": [
            "mysqld"
        ],
        "State": {
            "Status": "running",
            "Running": true,
            "Paused": false,
            "Restarting": false,
            "OOMKilled": false,
            "Dead": false,
            "Pid": 21796,
            "ExitCode": 0,
            "Error": "",
            "StartedAt": "2019-07-28T14:29:20.462298611Z",
            "FinishedAt": "2019-07-28T11:52:56.039285539Z"
        },
        "Image": "sha256:f6509bac49801f48628167728aba66d64533aaa7d384e03b75a8fe4e6c0f6599",
        "ResolvConfPath": "/var/lib/docker/containers/111dd66a9a9ff1385855706f26992e667de2fd20982f5920975ce33b84450c20/resolv.conf",
        "HostnamePath": "/var/lib/docker/containers/111dd66a9a9ff1385855706f26992e667de2fd20982f5920975ce33b84450c20/hostname",
        "HostsPath": "/var/lib/docker/containers/111dd66a9a9ff1385855706f26992e667de2fd20982f5920975ce33b84450c20/hosts",
        "LogPath": "",
        "Name": "/smile_mysql",
        "RestartCount": 0,
        "Driver": "overlay2",
        "MountLabel": "",
        "ProcessLabel": "",
        "AppArmorProfile": "",
        "ExecIDs": [
            "48ad01f4c51a8e2c2e3149c046ac0e2b44151b889dbfad0a74e4d9fe47dd876a"
        ],
        "HostConfig": {
            "Binds": null,
            "ContainerIDFile": "",
            "LogConfig": {
                "Type": "journald",
                "Config": {}
            },
            "NetworkMode": "default",
            "PortBindings": {
                "3306/tcp": [
                    {
                        "HostIp": "",
                        "HostPort": "33306"
                    }
                ]
            },
            "RestartPolicy": {
                "Name": "no",
                "MaximumRetryCount": 0
            },
            "AutoRemove": false,
            "VolumeDriver": "",
            "VolumesFrom": null,
            "CapAdd": null,
            "CapDrop": null,
            "Dns": [],
            "DnsOptions": [],
            "DnsSearch": [],
            "ExtraHosts": null,
            "GroupAdd": null,
            "IpcMode": "",
            "Cgroup": "",
            "Links": null,
            "OomScoreAdj": 0,
            "PidMode": "",
            "Privileged": false,
            "PublishAllPorts": false,
            "ReadonlyRootfs": false,
            "SecurityOpt": null,
            "UTSMode": "",
            "UsernsMode": "",
            "ShmSize": 67108864,
            "Runtime": "docker-runc",
            "ConsoleSize": [
                0,
                0
            ],
            "Isolation": "",
            "CpuShares": 0,
            "Memory": 0,
            "NanoCpus": 0,
            "CgroupParent": "",
            "BlkioWeight": 0,
            "BlkioWeightDevice": null,
            "BlkioDeviceReadBps": null,
            "BlkioDeviceWriteBps": null,
            "BlkioDeviceReadIOps": null,
            "BlkioDeviceWriteIOps": null,
            "CpuPeriod": 0,
            "CpuQuota": 0,
            "CpuRealtimePeriod": 0,
            "CpuRealtimeRuntime": 0,
            "CpusetCpus": "",
            "CpusetMems": "",
            "Devices": [],
            "DiskQuota": 0,
            "KernelMemory": 0,
            "MemoryReservation": 0,
            "MemorySwap": 0,
            "MemorySwappiness": -1,
            "OomKillDisable": false,
            "PidsLimit": 0,
            "Ulimits": null,
            "CpuCount": 0,
            "CpuPercent": 0,
            "IOMaximumIOps": 0,
            "IOMaximumBandwidth": 0
        },
        "GraphDriver": {
            "Name": "overlay2",
            "Data": {
                "LowerDir": "/var/lib/docker/overlay2/ff38179dab9c4eec616bc3b50364b9961aef7c84491c17df3d93ebfb0bdbdd7d-init/diff:/var/lib/docker/overlay2/f6d4bad842fe26b4d96feb6bada5ee3c7b0077ae10ca343d6446aeee928a31f6/diff:/var/lib/docker/overlay2/4142e1657f0a15b07789d55d9c0fc6e6c9364e6fd99760716f0b1db7a4a27c50/diff:/var/lib/docker/overlay2/f6d6c8033da3b4b979ce8ffacea890fe3678473032f0fc64db99607f3269aeb7/diff:/var/lib/docker/overlay2/3d40e0c4e09d3191b368ef7882ba5ece72fc35b1c6f3f9b2202578905e658bc1/diff:/var/lib/docker/overlay2/7e0658e5d9730c756ac718923ab30233ed59be1ed22a9ccca4b44600b2420c5a/diff:/var/lib/docker/overlay2/9beda0f861cda935a261474c4fc5fde1911ce25c997e5ec21eda36199a1e080f/diff:/var/lib/docker/overlay2/113db8544c1c697303dca14107bf1b3c54b04d9fbf9a8637ccd3cad507d28ea4/diff:/var/lib/docker/overlay2/d7738ac50f2f0ea67ef5c3ed8e93d9ebceb3fd213d7d46a9423e33eef7cb05b3/diff:/var/lib/docker/overlay2/96e9bb3970127d299960dac33dae69fe2fc26933612f2987fe43ccc18a4103b5/diff:/var/lib/docker/overlay2/b3e39036669562f62d301263ea6849aeec331d38584cfbca149d8c140ddae92b/diff:/var/lib/docker/overlay2/4ddb01ab36bcfdeb03988137d076f8f50ad79f024dfe4056c37c03cc89b51b99/diff",
                "MergedDir": "/var/lib/docker/overlay2/ff38179dab9c4eec616bc3b50364b9961aef7c84491c17df3d93ebfb0bdbdd7d/merged",
                "UpperDir": "/var/lib/docker/overlay2/ff38179dab9c4eec616bc3b50364b9961aef7c84491c17df3d93ebfb0bdbdd7d/diff",
                "WorkDir": "/var/lib/docker/overlay2/ff38179dab9c4eec616bc3b50364b9961aef7c84491c17df3d93ebfb0bdbdd7d/work"
            }
        },
        "Mounts": [
            {
                "Type": "volume",
                "Name": "3b0eca009cd5783b1dfdb2b5a7b26f4a94fe2d0089fb8e21c3a77c9f449a401c",
                "Source": "/var/lib/docker/volumes/3b0eca009cd5783b1dfdb2b5a7b26f4a94fe2d0089fb8e21c3a77c9f449a401c/_data",
                "Destination": "/var/lib/mysql",
                "Driver": "local",
                "Mode": "",
                "RW": true,
                "Propagation": ""
            }
        ],
        "Config": {
            "Hostname": "111dd66a9a9f",
            "Domainname": "",
            "User": "",
            "AttachStdin": false,
            "AttachStdout": false,
            "AttachStderr": false,
            "ExposedPorts": {
                "3306/tcp": {},
                "33060/tcp": {}
            },
            "Tty": false,
            "OpenStdin": true,
            "StdinOnce": false,
            "Env": [
                "MYSQL_ROOT_PASSWORD=root",
                "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin",
                "GOSU_VERSION=1.7",
                "MYSQL_MAJOR=5.7",
                "MYSQL_VERSION=5.7.27-1debian9"
            ],
            "Cmd": [
                "mysqld"
            ],
            "ArgsEscaped": true,
            "Image": "mysql:5.7",
            "Volumes": {
                "/var/lib/mysql": {}
            },
            "WorkingDir": "",
            "Entrypoint": [
                "docker-entrypoint.sh"
            ],
            "OnBuild": null,
            "Labels": {}
        },
        "NetworkSettings": {
            "Bridge": "",
            "SandboxID": "271e007e6ff4743a3d3bbb50b0e1bfdbdbf7d39c7ef45ba245eff729775b7b06",
            "HairpinMode": false,
            "LinkLocalIPv6Address": "",
            "LinkLocalIPv6PrefixLen": 0,
            "Ports": {
                "3306/tcp": [
                    {
                        "HostIp": "0.0.0.0",
                        "HostPort": "33306"
                    }
                ],
                "33060/tcp": null
            },
            "SandboxKey": "/var/run/docker/netns/271e007e6ff4",
            "SecondaryIPAddresses": null,
            "SecondaryIPv6Addresses": null,
            "EndpointID": "c14bc355022425a5ce34dd4bf3e132f4b7c07219bb5f8a654c3a49f496395d4f",
            "Gateway": "172.17.0.1", # 网关
            "GlobalIPv6Address": "",
            "GlobalIPv6PrefixLen": 0,
            "IPAddress": "172.17.0.3", # 容器IP地址，宿主机与该IP交互，客户端不会直接与其交互
            "IPPrefixLen": 16,
            "IPv6Gateway": "",
            "MacAddress": "02:42:ac:11:00:03",
            "Networks": {
                "bridge": {
                    "IPAMConfig": null,
                    "Links": null,
                    "Aliases": null,
                    "NetworkID": "e7ab7534b736845fe11ddf963a6eb816bc91d045b12a085145c58fd1b888b18c",
                    "EndpointID": "c14bc355022425a5ce34dd4bf3e132f4b7c07219bb5f8a654c3a49f496395d4f",
                    "Gateway": "172.17.0.1",
                    "IPAddress": "172.17.0.3",
                    "IPPrefixLen": 16,
                    "IPv6Gateway": "",
                    "GlobalIPv6Address": "",
                    "GlobalIPv6PrefixLen": 0,
                    "MacAddress": "02:42:ac:11:00:03"
                }
            }
        }
    }
]
```

##### 1.4.2 Tomcat部署

###### 1.4.2.1 拉取Tomcat镜像

```shell
[root@centos7-I ~]# docker pull tomcat:8-jdk8
Trying to pull repository docker.io/library/tomcat ... 
8-jdk8: Pulling from docker.io/library/tomcat
......
Digest: sha256:2785fac92d1bcd69d98f2461c6799390555a41fd50d3f847b544368d594c637b
Status: Downloaded newer image for docker.io/tomcat:8-jdk8

#查看镜像
[root@centos7-I ~]# docker images                
REPOSITORY              TAG             IMAGE ID            CREATED             SIZE
docker.io/tomcat        8-jdk8          238e6d7313e3        10 days ago         506 MB
```

###### 1.4.2.2 创建Tomcat容器

```shell
# 创建容器 -p 表示地址映射
[root@centos7-I ~]# docker run -di --name=smile_tomcat -p 9000:8080 tomcat:8-jdk8
```

#查看容器是否启动
![1564407097583](E:\Architect\TechSnail\Docker\Docker学习.assets\1564407097583.png)



```shell

docker run -di --name bamboo_tomcat -v /bamboo/webapps:/usr/local/tomcat/webapps -p 8761:8761 --privileged=true tomcat:8-jdk8
```

查看tomcat日志

tail -f catalina.out

**异常信息**

```
[root@centos7-I webapps]# docker run -di --name bamboo_tomcat -v /bamboo/webapps:/usr/local/tomcat/webapps -p 9999:8080 --privileged=true tomcat:8-jdk8
1adfa9c637e03c106f4d314163e4ea338381a5d9b1691d438ffb173a4cffad12
/usr/bin/docker-current: Error response from daemon: driver failed programming external connectivity on endpoint bamboo_tomcat (951c5a73d34323a5b41ce1fa17dd8a730e3d7dd2cf0a6a56bdbcc364e6b02c7f):  (iptables failed: iptables --wait -t nat -A DOCKER -p tcp -d 0/0 --dport 9999 -j DNAT --to-destination 172.17.0.4:8080 ! -i docker0: iptables: No chain/target/match by that name.
 (exit status 1)).
```

docker服务启动时定义的自定义链DOCKER由于某种原因被清掉
重启docker服务及可重新生成自定义链DOCKER

解决方法：

```
启动        　　 　systemctl start docker
守护进程重启   　　 sudo systemctl daemon-reload
重启docker服务   　systemctl restart  docker
重启docker服务 　　 sudo service docker restart
关闭docker   　　  service docker stop   
关闭docker 　　    systemctl stop docker
```

