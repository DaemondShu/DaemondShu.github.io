  
#include <iostream>
#include <map>
#include <unordered_map> //hash_map
// #include <typeid>
using namespace std;




int main() 
{
    map<int, int> a; //tree map
    // operate by interator
    cout << endl << "--------operate by index--------" << endl;
    a[1] = 2;
    cout << a[1] << endl; 
    cout << a.size() << endl;  //1
    cout << a[2] << endl;  // it will create default value when called by []
    cout << a.size() << endl;  //2
    
    cout << (a.find(2) == a.end()) << endl; //false
    cout << (a.find(3) == a.end()) << endl; //true
    
    
    // operate by interator
    cout << endl << "--------operate by interator--------" << endl;
    
    for (auto it = a.begin(); it != a.end(); it++) {
      cout << it->first << " " << it->second << " " << typeid(it).name() << endl;
    }
    
    
    

    cout << endl << "--------after erase--------" << endl;
    auto it = a.find(1);
    auto ri_key = a.erase(it); //erase iterator
    cout << typeid(ri_key).name() << ri_key->first << " " << ri_key->second << endl;
    auto r_key = a.erase(2); //erase t
    cout << typeid(r_key).name() << endl;
    
    for (auto it = a.begin(); it != a.end(); it++) {
      cout << it->first << " " << it->second << " " << typeid(it).name() << endl;
    }
    
    cout << endl << "--------after insertion--------" << endl;
    a.emplace(3,5); //preferred
    a.insert(pair<int, int>(4,5));
    for (auto it = a.begin(); it != a.end(); it++) {
      cout << it->first << " " << it->second << " " << typeid(it).name() << endl;
    }
    
    
    return 0;
}