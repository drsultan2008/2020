#ifndef linkedList_cpp
#define linkedList_cpp 1
#include <bits/stdc++.h>
template <class T>
class LList;
template <class T>
class LListItr;
template <class T>
class LListNode{
private:
	T data;
	LListNode *next;
	friend class LList<T>;
	friend class LListItr<T>;
public:
	LListNode():data(),next(NULL){}
	LListNode(const T &data, LListNode<T> *next):data(data),next(next){};
};
template <class T>
class LListItr{
private:
	LListNode<T> *curr;
	friend class LList<T>;
public:
	LListItr(LListNode<T> *l):curr(l){}
	bool isValid(){return curr!=NULL;}
	void advance(){curr=curr->next;}
	T& retrieve(){return curr->data;}
};
template <class T>
class LList{
private:
	LListNode<T> *head;
	int n;
public:
	LList();
	int ins(const T &val, const int &pos);
		template <class G> friend std::ostream &operator << (std::ostream &out, LList<T> l);
	LListItr<T> zeroth();
	LListItr<T> first();
	int rep(const T &val, const int &pos);
	int del(const int &pos);
	int size();
	bool isEmpty();
};
template <class T>
bool LList<T>::isEmpty(){
	return n==0;
}
template <class T>
int LList<T>::size(){
	return n;
}
template <class T>
LList<T>::LList(){
	head = new LListNode<T>;
	n=0;
}
template <class T>
int LList<T>::ins(const T &val, const int &pos){
	int k=1;
	LListItr<T> iter=zeroth();
	for (;k<pos && iter.isValid(); k++,iter.advance());
	if (iter.curr){
		iter.curr->next=new LListNode<T>(val,iter.curr->next);
		n++;
		return 1;	
	}
	return 0;
}
template <class T>
LListItr<T> LList<T>::zeroth(){
	return LListItr<T>(head);
}
template <class T>
LListItr<T> LList<T>::first(){
	return LListItr<T>(head->next);
}
template <class G>
std::ostream &operator << (std::ostream &out, LList<G> l){
	LListItr<G> iter=l.first();
	for (;iter.isValid();iter.advance())
		out << iter.retrieve() << " " ;
	return out;
}
template <class T>
int LList<T>::rep(const T &val, const int &pos){
	LListItr<T> iter=first();
	for (int k=1;k<pos && iter.isValid();k++,iter.advance());
		iter.retrieve()=val;
	return 1;
}
template <class T>
int LList<T>::del(const int &pos){
	LListItr<T> iter=zeroth();
	for (int k=1; k<pos && iter.isValid();iter.advance(),k++);
	iter.curr->next=iter.curr->next->next;
	n--;
	return 1;
}
#endif
