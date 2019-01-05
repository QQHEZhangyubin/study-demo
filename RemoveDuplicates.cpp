#include <iostream>
#include<stdlib.h>
using namespace std;
typedef int ElemType;
typedef struct Node
{
    ElemType data;
    Node *next;
}LinkList;

//尾插法建立单链表

void CreateTail(LinkList *&L,int a[],int n)
{
    LinkList *r,*e;
    L =(LinkList *) malloc(sizeof(LinkList));
     r = L;
     for(int i=0;i<n;i++)
     {
         e = (LinkList *) malloc(sizeof(LinkList));
         e->data = a[i];
         r->next = e;
         r = e;
     }
     r->next = NULL;
}
//在有序表里删除重复元素
LinkList* Display(LinkList *L)
{
    if(L==NULL || L->next ==NULL)
    {
        cout<<"null"<<endl;
        return L;
    }
    LinkList *p = L;
    LinkList *q = L->next;
    while(q)
    {
        if(p->data == q->data)
        {

            q = q->next;
        }else{
            p->next = q;
            p = q;
            q = q->next;
        }
    }
    p->next = NULL;
    return L;
}
//打印
void DisplayTwo(LinkList *L)
{

    LinkList *k = L->next;

    while(k)
    {
        cout<<k->data<<" ";
        k = k->next;
    }
    cout<<endl;
}
int main()
{
    LinkList *L;
    int a[5];
    for(int i=0;i<5;i++)
    {
        cin>>a[i];

    }
    CreateTail(L,a,5);
    Display(L);
    DisplayTwo(L);
    return 0;
}
