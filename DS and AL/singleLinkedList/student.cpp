#include "linkedListTest.cpp"
class student{
private:
	std::string name,code,dmy;
	double point;
public:
	student():name(""),code(""),dmy(""),point(0){};
	friend std::ostream &operator << (std::ostream &out, const student &st){
		out << "Sinh vien: " << st.name << " ,ma sinh vien: " << st.code << " ,sinh ngay " << st.dmy << ", co diem trung binh la: " << st.point << std::endl;
		return out;
	}
	friend std::istream &operator >> (std::istream &in, student &st){
		std:: cout << "Ho ten: " << std::endl;
		fflush(stdin);
		getline(in,st.name);
		fflush(stdin);
		std::cout << "Ma sinh vien: " << std::endl;
		getline(in,st.code);
		fflush(stdin);
		std::cout << "Nam sinh: " << std::endl;
		getline(in,st.dmy);
		std::cout << "Diem: " ;
		in >> st.point;
		return in;
	}
};
class app{
private:
	LList<student> l;
public:
	int i=0;
	void run(){
		int key;
		student tmp;
		while (key!=5){
			std::system("cls");
			std::cout << "Chuong trinh chay thu nghiem linkedlist" << std::endl;
			std::cout << "Nhap 1 de chen them sinh vien vao danh sach" << std::endl;
			std::cout << "Nhap 2 de thay doi sinh vien thu i" << std::endl;
			std::cout << "Nhap 3 de xoa sinh vien thu i" << std::endl;
			std::cout << "Nhap 4 de in danh sach sinh vien " << std::endl;
			std::cout << "Nhap 5 de ket thuc chuong trinh" << std::endl;
			std::cin >> key;
			switch (key){
				case 1:
					std::cin >> tmp;
					l.ins(tmp,++i);
					break;
				case 2:
					int tmp2;
					std::cout << "Nhap so thu tu sinh vien can thay doi" << std::endl;
					std::cin >> tmp2;
					std::cin >> tmp;
					l.rep(tmp,tmp2);
					break;
				case 3:
					int tmp3;
					std::cout << "Nhap so thu tu sinh vien can xoa" << std::endl;
					l.del(tmp3);
					break;
				case 4: 
					std::cout << l;
					break;
				case 5:
					break;
			}
		}
	}
};
int main(){
	app x;
	x.run();
}
