## the summary of interview's algorithm 

## 美团

	* 猫扑素数 , 以2开头, 并且后面的数是3. 并且是质数;  

		* 先判断是否是猫扑, 余数为3, 递归;
		* 在判断是否质数, i * i <= x; x % i == 0
		
	* 1 ~ n , 求1出现的次数 ;

		* 遍历, 
		* 循环, i % 10 == 1; i = i / 10;
		
	* 翻转单词, 翻转数字; 

		* 翻转单词

			* 循环, 首尾交换, i++
		* 翻转数字

			* reverse * 10 + x % 10
			* x /= 10;
