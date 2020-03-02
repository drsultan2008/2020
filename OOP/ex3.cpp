#include <bits/stdc++.h>
using namespace std;
template <class T>
class listNum{
private:
	T *list;
	int n;
public:
	listNum():n(0),list(NULL){}
	listNum(int nn){
		n=nn;
		list = new T[n];
	}
	T sum(){
		T res=0;
		for (int i=0; i<n; i++)
			res+=list[i];
		return res;
	}
	T minList(){
		T min=list[0];
		for (int i=1; i<n; i++)
			min=min<list[i]?min:list[i];
		return min;
	}
	T maxList(){
		T max=list[0];
		for (int i=1; i<n; i++)
			max=max>list[i]?max:list[i];
		return max;
	}
	double medium(){
		return (double)sum()/n;
	}
	friend ostream &operator << (ostream &out, listNum &l){
		for (int i=0; i<l.n; i++)	
			out << l.list[i] << " ";
		return out; 
	}
	friend istream &operator >> (istream &in, listNum &l){
		cout << "Nhap n: ";
		in >> l.n;
		l.list= new T[l.n];
		for (int i=0; i<l.n; i++){
			do{
				cout << "Nhap phan tu thu " << i+1 << ":";
				in >> l.list[i];	
			}while ((int)l.list[i]!=l.list[i]);
		}
		return in;
	}
};
class appInt{
private:
	listNum<int> l;
public:
	void run(){
		cin >> l;
		cout << "Tong cac phan tu cua day la: " << l.sum();
		cout << "\nTrung binh cong cac phan tu cua day la: " << l.medium();
		cout << "\nGia tri lon nhat trong day la: " << l.maxList();
		cout << "\nGia tri nho nhat trong day la: " << l.minList();
	}
};
int main(){
	appInt a,b,c;
	cout << "Day a:" << endl;
	a.run();
	cout << "\nDay b: " << endl;
	b.run();
	cout << "\nDay c: " << endl;
	c.run();
}
