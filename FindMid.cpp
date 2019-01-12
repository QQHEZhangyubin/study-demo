

//�������20��Ԫ�أ������ҳ��м�Ԫ��
//������������ָ�룬���ָ��һ�����������ȿ�ָ���ߵ�ĩβ����ָ�����õ����м�λ��

#include <iostream>
#include<stdlib.h>
using namespace std;
typedef int ElemType;
typedef struct Node
{
    ElemType data;
    Node *next;

}LinkList;

void createTail(LinkList *&l,int a[],int n)
{
    LinkList *e,*r;
    l = (LinkList *)malloc(sizeof(LinkList));
    r = l;
    for(int i=0;i<n;i++)
    {
        e = (LinkList *)malloc(sizeof(LinkList));
        e->data = a[i];
        r->next = e;
        r = e;
    }
    r->next = NULL;

}
void display(LinkList *l)
{
    LinkList *p;
    p = l->next;
    while(p)
    {
        cout<<p->data<<" ";
        p = p->next;
    }
    cout<<endl;
}

LinkList * GetMidNode(LinkList *L)
{
    LinkList *search,*mid;
    mid = search = L;
    while(search->next != NULL)
    {
        if(search->next->next != NULL)
        {
            search = search->next->next;
            mid = mid->next;
        }
        else{
            search = search->next;
        }

    }
    //*e = mid->data;
    return mid;
}

int main()
{
    LinkList *l,*p;
    int a[20];
    for(int i=0;i<20;i++)
    {
        a[i] = i*2+1;
    }
    createTail(l,a,20);
    display(l);
    cout<<GetMidNode(l)<<endl;
    p = GetMidNode(l);
    cout<<"�м�λ�õ�����:";
    cout<<p->data;
    return 0;
}
