/*
*头插法建立一个有序表
*尾插法建立一个有序表
*合并有序表
*
*
*/
#include<stdlib.h>
#include <iostream>
using namespace std;
typedef int ElemType;
typedef struct Node
{
    ElemType data;
    struct Node *next;
}LinkList;

void createHead(LinkList *&L,int a[],int n)
{
    LinkList *e;

    L =(LinkList *)malloc(sizeof(LinkList));
    L->next = NULL;
    for(int i=0;i<n;i++)
    {
        e = (LinkList *)malloc(sizeof(LinkList));
        e->data = a[i];
        e->next = L->next;
        L->next = e;
    }
}

void createTail(LinkList *&L,int a[],int n)
{
    LinkList *r,*e;
    L = (LinkList *)malloc(sizeof(LinkList));

    r = L;
    for(int i = 0;i<n;i++)
    {
        e = (LinkList *)malloc(sizeof(LinkList));
        e->data = a[i];
        r->next = e;
        r = e;
    }
    r->next = NULL;
}

void Display(LinkList *L)
{
    LinkList *p = L->next;
    while(p)
    {
        cout<<p->data<<" ";
        p = p->next;
    }
    cout<<endl;
}
LinkList* mergetwoList(LinkList *l1,LinkList *l2)
{
    LinkList *dummy, *cur;
    dummy = (LinkList *)malloc(sizeof(LinkList));
    cur = dummy;
    while(l1 && l2)
    {
        if(l1->data < l2->data)
        {
            cur->next = l1;
            l1 = l1->next;
        }else{
            cur->next = l2;
            l2 = l2->next;
        }
        cur = cur->next;
    }
    cur->next = l1 ?l1:l2;
    //cout<<"dunmy ="<<dummy<<",dummy->next = "<<dummy->next<<endl;
    return dummy->next;
}
int main()
{
    LinkList *L,*L1,*t;

    int a[5];
    for(int i=0;i<5;i++)
    {
        a[i]=15-i*2;
    }
    createHead(L,a,5);
    cout<<"头插法展示："<<endl;
    Display(L);

    int b[5];
    for(int j=0;j<5;j++)
    {

        b[j] = j+10;
    }
    createTail(L1,b,5);
    cout<<"尾插法展示: "<<endl;
    Display(L1);
    cout<<"有序合并展示:"<<endl;
    t = mergetwoList(L,L1);
    cout<<t<<endl;
    while(t)
    {
        cout<<t->data<<" ";
        t = t->next;
    }
    return 0;
}
