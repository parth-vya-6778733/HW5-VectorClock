# HW5-VectorClock

Intro - The vector clock algorithm is one which synchonizes processes regardless of concurrency. This algo follows a partial 
ordering, since it has a happens before relationship. Each process will synchronize their timestamps when a SEND/RECEIVE event
occurs. 

Our Implementation - We have implemented an algorithm class, which executes 3 different execution plans concurrently through multiple threads. To 
simulate the happens before event processing, we have added thread sleepers which would allow the thread to wait until the 
process has received it's updated vector clock prior to executing its next event depending on the given diagram.

In our Vector clock, we compare two different vector clocks by iterating through all values of both vector clocks, and if the
sending processor's vector clock value is greater than the receivers, it will update its vector clock accordingly.

