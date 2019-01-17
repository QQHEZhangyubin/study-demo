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
//��ʼ��ջ
void Init(SqStack &s)
{
    s.base = (int *)malloc(size*sizeof(int));
    cout<<"��ʼ����ջ�׵�ַ�ǣ�"<<s.base<<endl;
    s.top = s.base;
    s.stacksize = size;

}
//��ջ����
//1,���ж��ڴ��Ƿ������ջռ�õ��ڴ�������һƬ�ġ�
//2����ջ��ָ���ȥջ��ָ��Ĳ����ջ�ĳ���ʱ����Ҫ���¶���ջ��ָ��base��ָ���ڴ��С
void push(SqStack &s,int e)
{
    if(s.top-s.base>=s.stacksize)
    {
        cout<<"s.top - s.base= ";
        cout<<s.top-s.base<<endl;
        s.base = (int *)realloc(s.base,(s.stacksize+incresize)*sizeof(int));
        cout<<"������base��ַ�ǣ�";
        cout<<s.base<<endl;
        s.top = s.base + s.stacksize;
        s.stacksize = s.stacksize + incresize;
    }
    *s.top++=e;

     //s.top++;
    //*s.top = e;

}
//��ջ
void pop(SqStack s,int e)
{
    if(s.top!=s.base)
    {
        e = *(--s.top);
    }
    cout<<e<<endl;
}
//�õ�ջ��Ԫ��
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
