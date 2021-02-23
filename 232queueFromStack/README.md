# *232.* 用栈实现队列 / *剑指 Offer 09.* 用两个栈实现队列

## 思路
设置一个输入栈和输出栈，一个inStack负责push，一个outStack负责pop。

push和pop操作后两个栈都需要更新，为了避免更新两个栈带来的时间开销，设置里reIn和reOut两个布尔值，用来指示目前的栈是否是需要更新的状态。（连续push或连续pop时不需要更新另一个栈）