### 背景：

之前接手了一个较为复杂的项目，因为预见了之后迭代的劣化可能，所以做了一下骨架重构设计，接下来介绍一下遇到的问题和具体方案，希望能给大家带来一些帮助。

Android开发中，界面和逻辑经常难舍难分。当遇到功能复杂的页面时，诸多业务叠加骤增了代码量，且不可避免的相互耦合，堆砌在Activity中，仅是常规的使用MVVM进行职能拆分并不足以解决这类问题。另大量的使用dialog与fragment，互相通信时频频使用EventBus导致消息满天飞，同时数据源的修改时机过多，不利于定位源头，最终导致难以复现排查问题。

### 场景：

- #### 单一页面中拥有众多功能，且迭代频繁（新增功能、功能进行实验验证，配置上下线）

- #### 单一功能逻辑通常也较为复杂

- #### 由于数据和功能的联动较多，排查解决问题的难度也较高

### 目标：

- #### 解耦独立各个功能，提供横向扩展能力，以应对频繁迭代

- #### 内部实现消息分发，提高内聚，降低排查问题的难度

- #### 不停止业务迭代的前提下，逐步迁移

### 方案：

将Activity的业务功能职责移交给Container。Container 内部由各个Boards以Tree的结构组合。Board又分为Board和GroupBoard，这个结构可以类比Android的View体系。

由此功能便划分成了一个个Board，各自负责自己的数据、页面、逻辑。再由Container来管理Board的装载、卸载和内部的消息分发。（有需要的话也可以感知生命周期变化）

### 使用方式：

```
dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            mavenCentral()
            maven { url 'https://jitpack.io' }
        }
    }
```

```
    dependencies {
            implementation 'com.github.Disguiser99:board:1.0.5'
    }
```
