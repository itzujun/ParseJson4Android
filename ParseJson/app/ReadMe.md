## [Json框架选型]Android开发中应该使用哪一种主流json框架？

## 前言

&emsp;&emsp;前段时间@寒江不钓同学针对国内Top500和Google Play Top200 Android应用做了全面的分析（具体分析报告见文末的参考资料），其中有涉及到对主流应用使用json框架Gson、FastJson、Jackson的统计，具体情况如下：

![三种json框架使用情况](http://ww1.sinaimg.cn/large/6d17e381gw1f6k4nbsyidj2078021t8q.jpg)

&emsp;&emsp;可见无论是在国内还是国际上，有很多应用会用到json框架，其中谷歌提供的[gson](https://github.com/google/gson)框架是被使用得最多的，老牌json框架Jackson属于小众，阿里出品的FastJson在国内的使用情况仅次于Gson，但在国际上却基本没有APP在使用。

## 测试方案

&emsp;&emsp;被使用得最多并不代表就一定是最优方案，在使用json框架的过程中，我们最关注的应该是效率和易用性的问题，三种框架的具体实现各不相同，肯定会存在效率和易用性上的差异，针对这两方面的分析网络上的文章并没有比较权威、能够说服大家的观点(FastJson引用的测试结果可以参考，但不足以说服所有人)，本文结合工作中的实际情况，使用三种框架分别对bean转String、String转bean、List转String、String转List、Map转String、String转Map这几种情况进行实际测试，得出在耗时、CPU占用、内存变化、易用性上的测试结果。

&emsp;&emsp;为了让测试结果显得更为可信，有必要说明一下测试方案：

- 使用相同的测试环境：入参相同（数据来源、测试次数）、运行的环境相同；

- 每个框架都使用最新的版本，如果有Android定制版优先使用Android定制版（Gson:2.7、FastJson:1.1.52.android、jackson:jackson-all-1.9.9）；

- 为了避免单次测试可能存在的不确定性因素，每个框架的每次测试都是重复测试100次，然后算平均值；

- 为了观察不同量级的数据量对效率的影响，数据量可以人为设置，测试时分别从10的0次方到10的4次方，每次测试以10为倍数的增长方式（即1、10、100、1000、10000，根据实际情况，测试10万次就显得不是很必要了，如果数据量太大，可以考虑分多次获取和转换）观察不同框架在不同量级数据的表现情况；

- 考虑到生成数据也会导致耗时的问题，对每个框架的每次测试，100次的测试中只生成一次数据；

- 考虑到测试的可操作性，对每个框架的每次测试中，bean转String、String转bean、List转String、String转List、Map转String、String转Map都是一并进行的，所以对内存变化和CPU变化的测试结果是这六项测试的综合结果。

&emsp;&emsp;考虑到可读性和代码量的问题，直接提供链接会比贴代码好一点：

- [ParseJson4Android](https://github.com/zmywly8866/ParseJson4Android)

## 测试结果

&emsp;&emsp;详细的测试结果如下：

![Gson、FastJson、Jackson三种框架性能测试结果](http://ww2.sinaimg.cn/large/6d17e381jw1f6k626ano1j20vh05jmzn.jpg)

&emsp;&emsp;结合本人实际操作和测试结果，可以得出如下结论：

![Gson、FastJson、Jackson综合对比](http://ww4.sinaimg.cn/large/6d17e381jw1f6m3bosgiwj21en07vdkh.jpg)

- 三种框架在实现上都使用了反射机制；

- 三种框架目前仍然在维护，所以从这一点来讲，使用任何一个框架是是靠谱的，因为有人在维护，反馈问题可以改，遇到问题也可以问；

- 三种框架FastJson的包最小（为了方便对比大小，均是对jar包做的统计），只有196K，其次是Gson的227K，Jackson会大很多，超过了1M；

- 三种框架在1000倍数据量级以内效率都很高、占用内存也低，效率最高的是FastJson，内存占用都差不多；1000倍数据量级以上内存占用会很大，并且平均耗时会超过1S，FastJson表现中规中矩；

- json解析、转换是一件很耗CPU的工作；

- 三种框架在bean转换为json时都有很好的易用性，但在json解析的实现上，FastJson使用起来最简单，其次是Gson;

- FastJson对bean有要求，必须要有默认的构造函数。
       
&emsp;&emsp;综合上述各方面的测试结果，并结合实际工作情况来看（如果数据量很大，可以考虑分页，多次获取），在项目中应该优先使用FastJson框架，它在一定数据量范围内，内存占用、效率等方面会表现得更为优秀；其次是Gson（结合实际工作经验，频繁的使用json解析和转换更应该使用FastJson）。

**特别说明：**

&emsp;&emsp;由于测试方案、测试环境以及具体用法并不一定权威，所以测试结果仅供参考，在实际开发过程中可以借鉴本文的测试结论，但建议在任何开源项目的选型前，还是要亲自动手，对性能、效率、易用性、功耗、大小、是否有人在维护、稳定性等各方面进行测试，根据综合分析后的结果选择最适合自己项目的框架。

## 参考资料

- [测试Demo](https://github.com/zmywly8866/ParseJson4Android)

- [gson](https://github.com/google/gson)

- [FastJson Android版本](https://github.com/alibaba/fastjson/wiki/Android%E7%89%88%E6%9C%AC)

- [Jackson](https://github.com/FasterXML)

- [FastJson 使用详解](http://blog.csdn.net/shulianghan/article/details/41011605)

- [gson使用详解](http://blog.csdn.net/u012702547/article/details/46043549)

- [Google Play Top200 应用分析报告](https://gold.xitu.io/entry/5785923579bc440050b4ef91)

- [国内Top500Android应用分析报告](http://www.wtoutiao.com/p/20264KF.html)

