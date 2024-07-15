

int cp(const vector<int>& a1,const vector<int>& a2,int target){

    unordered_map<int,int> m1,m2;

    for(int i=0;i<a1.size();++i){
        int s=0;
        for(int j=i;j<a1.size();++j){
            s+=a1[j];
            m1[s]++;
        }
    }

   for(int i=0;i<a2.size();++i){
        int s=0;
        for(int j=i;j<a1.size();++j){
            s+=a2[j];
            m1[s]++;
        }    
    }

    int count=0;

    for(const auto& entry:m1){
        int c=target - entry.first;
        count +=entry.second*m2[c];
    }


    return count;
 
}
