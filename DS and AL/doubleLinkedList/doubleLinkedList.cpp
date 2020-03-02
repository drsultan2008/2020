#include <bits/stdc++.h>
template <class T>
class DLList;
template <class T>
class DLListItr;
template <class T>
class DLListNode{
private:
	T data;
	DLListNode *next,*prev;
	friend class DLList<T>;
	friend class DLListItr<T>;
public:
	DLListNode():data(),next(NULL),prev(NULL){}
	DLListNode(const T &dt, DLListNode *nxt, DLListNode *prv):data(dt),next(nxt),prev(prv){}
};
template <class T>
class DLListItr{
private:
	DLListNode<T> *curr;
	friend class DLList<T>;
public:
	DLListItr(DLListNode<T> *dl):curr(dl){}
	bool isValid(){return curr!=NULL;}
	void advance(){curr=curr->next;}	
	void deadvance(){curr=curr->prev;}
	T &retrieve(){return curr->data;}	
};
template <class T>
class DLList{
private:
	DLListNode<T> *head;
	int n;
public:
	DLList();
	int ins(const T &val, const int &pos);
	template <class G> friend std::ostream &operator << (std::ostream &out, DLList<T> dl);
	DLListItr<T> zeroth();
	DLListItr<T> first();
};
template <class T>
DLList<T>::DLList(){
	head = new DLListNode<T>;
	n=0;
}	
template <class T>
int DLList<T>::ins(const T &val, const int &pos){
	DLListItr<T> iter=zeroth();
	for (int k=1; k<pos && iter.isValid();k++, iter.advance());
		if (iter.curr){
			iter.curr->next= new DLListNode<T>(val,iter.curr->next,iter.curr->prev);
//			iter.curr->next->prev=iter.curr->next;
		}
	return 1;
}
template <class G>
std::ostream &operator << (std::ostream &out, DLList<G> dl){
	DLListItr<G> iter=dl.first();
	for (;iter.isValid();iter.advance())
		out << iter.retrieve() << " ";
	return out;
}
template <class T>
DLListItr<T> DLList<T>::zeroth(){
	return DLListItr<T>(head);
}
template <class T>
DLListItr<T> DLList<T>::first(){
	return DLListItr<T>(head->next);
}
int main(){
	DLList<int> dl;
	dl.ins(1,1);
	dl.ins(2,2);
	dl.ins(3,2);
	DLListItr<int> iter=dl.first();
	for (;iter.isValid();iter.advance())
		std::cout << iter.retrieve() << " ";
	std:: cout << std:: endl;
	iter=dl.first();
	std:: cout << iter.retrieve() << std::endl;
	iter.deadvance();
	iter.deadvance();
	std:: cout << iter.retrieve() << std::endl;
	
//	iter.deadvance();
//	for (;iter.isValid();iter.deadvance()) 
//		std::cout << iter.retrieve() << " " << std::endl;
//	std:: cout << dl;
}
