// https://onecompiler.com/cpp/3yp8hn2t3
//C++ 14 smart pointer

#include <memory>
#include <iostream>
using namespace std;

//unique_ptr 只允许基础指针的一个所有者
//shared_ptr 采用引用计数的智能指针
//weak_ptr  结合 shared_ptr 使用的特例智能指针。不参与引用计数

int main() {
  
  // unique_ptr
  // wrong unique_ptr<int[]> ua = new int[2];
  // correct, auto ua = make_unique<int[]>(2);
  unique_ptr<int[]> ua(new int[2] {1,2});
  for (int i=0; i<2; i++) {
    cout << ua[i] << " ";
  }
  cout << endl;
  
  // shared_ptr
  shared_ptr<int> si(new int(111));
  shared_ptr<int> si2 = si;
  shared_ptr<int> si3 = si2;
  si3 = si;
  weak_ptr<int> wi = si;
  
  cout << si.use_count() <<endl; //3
  
  
}