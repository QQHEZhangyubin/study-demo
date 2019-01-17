#include <iostream>
#include<stdio.h>
#include<stdlib.h>
#define size 5
#define incresize 2
using namespace std;
typedef struct
{
    int *base;
    int *top;
    int stacksize;
}SqStack;
//初始化栈
void Init(SqStack &s)
{
    s.base = (int *)malloc(size*sizeof(int));
    cout<<"初始化的栈底地址是："<<s.base<<endl;
    s.top = s.base;
    s.stacksize = size;

}
//入栈操作
//1,先判断内存是否溢出，栈占用的内存是连续一片的。
//2，当栈顶指针减去栈底指针的差大于栈的长度时，需要重新定义栈底指针base所指的内存大小
void push(SqStack &s,int e)
{
    if(s.top-s.base>=s.stacksize)
    {
        cout<<"s.top - s.base= ";
        cout<<s.top-s.base<<endl;
        s.base = (int *)realloc(s.base,(s.stacksize+incresize)*sizeof(int));
        cout<<"扩充后的base地址是：";
        cout<<s.base<<endl;
        s.top = s.base + s.stacksize;
        s.stacksize = s.stacksize + incresize;
    }
    *s.top++=e;

     //s.top++;
    //*s.top = e;

}
//出栈
void pop(SqStack s,int e)
{
    if(s.top!=s.base)
    {
        e = *(--s.top);
    }
    cout<<e<<endl;
}
//得到栈顶元素
void GetTop(SqStack s)
{
    while(s.top!=s.base)
    {
        int e;
        e = *(s.top-1);
        cout<<e<<endl;
        s.top--;
    }

}
int main()
{
    SqStack s;
    Init(s);
    push(s,1);
    push(s,2);
    push(s,3);
    push(s,4);
    push(s,5);
    push(s,6);
    push(s,7);
    push(s,8);
    GetTop(s);
    return 0;
}
