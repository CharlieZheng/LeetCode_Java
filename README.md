#### 53

-----------------------------------

当我第一次看到```c(i) = max{c(i-1) + a[i], a[i]}```时，一脸懵逼

示例：```[4, 4, -4, -4, 2, 100]```

```c(5) = max{c(4) + a[5], a[5]} = max{8+100, 100} = 108```

但是真正的c(5) = 102。

我当时是把c(i)理解错了。以为是子序列[0..i]的子序列的最大和。

子序列[0..4]的最大和子序列是[4, 4]，则和是8

子序列[0..5]的最大和子序列是[2, 100]，则和是102

-----------------------------------
上面的是错误的理解。


下面是正确的理解。

终于明白了！这道题的关键就是算出以 i 结尾的子序列最大和的最大值。

 - A B C D E F G(每个字母代表一个数字)
 - max(A) -> A自己
 - max(B) -> 以A结尾的最大和子序列+B自己或者是B自己 -> ```max(max(A) + B, B)``` -> ```if (A > B) return A else return B```
 - max(C) -> max(max(B) + C, C)
 - …
 - max(G) -> max(max(F) + G, G)

然后 max(A) … max(G) 哪个最大就是哪个了。

-----------------------------------

算出来以0结尾的最大和子序列

...

算出来以length-1结尾的最大和子序列

就覆盖了所有的可能，遍历从0到length-1的最大值就可以了。

-----------------------------------
