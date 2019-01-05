#include <iostream>
#include<stdlib.h>
using namespace std;
typedef int  ElemType ;
typedef struct Node
{
    ElemType data;
    Node *next;

}LinkList;

void createTail(LinkList *&l,int a[],int n)
{
    LinkList *r,*e;
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
void Display(LinkList *l)
{
    LinkList *p = l->next;
    while(p)
    {
        cout<<p->data<<" ";
        p = p->next;
    }
    cout<<endl;
}
//ɾ���ڶ������
//�ڶ�������data������������data����
//����һ���ݴ���������������
//ɾ�����������
void DisplayTwo(LinkList *l)
{
     LinkList *p = l->next->next;
     p->data = p->next->data;
     LinkList *tmp = p->next;
     p->next = tmp->next;
     delete tmp;
}
int main()
{
    LinkList *l;
    int a[5],m;
    for(int i=0;i<5;i++)
    {
        cin>>a[i];
    }
    createTail(l,a,5);
    Display(l);
    DisplayTwo(l);
    Display(l);
    return 0;
}
