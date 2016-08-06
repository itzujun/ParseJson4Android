JSON框架性能比较

&emsp;&emsp;前段时间@寒江不钓同学针对国内Top500和Google Play Top200 Android应用做了全面的分析（具体分析报告见文末的参考资料），其中有涉及到对应用使用json框架的统计，具体情况如下：

![三种json框架使用情况](http://ww1.sinaimg.cn/large/6d17e381gw1f6k4nbsyidj2078021t8q.jpg)

&emsp;&emsp;可见无论是在国内还是国际上，有很多应用会用到json框架，其中谷歌提供的[gson](https://github.com/google/gson)框架是被使用得最多的，老牌json框架Jackson属于小众，阿里出品的FastJson在国内的使用情况仅次于Gson，但在国际上却基本没有APP在使用。

&emsp;&emsp;被使用得最多并不代表就一定是最优方案，在使用json框架的过程中，我们最关注的应该是效率和易用性的问题，三种框架的实现各不相同，肯定会存在效率和易用性上的差异，针对这两方面的分析网络上的文章也没有比较权威的观点，本文结合工作中的实际情况，使用三种框架分别对bean转String、String转bean、List转String、String转List、Map转String、String转Map这几种情况进行实际测试，得出在耗时、CPU占用、内存变化、易用性上的测试结果。

&emsp;&emsp;为了让测试结果显得更为可信，有必要说明一下测试方案：

- 使用相同的测试环境：入参相同（数据来源、测试次数）、运行的环境相同；

- 每个框架都使用最新的版本，如果有Android定制版优先使用Android定制版（Gson:2.7、FastJson:1.1.52.android、jackson:jackson-all-1.9.9）；

- 为了避免单次测试可能存在的不确定性因素，每个框架的每次测试都是重复测试100次，然后算平均值；

- 为了观察不同量级的数据量对效率的影响，数据量可以人为设置，测试时分别从10的0次方到10的4次方，每次测试以10为倍数的增长方式（即1、10、100、1000、10000，根据实际情况，测试10万次就显得不是很必要了，如果数据量太大，可以考虑分多次获取和转换）观察不同框架在不同量级数据的表现情况。

&emsp;&emsp;详细的测试代码如下：

- []()
       
在Android开发中应该选择哪一款json解析框架？

## 参考资料

- [FastJson 使用详解](http://blog.csdn.net/shulianghan/article/details/41011605)

- [FastJson Android版本](https://github.com/alibaba/fastjson/wiki/Android%E7%89%88%E6%9C%AC)

- [gson](https://github.com/google/gson)

- [gson使用详解](http://blog.csdn.net/u012702547/article/details/46043549)

- [Google Play Top200 应用分析报告](https://gold.xitu.io/entry/5785923579bc440050b4ef91)

- [国内Top500Android应用分析报告](http://www.wtoutiao.com/p/20264KF.html)


- FastJson必须要有默认的构造函数，不然解析的时候会挂掉。。。

- Json解析是一件很耗CPU的事情；

- 三个框架在工作过程中都存在内存抖动的情况；

- 


