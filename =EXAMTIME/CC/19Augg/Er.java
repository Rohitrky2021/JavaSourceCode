
int n,p,q;
cin>>n>>p>>q;

vector<int> a(n);

for(auto &x:a){
    cin>>x;
}

sort(a);

while(a.size>2 && p && a.end()[-2]>0){
    int v=a.end()[-1] +a.end()[-2];
    a.popback();
    a.popback();
    a.pushback(v);
    p--;
}

reverese(a);

while(a.size >2 && p && a.end()[-2]<0){
    int v=a.end()[-1] + a.end()[-2];
    a.popback;
    a.popback;
    a.pushback(v);
p--;
}
reverese(a);

while(a.size >2 &&  a.end()[-2]<0 && q){

    a[0]-=a.end()[-2];
    a.erase(a.end()-2);
    q--;
}

reverese(a);

while(a.size >2 &&  a.end()[-2]<0 && q){

    a[0]-=a.end()[-2];
    a.erase(a.end()-2);
    q--;
}

reverese(a);

cout<< a.back()-a.front()<<<endl;

