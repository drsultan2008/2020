#include <bits/stdc++.h>
template <class T>
class LList;
template <class T>
class LListItr;
template <class T>
class node{
private:
	T data;
	node<T> *next;
public:
	node();
	node(const T &data, node<T> *next);
	T& getData();
	node<T>* getNext();
};
template <class T>
node<T>::node(){
	next=NULL;
}
template <class T>
node<T>::node(const T &data, node<T> *next){
	this->data=data;
	this->next=next;
}
template <class T>
T& node<T>::getData(){
	return data;

}
template <class T>
node<T>* node<T>::getNext(){
	return next;
}
template <class T>
class LList{
private:
	node<T> *head;
	int n;
public:
	LList();
	int ins(const T& val, const int &pos);
	int rep(const T& val, const int &pos);
	int del(const int &pos);
	LListItr<T> reroth();
	template <class G> friend std::ostream &operator << (std::ostream &out, LList<G> l);
};
template <class T>
LListItr<T> LList<T>::reroth(){
	return LListItr<T>(head);
}
template <class T>
class LListItr{
private:
	node<T> *curr;
public:
	LListItr();
	LListItr(LList<T> list);
	bool isValid();
	void advanced();
};
template <class T>
LListItr<T>::LListItr(){
	curr=NULL;
}
template <class T>
LListItr<T>::LListItr(LList<T> list){
	curr=list->head;
}
template <class T>
bool LListItr<T>::isValid(){
	return curr!=NULL;
}
template <class T>
void LListItr<T>::advanced(){
	curr=curr->next;
}
template <class T>
LList<T>::LList(){
	head=new node<T>;
	n=0;
}
template <class T>
int LList<T>::ins(const T &val, const int &pos){
	if (pos==1){
		node<T> newNode(val,head);
		*head=newNode;
		n++;
		return 1;
	}
	int k=1;
	LListItr<T> iter=reroth();
	for (;iter.isValid() && k<pos;iter.advanced(),k++);
	if (iter.curr->next)
		iter.curr->next=new node<T>(val,iter.curr->next);
	return 1;
}
template <class T>
int LList<T>::rep(const T &val, const int &pos){
	return 1;
}
template <class T>
int LList<T>::del(const int &pos){
	return 1;
}
template <class G>
std::ostream &operator << (std::ostream &out, LList<G> l){
	LListItr<G> iter=l.reroth();
	for (;iter.isValid();iter.advanced())
		out << iter.curr->data << " ";
	return out;
}
int main(){
	LList<int> l;
	l.ins(1,1);
	std:: cout << l;
}
