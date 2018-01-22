<!--
author: wimidev
head: 
date: 
title: CCProgressTimer的一个坑
tags: GitBlog
images: 
category: GitBlog
status: publish
summary: CCProgressTimer的一个坑
-->

##CCProgressTimer的一个坑
 * 问题：代码如下
 * 
   code：``` local sp = CCSprite:create("ashdfkjhajskhdfiuahsfbhbcxjkhagsdjhfg.png") --很长很长的名字```

    ```local pro = CCProgressTimer* create(sp)```
    
    ```pro:setPercentage(0)```
 * 出现了一种非常奇怪的情况，进度条会在中间剩下一段


 * 解决：尝试把名字缩短会在进度条左边留下一段，解决方式是缩短png的名字长度
 * ```local sp = CCSprite:create("a.png") ```就完美了
