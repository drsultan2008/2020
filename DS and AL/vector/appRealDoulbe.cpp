#include "vector.cpp"
class realNum{
private:
	vector<double> v;
public:
	int ins(const double &val, const int &pos);
	int rep(const double &val, const int &pos);
	void print();
	double get(const int &pos);
	int del(const double  &pos);
};
int realNum::ins(const double &val, const int &pos){
	return v.ins(val,pos);
}
int realNum::rep(const double &val, const int &pos){
	return v.replace(val,pos);
}
void realNum::print(){
	std::cout << v;
}
double realNum::get(const int &pos){
	return v[pos];
}
int realNum::del(const double &pos){
	return v.del(pos);
}
class app{
private:
	realNum v;
public:
	void run(){
		int key;
	while (key!=5){
		std::cout << "Vector so thuc, moi chon chuc nang: " << std::endl;
		std::cout << "Chen 1 phan tu vao vector bam phim 1" << std::endl;
		std::cout << "Thay the 1 phan tu trong vector bam phim 2" << std::endl;
		std::cout << "Xoa 1 phan tu trong vector bam phim 3" << std::endl;
		std::cout << "In day vector bam phim 4" << std::endl;
		std::cout << "Bam phim 5 de thoat khoi chuong trinh";
		std::cin >> key;
		switch (key){
			case 1:
				double val;
				int pos;
				std::cout << "Nhap so can chen: ";
				std::cin >> val;
				std::cout << "Nhap vi tri chen: ";
				std::cin >> pos;
				v.ins(val,pos);
				break;
			case 2:
				double vv;
				int p;
				std::cout << "Nhap so can thay doi";
				std::cin >> vv;
				std::cout << "Nhap vi tri can thay doi";
				std::cin >> p;
				v.rep(vv,p);
				break;
			case 3:
				int pp;
				std::cout << "Nhap vi tri can xoa";
				std::cin >> pp;
				v.del(pp);
				break;
			case 4:
				v.print();
				break;
			case 5: 
				break;
		}
	}
	}
};
int main(){
	app v;
	v.run();
}
