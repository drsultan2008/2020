#ifndef vector_cpp
#define vector_cpp 1
#include <bits/stdc++.h>
template <class T>
class vectorItr;
template <class T>
class vector{
private:
	T *vPointer;
	int size;
	int capacity;
public:
	vector();
	vector(const int &n);
	~vector();
	int ins(const T &val, const int &pos);
	int replace(const T&val, const int &pos);
	int del(const int &pos);
	T& get(const int &pos);
	T& operator [](const int &pos);
	template <class U> friend std::ostream &operator << (std::ostream &out, vector<U> v);
	friend class vectorItr<T>;
};
template <class T>
class vectorItr{
private:
	vector<T> *v;
	int curr;
public:
	vectorItr(vector<T> *vv);
	bool isValid();
	void advanced();
	T& recieve();
};
template <class T>
vectorItr<T>::vectorItr(vector<T> *vv){
	v=vv;
	curr=0;
}
template <class T>
bool vectorItr<T>::isValid(){
	return curr< v.size;
}
template <class T> 
void vectorItr<T>::advanced(){
	curr++;
}
template <class T>
T& vectorItr<T>::recieve(){
	return v[curr];
}

template <class T>
vector<T>::vector(){
	vPointer=new T[1] ;
	size=0;
	capacity=1;
}
template <class T>
vector<T>::vector(const int &n){
	vPointer=new T[n];
	size=n;
	capacity=n;
}
template <class T>
vector<T>::~vector(){
	delete [] vPointer;
}
template <class T>
int vector<T>::ins(const T &val, const int &pos){
	if (size>=capacity){
		T *tmp=new T[capacity*2];
		for (int i=0; i<capacity; i++)
			tmp[i]=vPointer[i];
		capacity*=2;
		delete [] vPointer;
		vPointer=tmp;
	}
	for (int i=size; i>pos; i--)
		vPointer[i]=vPointer[i-1];
	vPointer[pos]=val;
	size++;
	return 1;
}
template <class T>
int vector<T>::replace(const T& val, const int &pos){
	vPointer[pos]=val;
	return 1;
}
template <class T>
int vector<T>::del(const int &pos){
	for (int i=pos; i<size; i++)
		vPointer[i]=vPointer[i+1];
	return 1;
	size--;
}
template <class T>
T& vector<T>::get(const int &pos){
	return vPointer[pos];
}
template <class T>
T& vector<T>::operator [](const int &pos){
	return vPointer[pos];
}
template <class U>
std::ostream &operator <<(std::ostream &out, vector<U> v){
	for (int i=0; i<v.size; i++)
		out << v.vPointer[i] << " ";
	return out;
}
#endif
